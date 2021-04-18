package com.example.parking.service.impl;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.domain.CarDTO;
import com.example.parking.entity.CarEntity;
import com.example.parking.exception.IdUncorrectedRuntimeException;
import com.example.parking.repository.CarRepository;
import com.example.parking.service.CarService;
import com.example.parking.service.IdServiceUtil;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CarServiceImpl implements CarService {
	@PersistenceContext
	private EntityManager entityManager;

	private CarRepository carRepository;

	private ModelMapper modelMapper;

	@Override
	public CarDTO save(CarDTO carDTO) {
		CarEntity carEntity = mapCarDTOToEntity(carDTO);
		return mapCarEntityToDTO(carRepository.save(carEntity));
	}

	@Override
	public CarDTO findById(Long id) {
		IdServiceUtil.isIdPositive(id);
		Optional<CarEntity> car = carRepository.findById(id);
		if (car.isPresent()) {
			return mapCarEntityToDTO(car.get());
		}
		throw new IdUncorrectedRuntimeException(IdServiceUtil.UNCORRECTED_ID);
	}

	@Override
	public List<CarDTO> findAll() {
		List<CarEntity> carEntities = carRepository.findAll();
		List<CarDTO> carClientDTOS = new ArrayList<>();
		for (CarEntity carEntity : carEntities) {
			carClientDTOS.add(mapCarEntityToDTO(carEntity));
		}
		return carClientDTOS;
	}

	@Override
	public CarDTO findByName(String name) {
		CarEntity carEntity = carRepository.findByName(name).orElse(new CarEntity());
		return mapCarEntityToDTO(carEntity);
	}

	@Override
	@Transactional
	public CarDTO update(CarDTO carDTO) {
		CarEntity carEntity = mapCarDTOToEntity(carDTO);
		return mapCarEntityToDTO(entityManager.merge(carEntity));
	}

	@Override
	public void deleteById(Long id) {
		IdServiceUtil.isIdPositive(id);
		carRepository.deleteById(id);
	}



	private CarDTO mapCarEntityToDTO(CarEntity carEntity) {
		return modelMapper.map(carEntity, CarDTO.class);
	}

	private CarEntity mapCarDTOToEntity(CarDTO carDTO) {
		return modelMapper.map(carDTO, CarEntity.class);
	}
}
