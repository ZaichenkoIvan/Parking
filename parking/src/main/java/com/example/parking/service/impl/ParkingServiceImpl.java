package com.example.parking.service.impl;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.domain.ParkingDTO;
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

	private ModelMapper modelMapper;

	@Override
	public ParkingDTO save(ParkingDTO parkingDTO) {
		ParkingEntity parkingEntity = mapParkingDTOToEntity(parkingDTO);
		return mapParkingEntityToDTO(parkingRepository.save(parkingEntity));
	}

	@Override
	public ParkingDTO findById(Long id) {
		IdServiceUtil.isIdPositive(id);
		Optional<ParkingEntity> parkingEntity = parkingRepository.findById(id);
		if (parkingEntity.isPresent()) {
			return mapParkingEntityToDTO(parkingEntity.get());
		}
		throw new IdUncorrectedRuntimeException(IdServiceUtil.UNCORRECTED_ID);
	}

	@Override
	public List<ParkingDTO> findAll() {
		List<ParkingEntity> parkingEntities = parkingRepository.findAll();
		List<ParkingDTO> parkingDTOS = new ArrayList<>();
		for (ParkingEntity parkingEntity : parkingEntities) {
			parkingDTOS.add(mapParkingEntityToDTO(parkingEntity));
		}
		return parkingDTOS;
	}

	@Override
	@Transactional
	public ParkingDTO update(ParkingDTO parkingDTO) {
		ParkingEntity parkingEntity = mapParkingDTOToEntity(parkingDTO);
		return mapParkingEntityToDTO(entityManager.merge(parkingEntity));
	}

	@Override
	public void deleteById(Long id) {
		IdServiceUtil.isIdPositive(id);
		parkingRepository.deleteById(id);
	}

	private ParkingDTO mapParkingEntityToDTO(ParkingEntity parkingEntity) {
		return modelMapper.map(parkingEntity, ParkingDTO.class);
	}

	private ParkingEntity mapParkingDTOToEntity(ParkingDTO parkingDTO) {
		return modelMapper.map(parkingDTO, ParkingEntity.class);
	}

}
