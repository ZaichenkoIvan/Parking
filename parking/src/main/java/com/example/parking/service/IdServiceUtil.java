package com.example.parking.service;

import com.example.parking.exception.IdUncorrectedRuntimeException;


public class IdServiceUtil {
	public static final String UNCORRECTED_ID = "Id is uncorrected";
	private static final String NEGATIVE_ID = "Id must dont be negative";

	public static void isIdPositive(Long id) {
		if (id < 0) {
			throw new IdUncorrectedRuntimeException(NEGATIVE_ID);
		}
	}
}
