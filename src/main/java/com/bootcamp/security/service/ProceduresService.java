package com.bootcamp.security.service;

import com.bootcamp.security.entity.Appointment;
import com.bootcamp.security.entity.Procedures;

import java.util.List;
import java.util.Optional;

public interface ProceduresService {
    List<Procedures> findAllProcedures();
    Optional<Procedures> findProceduresById(Long id);
    Procedures saveProcedures(Procedures procedures);
    Procedures updateProcedures(Long id, Procedures procedures);
    void deleteProcedures(Long id);
}
