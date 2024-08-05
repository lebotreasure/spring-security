package com.bootcamp.security.controller;

import com.bootcamp.security.entity.Procedures;
import com.bootcamp.security.service.ProceduresServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/procedures")
public class ProcedureController {

    @Autowired
    private ProceduresServiceImpl service;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<Procedures>> getAllProcedures() {
        return ResponseEntity.ok(service.findAllProcedures());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Procedures>> getProceduresById(@PathVariable Long id) {
        Optional<Procedures> procedures = service.findProceduresById(id);
        return ResponseEntity.ok(procedures);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<Procedures> createProcedures(@RequestBody Procedures procedures) {
        Procedures newProcedures = service.saveProcedures(procedures);
        return ResponseEntity.ok(newProcedures);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public ResponseEntity<Procedures> updateProcedures(@PathVariable Long id, Procedures procedures) {
        Procedures updatedProcedures = service.updateProcedures(id, procedures);
        return ResponseEntity.ok(updatedProcedures);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcedures(@PathVariable Long id) {
        service.deleteProcedures(id);
        return ResponseEntity.ok().build();
    }
}
