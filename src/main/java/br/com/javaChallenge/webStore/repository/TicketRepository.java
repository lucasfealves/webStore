package br.com.javaChallenge.webStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javaChallenge.webStore.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
