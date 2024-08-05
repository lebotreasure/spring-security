package com.bootcamp.security.service;

import com.bootcamp.security.entity.Appointment;
import com.bootcamp.security.entity.Doctor;
import com.bootcamp.security.repository.AppointmentRepository;
import com.bootcamp.security.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository repository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAppointmentsForDoctor(Long doctorId, LocalDateTime date) {
        LocalDateTime startOfDay = date.toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1).minusSeconds(1);
        return appointmentRepository.findByDoctorIdAndAppointmentTimeBetween(doctorId, startOfDay, endOfDay);
    }

    @Override
    public List<Doctor> findAllDoctors() {
        return repository.findAll();
    }

    @Override
    public Optional<Doctor> findDoctorById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return repository.save(doctor);
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor doctor) {
        return repository.findById(id)
                .map(existingDoctor -> {
                    existingDoctor.setName(doctor.getName());
                    existingDoctor.setTitle(doctor.getTitle());
                    existingDoctor.setSpecialisation(doctor.getSpecialisation());
                    existingDoctor.setLocation(doctor.getLocation());
                    return repository.save(existingDoctor);
                })
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    @Override
    public void deleteDoctor(Long id) {
        repository.deleteById(id);
    }
}
