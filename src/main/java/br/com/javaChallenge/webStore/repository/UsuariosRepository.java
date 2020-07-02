package br.com.javaChallenge.webStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javaChallenge.webStore.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Long> {

}
