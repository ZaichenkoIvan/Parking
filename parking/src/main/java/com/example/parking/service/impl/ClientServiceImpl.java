package com.example.parking.service.impl;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.domain.ClientDTO;
import com.example.parking.entity.ClientEntity;
import com.example.parking.exception.IdUncorrectedRuntimeException;
import com.example.parking.repository.ClientRepository;
import com.example.parking.service.ClientService;
import com.example.parking.service.IdServiceUtil;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientServiceImpl implements ClientService {
	@PersistenceContext
	private EntityManager entityManager;

	private ClientRepository clientRepository;

	private ModelMapper modelMapper;

	@Override
	public ClientDTO save(ClientDTO clientDTO) {
		ClientEntity clientEntity = mapClientDTOToEntity(clientDTO);
		return mapClientEntityToDTO(clientRepository.save(clientEntity));
	}

	@Override
	public ClientDTO findById(Long id) {
		IdServiceUtil.isIdPositive(id);
		Optional<ClientEntity> clientEntity = clientRepository.findById(id);
		if (clientEntity.isPresent()) {
			return mapClientEntityToDTO(clientEntity.get());
		}
		throw new IdUncorrectedRuntimeException(IdServiceUtil.UNCORRECTED_ID);
	}

	@Override
	public List<ClientDTO> findAll() {
		List<ClientEntity> clientEntities = clientRepository.findAll();
		List<ClientDTO> clientDTOS = new ArrayList<>();
		for (ClientEntity clientEntity : clientEntities) {
			clientDTOS.add(mapClientEntityToDTO(clientEntity));
		}
		return clientDTOS;
	}

	@Override
	@Transactional
	public ClientDTO update(ClientDTO clientDTO) {
		ClientEntity clientEntity = mapClientDTOToEntity(clientDTO);
		return mapClientEntityToDTO(entityManager.merge(clientEntity));
	}

	@Override
	public void deleteById(Long id) {
		IdServiceUtil.isIdPositive(id);
		clientRepository.deleteById(id);
	}

	private ClientDTO mapClientEntityToDTO(ClientEntity clientEntity) {
		return modelMapper.map(clientEntity, ClientDTO.class);
	}

	private ClientEntity mapClientDTOToEntity(ClientDTO clientDTO) {
		return modelMapper.map(clientDTO, ClientEntity.class);
	}
}
