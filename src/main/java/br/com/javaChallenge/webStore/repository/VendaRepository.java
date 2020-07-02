package br.com.javaChallenge.webStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javaChallenge.webStore.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

}
