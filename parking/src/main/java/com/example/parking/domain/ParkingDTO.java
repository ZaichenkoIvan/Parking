package com.example.parking.domain;

import java.util.List;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingDTO {
	private Long id;

	private String name;

	private List<ParkingSpaceDTO> parkingSpaces;
}
