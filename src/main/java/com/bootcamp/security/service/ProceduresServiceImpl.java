package com.bootcamp.security.service;

import com.bootcamp.security.entity.Procedures;
import com.bootcamp.security.repository.ProceduresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProceduresServiceImpl implements ProceduresService {

    @Autowired
    private ProceduresRepository repository;

    @Override
    public List<Procedures> findAllProcedures() {
        return repository.findAll();
    }

    @Override
    public Optional<Procedures> findProceduresById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Procedures saveProcedures(Procedures procedures) {
        return repository.save(procedures);
    }

    @Override
    public Procedures updateProcedures(Long id, Procedures procedures) {
        return repository.findById(id)
                .map(existingProcedure -> {
                    existingProcedure.setProcedure_name(procedures.getProcedure_name());
                    return repository.save(existingProcedure);
                }).orElseThrow(() -> new RuntimeException("Procedure not found"));
    }

    @Override
    public void deleteProcedures(Long id) {
        repository.deleteById(id);
    }
}
