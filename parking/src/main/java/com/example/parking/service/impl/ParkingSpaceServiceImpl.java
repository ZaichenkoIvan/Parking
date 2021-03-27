package com.example.parking.service.impl;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.domain.ParkingSpaceDTO;
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

	private ModelMapper modelMapper;

	@Override
	public ParkingSpaceDTO save(ParkingSpaceDTO parkingSpaceDTO) {
		ParkingSpaceEntity parkingSpaceEntity = mapParkingSpaceDTOToEntity(parkingSpaceDTO);
		return mapParkingSpaceEntityToDTO(parkingSpaceRepository.save(parkingSpaceEntity));
	}

	@Override
	public ParkingSpaceDTO findById(Long id) {
		IdServiceUtil.isIdPositive(id);
		Optional<ParkingSpaceEntity> parkingSpaceEntity = parkingSpaceRepository.findById(id);
		if (parkingSpaceEntity.isPresent()) {
			return mapParkingSpaceEntityToDTO(parkingSpaceEntity.get());
		}
		throw new IdUncorrectedRuntimeException(IdServiceUtil.UNCORRECTED_ID);
	}

	@Override
	public List<ParkingSpaceDTO> findAll() {
		List<ParkingSpaceEntity> parkingSpaceEntities = parkingSpaceRepository.findAll();
		List<ParkingSpaceDTO> parkingSpaceDTOS = new ArrayList<>();
		for (ParkingSpaceEntity parkingSpaceEntity : parkingSpaceEntities) {
			parkingSpaceDTOS.add(mapParkingSpaceEntityToDTO(parkingSpaceEntity));
		}
		return parkingSpaceDTOS;
	}

	@Override
	@Transactional
	public ParkingSpaceDTO update(ParkingSpaceDTO parkingSpaceDTO) {
		ParkingSpaceEntity parkingSpaceEntity = mapParkingSpaceDTOToEntity(parkingSpaceDTO);
		return mapParkingSpaceEntityToDTO(entityManager.merge(parkingSpaceEntity));
	}

	@Override
	public void deleteById(Long id) {
		IdServiceUtil.isIdPositive(id);
		parkingSpaceRepository.deleteById(id);
	}

	private ParkingSpaceDTO mapParkingSpaceEntityToDTO(ParkingSpaceEntity parkingSpaceEntity) {
		return modelMapper.map(parkingSpaceEntity, ParkingSpaceDTO.class);
	}

	private ParkingSpaceEntity mapParkingSpaceDTOToEntity(ParkingSpaceDTO parkingSpaceDTO) {
		return modelMapper.map(parkingSpaceDTO, ParkingSpaceEntity.class);
	}
}
