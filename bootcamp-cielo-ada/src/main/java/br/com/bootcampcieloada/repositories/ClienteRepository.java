package br.com.bootcampcieloada.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bootcampcieloada.entidades.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Optional<Cliente> getByRegistroFederal(String registroFederal);


}
