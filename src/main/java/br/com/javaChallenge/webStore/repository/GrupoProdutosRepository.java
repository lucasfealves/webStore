package br.com.javaChallenge.webStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javaChallenge.webStore.model.GrupoProduto;

public interface GrupoProdutosRepository extends JpaRepository<GrupoProduto, Long> {

}
