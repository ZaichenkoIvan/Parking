package com.example.parking.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public ClientEntity save(ClientEntity clientEntity) {
		return clientRepository.save(clientEntity);
	}

	@Override
	public ClientEntity findById(Long id) {
		IdServiceUtil.isIdPositive(id);
		Optional<ClientEntity> clientEntity = clientRepository.findById(id);
		if (clientEntity.isPresent()) {
			return clientEntity.get();
		}
		throw new IdUncorrectedRuntimeException(IdServiceUtil.UNCORRECTED_ID);
	}

	@Override
	public List<ClientEntity> findAll() {
		return clientRepository.findAll();
	}

	@Override
	@Transactional
	public ClientEntity update(ClientEntity clientEntity) {
		return entityManager.merge(clientEntity);
	}

	@Override
	public void deleteById(Long id) {
		IdServiceUtil.isIdPositive(id);
		clientRepository.deleteById(id);
	}
}
