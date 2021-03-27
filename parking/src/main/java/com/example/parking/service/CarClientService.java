package com.example.parking.service;

import java.util.List;

import com.example.parking.entity.CarClientEntity;


public interface CarClientService {
	CarClientEntity save(CarClientEntity carClientEntity);

	CarClientEntity findById(Long id);

	List<CarClientEntity> findAll();

	CarClientEntity update(CarClientEntity carClientEntity);

	void deleteById(Long id);
}
