package com.example.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.parking.entity.ClientEntity;
import com.example.parking.service.ClientService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/clients")
public class ClientController {
	private final ClientService clientService;

	@GetMapping("/")
	public List<ClientEntity> showAll() {
		return clientService.findAll();
	}

	@GetMapping("/{id}")
	public ClientEntity showById(@PathVariable("id") Long id) {
		return clientService.findById(id);
	}

	@PostMapping("/")
	public ClientEntity create(@RequestBody ClientEntity clientEntity) {
		return clientService.save(clientEntity);
	}

	@PutMapping("/{id}")
	public ClientEntity edit(@RequestBody ClientEntity clientEntity) {
		return clientService.update(clientEntity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		clientService.deleteById(id);
	}
}
