package br.com.javaChallenge.webStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javaChallenge.webStore.model.VendasItens;

public interface VendaItensRepository extends JpaRepository<VendasItens, Long> {

}
