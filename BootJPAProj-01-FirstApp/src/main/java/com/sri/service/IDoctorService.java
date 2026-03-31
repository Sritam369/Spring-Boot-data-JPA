package com.sri.service;

import java.util.List;

import com.sri.entity.Doctor;

public interface IDoctorService {
String registerDoctor(Doctor doctor);
Iterable<Doctor> bulkRegister(List<Doctor> list);
long fetchDoctorsCount();
}
