package com.example.parking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parking.entity.ClientEntity;


@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
	Optional<ClientEntity> findByName(String name);
}
