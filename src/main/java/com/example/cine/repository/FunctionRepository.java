package com.example.cine.repository;

import com.example.cine.model.Function;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FunctionRepository extends JpaRepository<Function, Integer>{

    // Spring Data JPA magic: busca por el campo "dateTime" de la clase Function
    // SELECT * FROM funciones WHERE fecha_hora BETWEEN start AND end
    List<Function> findByDateTimeBetween(LocalDateTime start, LocalDateTime end);
}