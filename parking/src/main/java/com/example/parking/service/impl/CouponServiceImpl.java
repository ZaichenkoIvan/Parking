package com.example.parking.service.impl;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.domain.CouponDTO;
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

	private ModelMapper modelMapper;

	@Override
	public CouponDTO save(CouponDTO couponDTO) {
		CouponEntity couponEntity = mapCarDTOToEntity(couponDTO);
		return mapCarEntityToDTO(couponRepository.save(couponEntity));
	}

	@Override
	public CouponDTO findById(Long id) {
		IdServiceUtil.isIdPositive(id);
		Optional<CouponEntity> couponEntity = couponRepository.findById(id);
		if (couponEntity.isPresent()) {
			return mapCarEntityToDTO(couponEntity.get());
		}
		throw new IdUncorrectedRuntimeException(IdServiceUtil.UNCORRECTED_ID);
	}

	@Override
	public List<CouponDTO> findAll() {
		List<CouponEntity> couponEntities = couponRepository.findAll();
		List<CouponDTO> couponDTOS = new ArrayList<>();
		for (CouponEntity couponEntity : couponEntities) {
			couponDTOS.add(mapCarEntityToDTO(couponEntity));
		}
		return couponDTOS;
	}

	@Override
	@Transactional
	public CouponDTO update(CouponDTO couponDTO) {
		CouponEntity couponEntity = mapCarDTOToEntity(couponDTO);
		return mapCarEntityToDTO(entityManager.merge(couponEntity));
	}

	@Override
	public void deleteById(Long id) {
		IdServiceUtil.isIdPositive(id);
		couponRepository.deleteById(id);
	}

	private CouponDTO mapCarEntityToDTO(CouponEntity couponEntity) {
		return modelMapper.map(couponEntity, CouponDTO.class);
	}

	private CouponEntity mapCarDTOToEntity(CouponDTO couponDTO) {
		return modelMapper.map(couponDTO, CouponEntity.class);
	}

}
