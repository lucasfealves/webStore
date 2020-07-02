package br.com.javaChallenge.webStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javaChallenge.webStore.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
