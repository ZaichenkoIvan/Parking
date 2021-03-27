package com.example.parking.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.entity.ParkingSpaceEntity;
import com.example.parking.exception.IdUncorrectedRuntimeException;
import com.example.parking.repository.ParkingSpaceRepository;
import com.example.parking.service.IdServiceUtil;
import com.example.parking.service.ParkingSpaceService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ParkingSpaceServiceImpl implements ParkingSpaceService {
	@PersistenceContext
	private EntityManager entityManager;

	private ParkingSpaceRepository parkingSpaceRepository;

	@Override
	public ParkingSpaceEntity save(ParkingSpaceEntity parkingSpaceEntity) {
		return parkingSpaceRepository.save(parkingSpaceEntity);
	}

	@Override
	public ParkingSpaceEntity findById(Long id) {
		IdServiceUtil.isIdPositive(id);
		Optional<ParkingSpaceEntity> parkingSpaceEntity = parkingSpaceRepository.findById(id);
		if (parkingSpaceEntity.isPresent()) {
			return parkingSpaceEntity.get();
		}
		throw new IdUncorrectedRuntimeException(IdServiceUtil.UNCORRECTED_ID);
	}

	@Override
	public List<ParkingSpaceEntity> findAll() {
		return parkingSpaceRepository.findAll();
	}

	@Override
	@Transactional
	public ParkingSpaceEntity update(ParkingSpaceEntity parkingSpaceEntity) {
		return entityManager.merge(parkingSpaceEntity);
	}

	@Override
	public void deleteById(Long id) {
		IdServiceUtil.isIdPositive(id);
		parkingSpaceRepository.deleteById(id);
	}
}
