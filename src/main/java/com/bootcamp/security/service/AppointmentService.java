package com.bootcamp.security.service;

import com.bootcamp.security.entity.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    List<Appointment> findAllAppointments();
    Optional<Appointment> findAppointmentByDoctorId(Long categoryId);
    Appointment saveAppointment(Appointment tip);
    Appointment updateAppointment(Long id, Appointment tip);
    void deleteAppointment(Long id);
}
