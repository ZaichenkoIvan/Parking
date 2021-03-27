package com.example.parking.service.impl;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.domain.CarClientDTO;
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

	private ModelMapper modelMapper;

	@Override
	public CarClientDTO save(CarClientDTO carClientDTO) {
		CarClientEntity carClientEntity = mapCarClientDTOToEntity(carClientDTO);
		return mapCarClientEntityToDTO(carClientRepository.save(carClientEntity));
	}

	@Override
	public CarClientDTO findById(Long id) {
		IdServiceUtil.isIdPositive(id);
		Optional<CarClientEntity> carClient = carClientRepository.findById(id);
		if (carClient.isPresent()) {
			return mapCarClientEntityToDTO(carClient.get());
		}
		throw new IdUncorrectedRuntimeException(IdServiceUtil.UNCORRECTED_ID);
	}

	@Override
	public List<CarClientDTO> findAll() {
		List<CarClientEntity> carClientsEntities = carClientRepository.findAll();
		List<CarClientDTO> carClientDTOs = new ArrayList<>();
		for (CarClientEntity carClientsEntity : carClientsEntities) {
			carClientDTOs.add(mapCarClientEntityToDTO(carClientsEntity));
		}
		return carClientDTOs;
	}

	@Override
	@Transactional
	public CarClientDTO update(CarClientDTO carClientDTO) {
		CarClientEntity carClientEntity = mapCarClientDTOToEntity(carClientDTO);
		return mapCarClientEntityToDTO(entityManager.merge(carClientEntity));
	}

	@Override
	public void deleteById(Long id) {
		IdServiceUtil.isIdPositive(id);
		carClientRepository.deleteById(id);
	}

	private CarClientDTO mapCarClientEntityToDTO(CarClientEntity carClientEntity) {
		return modelMapper.map(carClientEntity, CarClientDTO.class);
	}

	private CarClientEntity mapCarClientDTOToEntity(CarClientDTO carClientDTO) {
		return modelMapper.map(carClientDTO, CarClientEntity.class);
	}
}
