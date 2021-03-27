package com.example.parking.service;

import java.util.List;

import com.example.parking.entity.ParkingSpaceEntity;


public interface ParkingSpaceService {
	ParkingSpaceEntity save(ParkingSpaceEntity parkingSpaceEntity);

	ParkingSpaceEntity findById(Long id);

	List<ParkingSpaceEntity> findAll();

	ParkingSpaceEntity update(ParkingSpaceEntity parkingSpaceEntity);

	void deleteById(Long id);
}
