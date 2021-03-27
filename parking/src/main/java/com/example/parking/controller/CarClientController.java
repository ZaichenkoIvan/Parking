package com.example.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.parking.domain.*;
import com.example.parking.service.CarClientService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/carClients")
public class CarClientController {
	private final CarClientService carClientService;

	@GetMapping("/")
	public List<CarClientDTO> showAll() {
		return carClientService.findAll();
	}

	@GetMapping("/{id}")
	public CarClientDTO showById(@PathVariable("id") Long id) {
		return carClientService.findById(id);
	}

	@PostMapping("/")
	public CarClientDTO create(@RequestBody CarClientDTO carClientDTO) {
		return carClientService.save(carClientDTO);
	}

	@PutMapping("/{id}")
	public CarClientDTO edit(@RequestBody CarClientDTO carClientDTO) {
		return carClientService.update(carClientDTO);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		carClientService.deleteById(id);
	}

	@GetMapping("/findClients")
	public List<ClientDTO> findClientsByCarName(@RequestParam String carName) {
		return carClientService.findClientsByCarName(carName);
	}

	@GetMapping("/findCars")
	public List<CarDTO> findCarsByClientName(@RequestParam String clientName) {
		return carClientService.findCarsByClientName(clientName);
	}
}
