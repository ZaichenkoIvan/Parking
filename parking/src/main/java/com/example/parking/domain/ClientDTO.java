package com.example.parking.domain;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO {
	private Long id;

	private String name;
}
