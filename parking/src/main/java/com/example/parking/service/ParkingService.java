package com.example.parking.service;

import java.util.List;

import com.example.parking.domain.ParkingDTO;


public interface ParkingService {
	ParkingDTO save(ParkingDTO parkingDTO);

	ParkingDTO findById(Long id);

	List<ParkingDTO> findAll();

	ParkingDTO update(ParkingDTO parkingDTO);

	void deleteById(Long id);
}
