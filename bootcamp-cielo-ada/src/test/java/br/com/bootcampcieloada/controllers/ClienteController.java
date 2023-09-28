package br.com.bootcampcieloada.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bootcampcieloada.components.ClienteComponent;
import br.com.bootcampcieloada.modelos.ClienteDTO;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteComponent clienteComponent;

	@GetMapping(path = "/", produces = "application/json")
	public ResponseEntity<?> getClientes() {
		List<ClienteDTO> clientes = clienteComponent.buscarListaCliente();
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}

	@GetMapping(path = "/{registroFederal}", produces = "application/json")
	public ResponseEntity<?> buscarClienteRegistroFederal(@PathVariable String registroFederal) {
		ClienteDTO cliente = clienteComponent.buscarCliente(registroFederal);
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}

	@PostMapping(params = "/", produces = "application/json")
	public ResponseEntity<?> cadastrarCliente(@RequestBody ClienteDTO cliente) {
		ClienteDTO clienteRetorno = clienteComponent.cadastrarCliente(cliente);
		return new ResponseEntity<>(clienteRetorno, HttpStatus.CREATED);
	}

	@PutMapping(params = "/", produces = "application/json")
	public ResponseEntity<?> alterarCliente(@RequestBody ClienteDTO cliente) {
		ClienteDTO clienteRetorno = clienteComponent.alterarCliente(cliente);
		return new ResponseEntity<>(clienteRetorno, HttpStatus.ACCEPTED);
	}

	@DeleteMapping(params = "/{registroFederal}")
	public ResponseEntity<?> deletarCliente(@PathVariable String registroFederal) {
		clienteComponent.buscarCliente(registroFederal);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
