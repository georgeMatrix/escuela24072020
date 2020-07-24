package com.formatoweb.proyecto23072020.repository;

import com.formatoweb.proyecto23072020.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface CursoRepository extends JpaRepository<Curso, Serializable> {
}
