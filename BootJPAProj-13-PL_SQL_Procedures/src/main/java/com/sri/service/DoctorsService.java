package com.sri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.Doctors;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class DoctorsService {

	@Autowired
	private EntityManager manager;
	
	public List<Doctors> showDoctorsByIncomeRange(double start,double end){
		
		StoredProcedureQuery query = manager.createStoredProcedureQuery("P_GET_DOCTORS_BY_INCOME_RANGE",Doctors.class);
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Object.class, ParameterMode.OUT);
		
		query.setParameter(1, start);
		query.setParameter(2, end);
		
		List<Doctors>list = query.getResultList();
		return list;
	}
}
