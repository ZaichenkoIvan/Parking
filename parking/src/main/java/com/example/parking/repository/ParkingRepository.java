package com.example.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parking.entity.ParkingEntity;


@Repository
public interface ParkingRepository extends JpaRepository<ParkingEntity, Long> {
}
