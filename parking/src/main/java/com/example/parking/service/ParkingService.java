package com.example.parking.service;

import java.util.List;

import com.example.parking.entity.ParkingEntity;


public interface ParkingService {
	ParkingEntity save(ParkingEntity parkingEntity);

	ParkingEntity findById(Long id);

	List<ParkingEntity> findAll();

	ParkingEntity update(ParkingEntity parkingEntity);

	void deleteById(Long id);
}
