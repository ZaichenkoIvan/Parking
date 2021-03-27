package com.example.parking.domain;

import java.time.LocalDate;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponDTO {
	private Long id;

	private CarDTO car;

	private ParkingSpaceDTO parkingSpace;

	private LocalDate startDate;

	private LocalDate endDate;
}
