package com.bootcamp.security.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "specialisation")
    private String specialisation;

    @Column(name = "location")
    private String location;

    @Column(name = "fees")
    private String fees;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "procedures")
    private List<Procedures> prodedures;

    //    @Column(name = "appointment_id")
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointment;

    public Doctor() {
    }

    public Doctor(Long id, String name, String title, String specialisation, String location) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.specialisation = specialisation;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", specialisation='" + specialisation + '\'' +
                ", location='" + location + '\'' +
                ", appointment=" + appointment +
                '}';
    }
}
