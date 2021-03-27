package com.example.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.parking.entity.CarEntity;
import com.example.parking.service.CarService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/cars")
public class CarController {
	private final CarService carService;

	@GetMapping("/")
	public List<CarEntity> showAll() {
		return carService.findAll();
	}

	@GetMapping("/{id}")
	public CarEntity showById(@PathVariable("id") Long id) {
		return carService.findById(id);
	}

	@PostMapping("/")
	public CarEntity create(@RequestBody CarEntity carEntity) {
		return carService.save(carEntity);
	}

	@PutMapping("/{id}")
	public CarEntity edit(@RequestBody CarEntity carEntity) {
		return carService.update(carEntity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		carService.deleteById(id);
	}
}
