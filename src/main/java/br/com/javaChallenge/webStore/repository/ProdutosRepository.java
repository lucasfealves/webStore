package br.com.javaChallenge.webStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javaChallenge.webStore.model.Produto;

public interface ProdutosRepository extends JpaRepository<Produto, Long> {

}
