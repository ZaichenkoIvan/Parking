package com.example.parking.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.entity.ParkingEntity;
import com.example.parking.exception.IdUncorrectedRuntimeException;
import com.example.parking.repository.ParkingRepository;
import com.example.parking.service.IdServiceUtil;
import com.example.parking.service.ParkingService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ParkingServiceImpl implements ParkingService {
	@PersistenceContext
	private EntityManager entityManager;

	private ParkingRepository parkingRepository;

	@Override
	public ParkingEntity save(ParkingEntity parkingEntity) {
		return parkingRepository.save(parkingEntity);
	}

	@Override
	public ParkingEntity findById(Long id) {
		IdServiceUtil.isIdPositive(id);
		Optional<ParkingEntity> parkingEntity = parkingRepository.findById(id);
		if (parkingEntity.isPresent()) {
			return parkingEntity.get();
		}
		throw new IdUncorrectedRuntimeException(IdServiceUtil.UNCORRECTED_ID);
	}

	@Override
	public List<ParkingEntity> findAll() {
		return parkingRepository.findAll();
	}

	@Override
	@Transactional
	public ParkingEntity update(ParkingEntity parkingEntity) {
		return entityManager.merge(parkingEntity);
	}

	@Override
	public void deleteById(Long id) {
		IdServiceUtil.isIdPositive(id);
		parkingRepository.deleteById(id);
	}

}
