package br.com.bootcampcieloada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bootcampcieloada.entidades.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {


}
