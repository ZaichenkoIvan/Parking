package com.example.parking.domain;

import java.util.List;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDTO {
	private Long id;

	private String name;

	private List<CouponDTO> coupons;
}
