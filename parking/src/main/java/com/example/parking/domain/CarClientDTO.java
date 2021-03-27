package com.example.parking.domain;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarClientDTO {
	private Long id;

	private CarDTO car;

	private ClientDTO client;
}
