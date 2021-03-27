package com.example.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.parking.entity.CouponEntity;
import com.example.parking.service.CouponService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/coupons")
public class CouponController {
	private final CouponService couponService;

	@GetMapping("/")
	public List<CouponEntity> showAll() {
		return couponService.findAll();
	}

	@GetMapping("/{id}")
	public CouponEntity showById(@PathVariable("id") Long id) {
		return couponService.findById(id);
	}

	@PostMapping("/")
	public CouponEntity create(@RequestBody CouponEntity couponEntity) {
		return couponService.save(couponEntity);
	}

	@PutMapping("/{id}")
	public CouponEntity edit(@RequestBody CouponEntity couponEntity) {
		return couponService.update(couponEntity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		couponService.deleteById(id);
	}
}
