package com.example.parking.domain;

import java.util.List;

import com.example.parking.entity.CouponEntity;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDTO {
	private Long id;

	private String name;

	private List<CouponEntity> coupons;
}
