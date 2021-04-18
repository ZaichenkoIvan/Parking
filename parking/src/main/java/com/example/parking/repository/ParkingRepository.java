package com.example.parking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parking.entity.ParkingEntity;


@Repository
public interface ParkingRepository extends JpaRepository<ParkingEntity, Long> {
	Optional<ParkingEntity> findByName(String name);
}
