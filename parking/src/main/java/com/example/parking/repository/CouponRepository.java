package com.example.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parking.entity.CouponEntity;


@Repository
public interface CouponRepository extends JpaRepository<CouponEntity, Long> {
}
