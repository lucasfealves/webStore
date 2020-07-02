package br.com.javaChallenge.webStore.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.javaChallenge.webStore.model.Ticket;
import br.com.javaChallenge.webStore.repository.TicketRepository;

@RestController
@CrossOrigin("${origem-permitida}")
public class TicketResource {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@GetMapping("/ticket")
	public List<Ticket> listar() {
		return ticketRepository.findAll();
	}
	
	@GetMapping("/ticket/{ticket}")
	public Ticket editar(@PathVariable Long ticket) {
		return ticketRepository.findById(ticket).get();
	}

	@PostMapping("/ticket")
	public Ticket adicionar(@RequestBody @Valid Ticket T) {
		return ticketRepository.save(T);
	}
}
