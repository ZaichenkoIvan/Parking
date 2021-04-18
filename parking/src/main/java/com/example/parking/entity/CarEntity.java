package com.example.parking.entity;

import java.util.List;

import javax.persistence.*;

import lombok.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cars", indexes = { @Index(columnList = "name") })
public class CarEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
	private List<CouponEntity> coupons;
}
