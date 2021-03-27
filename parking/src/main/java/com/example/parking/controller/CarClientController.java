package com.example.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.parking.entity.CarClientEntity;
import com.example.parking.service.CarClientService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/carClients")
public class CarClientController {
	private final CarClientService carClientService;

	@GetMapping("/")
	public List<CarClientEntity> showAll() {
		return carClientService.findAll();
	}

	@GetMapping("/{id}")
	public CarClientEntity showById(@PathVariable("id") Long id) {
		return carClientService.findById(id);
	}

	@PostMapping("/")
	public CarClientEntity create(@RequestBody CarClientEntity carClientEntity) {
		return carClientService.save(carClientEntity);
	}

	@PutMapping("/{id}")
	public CarClientEntity edit(@RequestBody CarClientEntity carClientEntity) {
		return carClientService.update(carClientEntity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		carClientService.deleteById(id);
	}
}
