package com.example.parking.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "parking_spaces", indexes = { @Index(columnList = "name") })
public class ParkingSpaceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_parking", referencedColumnName = "id")
	private ParkingEntity parking;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "parkingSpace")
	private List<CouponEntity> coupons;
}
