package com.example.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.parking.domain.ParkingDTO;
import com.example.parking.service.ParkingService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/parkings")
public class ParkingController {
	private final ParkingService parkingService;

	@GetMapping("/")
	public List<ParkingDTO> showAll() {
		return parkingService.findAll();
	}

	@GetMapping("/{id}")
	public ParkingDTO showById(@PathVariable("id") Long id) {
		return parkingService.findById(id);
	}

	@PostMapping("/")
	public ParkingDTO create(@RequestBody ParkingDTO parkingDTO) {
		return parkingService.save(parkingDTO);
	}

	@PutMapping("/{id}")
	public ParkingDTO edit(@RequestBody ParkingDTO parkingDTO) {
		return parkingService.update(parkingDTO);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		parkingService.deleteById(id);
	}
}
