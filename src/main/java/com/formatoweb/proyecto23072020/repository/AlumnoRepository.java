package com.formatoweb.proyecto23072020.repository;

import com.formatoweb.proyecto23072020.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Serializable> {
}
