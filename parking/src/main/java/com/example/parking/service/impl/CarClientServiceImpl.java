package com.example.parking.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.entity.CarClientEntity;
import com.example.parking.exception.IdUncorrectedRuntimeException;
import com.example.parking.repository.CarClientRepository;
import com.example.parking.service.CarClientService;
import com.example.parking.service.IdServiceUtil;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CarClientServiceImpl implements CarClientService {
	@PersistenceContext
	private EntityManager entityManager;

	private CarClientRepository carClientRepository;

	@Override
	public CarClientEntity save(CarClientEntity carClientEntity) {
		return carClientRepository.save(carClientEntity);
	}

	@Override
	public CarClientEntity findById(Long id) {
		IdServiceUtil.isIdPositive(id);
		Optional<CarClientEntity> carClient = carClientRepository.findById(id);
		if (carClient.isPresent()) {
			return carClient.get();
		}
		throw new IdUncorrectedRuntimeException(IdServiceUtil.UNCORRECTED_ID);
	}

	@Override
	public List<CarClientEntity> findAll() {
		return carClientRepository.findAll();
	}

	@Override
	@Transactional
	public CarClientEntity update(CarClientEntity carClientEntity) {
		return entityManager.merge(carClientEntity);
	}

	@Override
	public void deleteById(Long id) {
		IdServiceUtil.isIdPositive(id);
		carClientRepository.deleteById(id);
	}
}
