package com.example.parking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parking.entity.ParkingSpaceEntity;


@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpaceEntity, Long> {
	Optional<ParkingSpaceEntity> findByName(String name);
}
