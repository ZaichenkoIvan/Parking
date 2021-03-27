package com.example.parking.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public CarEntity save(CarEntity carEntity) {
		return carRepository.save(carEntity);
	}

	@Override
	public CarEntity findById(Long id) {
		IdServiceUtil.isIdPositive(id);
		Optional<CarEntity> car = carRepository.findById(id);
		if (car.isPresent()) {
			return car.get();
		}
		throw new IdUncorrectedRuntimeException(IdServiceUtil.UNCORRECTED_ID);
	}

	@Override
	public List<CarEntity> findAll() {
		return carRepository.findAll();
	}

	@Override
	@Transactional
	public CarEntity update(CarEntity carEntity) {
		return entityManager.merge(carEntity);
	}

	@Override
	public void deleteById(Long id) {
		IdServiceUtil.isIdPositive(id);
		carRepository.deleteById(id);
	}
}
