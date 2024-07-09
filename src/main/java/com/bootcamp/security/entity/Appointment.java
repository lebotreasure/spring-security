package com.bootcamp.security.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "appointment-list")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long id;

    @Column(name = "user_det")
    private String user_det;

    @Column(name = "email")
    private String email;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "description")
    private String description;

    @Column(name = "appointment_date")
    Timestamp appointmentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
