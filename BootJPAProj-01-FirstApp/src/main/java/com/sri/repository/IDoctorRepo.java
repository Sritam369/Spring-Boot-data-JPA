package com.sri.repository;

import org.springframework.data.repository.CrudRepository;

import com.sri.entity.Doctor;

public interface IDoctorRepo extends CrudRepository<Doctor, Integer> {

}
