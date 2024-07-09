package com.bootcamp.security.service;

import com.bootcamp.security.entity.Patient;
import com.bootcamp.security.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository repository;

    @Override
    public List<Patient> findAllPatients() {
        return repository.findAll();
    }

    @Override
    public Optional<Patient> findPatientById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Patient savePatient(Patient patient) {
        return repository.save(patient);
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
        return repository.findById(id)
                .map(existingPatient -> {
                    existingPatient.setName(patient.getName());
                    existingPatient.setMobileNo(patient.getMobileNo());
                    existingPatient.setCity(patient.getCity());
                    existingPatient.setAge(patient.getAge());
                    existingPatient.setGender(patient.getGender());
                    return repository.save(existingPatient);
                })
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    @Override
    public void deletePatient(Long id) {
        repository.deleteById(id);
    }
}
