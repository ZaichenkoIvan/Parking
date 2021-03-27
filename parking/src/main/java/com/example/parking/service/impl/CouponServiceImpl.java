package com.example.parking.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.entity.CouponEntity;
import com.example.parking.exception.IdUncorrectedRuntimeException;
import com.example.parking.repository.CouponRepository;
import com.example.parking.service.CouponService;
import com.example.parking.service.IdServiceUtil;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CouponServiceImpl implements CouponService {
	@PersistenceContext
	private EntityManager entityManager;

	private CouponRepository couponRepository;

	@Override
	public CouponEntity save(CouponEntity couponEntity) {
		return couponRepository.save(couponEntity);
	}

	@Override
	public CouponEntity findById(Long id) {
		IdServiceUtil.isIdPositive(id);
		Optional<CouponEntity> couponEntity = couponRepository.findById(id);
		if (couponEntity.isPresent()) {
			return couponEntity.get();
		}
		throw new IdUncorrectedRuntimeException(IdServiceUtil.UNCORRECTED_ID);
	}

	@Override
	public List<CouponEntity> findAll() {
		return couponRepository.findAll();
	}

	@Override
	@Transactional
	public CouponEntity update(CouponEntity couponEntity) {
		return entityManager.merge(couponEntity);
	}

	@Override
	public void deleteById(Long id) {
		IdServiceUtil.isIdPositive(id);
		couponRepository.deleteById(id);
	}

}
