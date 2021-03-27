package com.example.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parking.entity.CarClientEntity;


@Repository
public interface CarClientRepository extends JpaRepository<CarClientEntity, Long> {
	List<CarClientEntity> findCarClientEntitiesByCar_Name(String car_name);

	List<CarClientEntity> findCarClientEntitiesByClient_Name(String client_name);
}
