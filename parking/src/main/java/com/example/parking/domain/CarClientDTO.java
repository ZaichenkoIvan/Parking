package com.example.parking.domain;

import com.example.parking.entity.CarEntity;
import com.example.parking.entity.ClientEntity;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarClientDTO {
	private Long id;

	private CarEntity car;

	private ClientEntity client;
}
