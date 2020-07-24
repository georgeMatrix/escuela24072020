package com.formatoweb.proyecto23072020.repository;

import com.formatoweb.proyecto23072020.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface ProfesorRepository extends JpaRepository<Profesor, Serializable> {
}
