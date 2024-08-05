package com.bootcamp.security.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Procedures {
    @Id
    @GeneratedValue
    @Column(name = "procedure_id")
    private Long id;

    private String procedure_name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
}
