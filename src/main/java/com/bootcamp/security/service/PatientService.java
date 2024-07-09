package com.bootcamp.security.service;

import com.bootcamp.security.entity.Doctor;
import com.bootcamp.security.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<Patient> findAllPatients();
    Optional<Patient> findPatientById(Long id);
    Patient savePatient(Patient patient);
    Patient updatePatient(Long id, Patient patient);
    void deletePatient(Long id);
}
