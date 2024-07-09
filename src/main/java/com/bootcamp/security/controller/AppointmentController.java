package com.bootcamp.security.controller;

import com.bootcamp.security.entity.Appointment;
import com.bootcamp.security.service.AppointmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/appointment")
public class AppointmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentController.class);

    @Autowired
    private AppointmentServiceImpl appointmentService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.findAllAppointments());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{doctorId}")
    public ResponseEntity<Optional<Appointment>> getAppointmentByDoctorId(@PathVariable Long doctorId) {
        Optional<Appointment> appointments = appointmentService.findAppointmentByDoctorId(doctorId);
        return ResponseEntity.ok(appointments);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment newAppointment = appointmentService.saveAppointment(appointment);
        return ResponseEntity.ok(newAppointment);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, Appointment appointment) {
        Appointment updatedAppointment = appointmentService.updateAppointment(id, appointment);
        return ResponseEntity.ok(updatedAppointment);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.ok().build();
    }
}
