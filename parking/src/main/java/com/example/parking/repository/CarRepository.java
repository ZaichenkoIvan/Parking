package com.example.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parking.entity.CarEntity;


@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
}
