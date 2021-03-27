package com.example.parking.entity;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "coupons")
public class CouponEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_car", referencedColumnName = "id")
	private CarEntity car;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_parking_space", referencedColumnName = "id")
	private ParkingSpaceEntity parkingSpace;

	@Column(name = "start_date", columnDefinition = "DATE")
	private LocalDate startDate;

	@Column(name = "end_date", columnDefinition = "DATE")
	private LocalDate endDate;
}
