package com.example.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.parking.domain.CouponDTO;
import com.example.parking.entity.CouponEntity;
import com.example.parking.service.CouponService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/coupons")
public class CouponController {
	private final CouponService couponService;

	@GetMapping("/")
	public List<CouponDTO> showAll() {
		return couponService.findAll();
	}

	@GetMapping("/{id}")
	public CouponDTO showById(@PathVariable("id") Long id) {
		return couponService.findById(id);
	}

	@PostMapping("/")
	public CouponDTO create(@RequestBody CouponDTO couponDTO) {
		return couponService.save(couponDTO);
	}

	@PutMapping("/{id}")
	public CouponDTO edit(@RequestBody CouponDTO couponDTO) {
		return couponService.update(couponDTO);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		couponService.deleteById(id);
	}
}
