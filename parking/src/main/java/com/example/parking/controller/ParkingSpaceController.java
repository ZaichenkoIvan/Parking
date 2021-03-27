package com.example.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.parking.entity.ParkingSpaceEntity;
import com.example.parking.service.ParkingSpaceService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/parkingSpaces")
public class ParkingSpaceController {
	private final ParkingSpaceService parkingSpaceService;

	@GetMapping("/")
	public List<ParkingSpaceEntity> showAll() {
		return parkingSpaceService.findAll();
	}

	@GetMapping("/{id}")
	public ParkingSpaceEntity showById(@PathVariable("id") Long id) {
		return parkingSpaceService.findById(id);
	}

	@PostMapping("/")
	public ParkingSpaceEntity create(@RequestBody ParkingSpaceEntity parkingSpaceEntity) {
		return parkingSpaceService.save(parkingSpaceEntity);
	}

	@PutMapping("/{id}")
	public ParkingSpaceEntity edit(@RequestBody ParkingSpaceEntity parkingSpaceEntity) {
		return parkingSpaceService.update(parkingSpaceEntity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		parkingSpaceService.deleteById(id);
	}
}
