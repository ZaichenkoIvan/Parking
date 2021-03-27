package com.example.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.parking.domain.ParkingSpaceDTO;
import com.example.parking.service.ParkingSpaceService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/parkingSpaces")
public class ParkingSpaceController {
	private final ParkingSpaceService parkingSpaceService;

	@GetMapping("/")
	public List<ParkingSpaceDTO> showAll() {
		return parkingSpaceService.findAll();
	}

	@GetMapping("/{id}")
	public ParkingSpaceDTO showById(@PathVariable("id") Long id) {
		return parkingSpaceService.findById(id);
	}

	@PostMapping("/")
	public ParkingSpaceDTO create(@RequestBody ParkingSpaceDTO parkingSpaceDTO) {
		return parkingSpaceService.save(parkingSpaceDTO);
	}

	@PutMapping("/{id}")
	public ParkingSpaceDTO edit(@RequestBody ParkingSpaceDTO parkingSpaceDTO) {
		return parkingSpaceService.update(parkingSpaceDTO);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		parkingSpaceService.deleteById(id);
	}
}
