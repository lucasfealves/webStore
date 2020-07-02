package br.com.javaChallenge.webStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javaChallenge.webStore.model.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

}
