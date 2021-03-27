package com.example.parking.service;

import java.util.List;

import com.example.parking.entity.CouponEntity;


public interface CouponService {
	CouponEntity save(CouponEntity couponEntity);

	CouponEntity findById(Long id);

	List<CouponEntity> findAll();

	CouponEntity update(CouponEntity couponEntity);

	void deleteById(Long id);
}
