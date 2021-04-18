package com.example.parking.service;

import java.util.List;

import com.example.parking.domain.CarDTO;


public interface CarService {
	CarDTO save(CarDTO carDTO);

	CarDTO findById(Long id);

	List<CarDTO> findAll();

	CarDTO findByName(String name);

	CarDTO update(CarDTO carDTO);

	void deleteById(Long id);
}
