package com.example.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.parking.domain.CarDTO;
import com.example.parking.service.CarService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/cars")
public class CarController {
	private final CarService carService;

	@GetMapping("/")
	public List<CarDTO> showAll() {
		return carService.findAll();
	}

	@GetMapping("/{id}")
	public CarDTO showById(@PathVariable("id") Long id) {
		return carService.findById(id);
	}

	@PostMapping("/")
	public CarDTO create(@RequestBody CarDTO carDTO) {
		return carService.save(carDTO);
	}

	@PutMapping("/{id}")
	public CarDTO edit(@RequestBody CarDTO carDTO) {
		return carService.update(carDTO);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		carService.deleteById(id);
	}

	@PostMapping("/name/{id}")
	public void findByName(@PathVariable("id") String name) {
		carService.findByName(name);
	}
}
