package com.example.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.parking.entity.ParkingEntity;
import com.example.parking.service.ParkingService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/parkings")
public class ParkingController {
	private final ParkingService parkingService;

	@GetMapping("/")
	public List<ParkingEntity> showAll() {
		return parkingService.findAll();
	}

	@GetMapping("/{id}")
	public ParkingEntity showById(@PathVariable("id") Long id) {
		return parkingService.findById(id);
	}

	@PostMapping("/")
	public ParkingEntity create(@RequestBody ParkingEntity parkingEntity) {
		return parkingService.save(parkingEntity);
	}

	@PutMapping("/{id}")
	public ParkingEntity edit(@RequestBody ParkingEntity parkingEntity) {
		return parkingService.update(parkingEntity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		parkingService.deleteById(id);
	}
}
