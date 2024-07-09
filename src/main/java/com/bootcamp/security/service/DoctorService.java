package com.bootcamp.security.service;

import com.bootcamp.security.entity.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    List<Doctor> findAllDoctors();
    Optional<Doctor> findDoctorById(Long id);
    Doctor saveDoctor(Doctor category);
    Doctor updateDoctor(Long id, Doctor category);
    void deleteDoctor(Long id);
}
