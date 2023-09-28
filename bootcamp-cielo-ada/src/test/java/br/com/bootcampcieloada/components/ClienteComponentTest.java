package br.com.bootcampcieloada.components;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.bootcampcieloada.entidades.Cliente;
import br.com.bootcampcieloada.modelos.ClienteDTO;
import br.com.bootcampcieloada.repositories.ClienteRepository;

@SpringBootTest
class ClienteComponentTest {
	
	@Autowired
	ClienteComponent clienteComponent;
	
	@Mock
	ClienteRepository clienteRepository;

    @Test
    void cadastrarClientePessoaFisica() {

        ClienteDTO cliente1 = ClienteDTO.builder()
                .email("coelho@coelho.com.br")
                .mcc(2345L)
                .nomeCliente("Jonatas Coelho")
                .registroFederal("514.732.250-78")
                .tipoPessoa("PF")
                .build();

        Cliente entity = clienteComponent.cadastrarCliente(cliente1);
        
        
    }
}

