package com.bootcamp.security.repository;

import com.bootcamp.security.entity.Procedures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProceduresRepository extends JpaRepository<Procedures, Long> {
}
