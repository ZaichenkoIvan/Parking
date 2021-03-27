package com.example.parking.service;

import java.util.List;

import com.example.parking.entity.CarEntity;


public interface CarService {
	CarEntity save(CarEntity carEntity);

	CarEntity findById(Long id);

	List<CarEntity> findAll();

	CarEntity update(CarEntity carEntity);

	void deleteById(Long id);
}
