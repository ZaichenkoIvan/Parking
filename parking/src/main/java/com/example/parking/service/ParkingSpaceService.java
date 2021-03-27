package com.example.parking.service;

import java.util.List;

import com.example.parking.domain.ParkingSpaceDTO;


public interface ParkingSpaceService {
	ParkingSpaceDTO save(ParkingSpaceDTO parkingSpaceDTO);

	ParkingSpaceDTO findById(Long id);

	List<ParkingSpaceDTO> findAll();

	ParkingSpaceDTO update(ParkingSpaceDTO parkingSpaceDTO);

	void deleteById(Long id);
}
