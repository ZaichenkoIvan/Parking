package com.example.parking.service;

import java.util.List;

import com.example.parking.domain.CouponDTO;


public interface CouponService {
	CouponDTO save(CouponDTO couponDTO);

	CouponDTO findById(Long id);

	List<CouponDTO> findAll();

	CouponDTO update(CouponDTO couponDTO);

	void deleteById(Long id);
}
