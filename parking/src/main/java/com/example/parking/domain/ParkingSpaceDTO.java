package com.example.parking.domain;

import java.util.List;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingSpaceDTO {
	private Long id;

	private ParkingDTO parking;

	private List<CouponDTO> coupons;
}
