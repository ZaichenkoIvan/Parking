package com.example.parking.service;

import java.util.List;

import com.example.parking.domain.CarClientDTO;


public interface CarClientService {
	CarClientDTO save(CarClientDTO carClientDTO);

	CarClientDTO findById(Long id);

	List<CarClientDTO> findAll();

	CarClientDTO update(CarClientDTO carClientEntity);

	void deleteById(Long id);
}
