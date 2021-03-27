package com.example.parking.domain;

import java.util.List;

import com.example.parking.entity.CouponEntity;
import com.example.parking.entity.ParkingEntity;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingSpaceDTO {
	private Long id;

	private ParkingEntity parking;

	private List<CouponEntity> coupons;
}
