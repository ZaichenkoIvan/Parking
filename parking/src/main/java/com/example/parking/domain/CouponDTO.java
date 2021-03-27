package com.example.parking.domain;

import java.time.LocalDate;

import com.example.parking.entity.CarEntity;
import com.example.parking.entity.ParkingSpaceEntity;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponDTO {
	private Long id;

	private CarEntity car;

	private ParkingSpaceEntity parkingSpace;

	private LocalDate startDate;

	private LocalDate endDate;
}
