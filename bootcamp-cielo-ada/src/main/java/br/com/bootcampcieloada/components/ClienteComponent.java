package br.com.bootcampcieloada.components;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bootcampcieloada.entidades.Cliente;
import br.com.bootcampcieloada.enums.TipoPessoa;
import br.com.bootcampcieloada.modelos.ClienteDTO;
import br.com.bootcampcieloada.modelos.ClienteDTOBuilder;
import br.com.bootcampcieloada.repositories.ClienteRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ClienteComponent {

	@Autowired
	public ClienteRepository clienteRepository;

	public ClienteDTO cadastrarCliente(@Valid ClienteDTO cliente) {
			validarClienteCadastrado(cliente.getRegistroFederal());
			Cliente entity = ClienteDTOBuilder.buildBack(cliente);
			return ClienteDTOBuilder.build(clienteRepository.save(entity));
	}

	private void validarClienteCadastrado(String registroFederal) {
		Optional<Cliente> optional = clienteRepository.getByRegistroFederal(registroFederal);
		if(optional.isPresent()) {
			log.error("#### Cliente com registro federal: {} já cadastrado!",registroFederal );
			throw new IllegalArgumentException("Cliente Já cadastrado");
		}
	}

	public List<ClienteDTO> buscarListaCliente() {
		return ClienteDTOBuilder.build(clienteRepository.findAll());
	}

	public ClienteDTO buscarCliente(String registroFederal) {
		Optional<Cliente> optional = clienteRepository.getByRegistroFederal(registroFederal);
		if(optional.isEmpty()) return null;
		return ClienteDTOBuilder.build(optional.get());
	}

	public ClienteDTO alterarCliente(@Valid ClienteDTO cliente) {

		Cliente entity = validarClienteIsCadastrado(cliente.getRegistroFederal());
		atualizarCliente(entity, cliente);
		
		return ClienteDTOBuilder.build(clienteRepository.saveAndFlush(entity));
	}

	private void atualizarCliente(Cliente entity, ClienteDTO cliente) {
		entity.setEmail(cliente.getEmail());
		entity.setMcc(cliente.getMcc());
		entity.setNomeCliente(cliente.getNomeCliente());
		entity.setRegistroFederal(cliente.getRegistroFederal());
		entity.setTipoPessoa(TipoPessoa.getEnum(cliente.getTipoPessoa()));
	}

	public void deletarCliente(String registroFederal) {
		Cliente entity = validarClienteIsCadastrado(registroFederal);
		clienteRepository.delete(entity);
	}
	
	private Cliente validarClienteIsCadastrado(String registroFederal) {
		Optional<Cliente> optional = clienteRepository.getByRegistroFederal(registroFederal);
		if(optional.isEmpty())
			throw new IllegalArgumentException("Cliente não cadastrado");

		return optional.get();
	}

}
