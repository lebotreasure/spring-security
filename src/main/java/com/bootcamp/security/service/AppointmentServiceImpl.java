package com.bootcamp.security.service;

import com.bootcamp.security.entity.Appointment;
import com.bootcamp.security.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    private AppointmentRepository repository;

    @Override
    public List<Appointment> findAllAppointments() {
        return repository.findAll();
    }

    @Override
    public Optional<Appointment> findAppointmentByDoctorId(Long doctorId) {
        return repository.findById(doctorId);
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return repository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Long id, Appointment appointment) {
        return repository.findById(id)
                .map(existingAppointment -> {
                    existingAppointment.setUser_det(appointment.getUser_det());
                    existingAppointment.setEmail(appointment.getEmail());
                    existingAppointment.setContactNo(appointment.getContactNo());
                    existingAppointment.setDescription(appointment.getDescription());
                    return repository.save(existingAppointment);
                }).orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    @Override
    public void deleteAppointment(Long id) {
        repository.deleteById(id);
    }
}
