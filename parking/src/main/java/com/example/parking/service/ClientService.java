package com.example.parking.service;

import java.util.List;

import com.example.parking.domain.ClientDTO;


public interface ClientService {
	ClientDTO save(ClientDTO clientDTO);

	ClientDTO findById(Long id);

	List<ClientDTO> findAll();

	ClientDTO update(ClientDTO clientDTO);

	void deleteById(Long id);
}
