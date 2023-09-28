package br.com.bootcampcieloada.components;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bootcampcieloada.entidades.Cliente;
import br.com.bootcampcieloada.modelos.ClienteDTO;
import br.com.bootcampcieloada.modelos.ClienteDTOBuilder;
import br.com.bootcampcieloada.repositories.ClienteRepository;

@Component
public class ClienteComponent {

	@Autowired
	public ClienteRepository clienteRepository;

	public ClienteDTO cadastrarCliente(@Valid ClienteDTO cliente) {
		Cliente entity = ClienteDTOBuilder.builBack(cliente);
		clienteRepository.save(entity);
		return cliente;
	}

	public List<ClienteDTO> buscarListaCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	public ClienteDTO buscarCliente(String registroFederal) {
		// TODO Auto-generated method stub
		return null;
	}

	public ClienteDTO alterarCliente(ClienteDTO cliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
