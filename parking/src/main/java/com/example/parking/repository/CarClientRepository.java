package com.example.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parking.entity.CarClientEntity;


@Repository
public interface CarClientRepository extends JpaRepository<CarClientEntity, Long> {
}
