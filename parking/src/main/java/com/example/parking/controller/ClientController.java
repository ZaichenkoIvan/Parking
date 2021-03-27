package com.example.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.parking.domain.ClientDTO;
import com.example.parking.service.ClientService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/clients")
public class ClientController {
	private final ClientService clientService;

	@GetMapping("/")
	public List<ClientDTO> showAll() {
		return clientService.findAll();
	}

	@GetMapping("/{id}")
	public ClientDTO showById(@PathVariable("id") Long id) {
		return clientService.findById(id);
	}

	@PostMapping("/")
	public ClientDTO create(@RequestBody ClientDTO clientDTO) {
		return clientService.save(clientDTO);
	}

	@PutMapping("/{id}")
	public ClientDTO edit(@RequestBody ClientDTO clientDTO) {
		return clientService.update(clientDTO);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		clientService.deleteById(id);
	}
}
