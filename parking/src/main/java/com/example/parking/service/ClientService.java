package com.example.parking.service;

import java.util.List;

import com.example.parking.entity.ClientEntity;


public interface ClientService {
	ClientEntity save(ClientEntity clientEntity);

	ClientEntity findById(Long id);

	List<ClientEntity> findAll();

	ClientEntity update(ClientEntity clientEntity);

	void deleteById(Long id);
}
