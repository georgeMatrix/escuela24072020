package com.formatoweb.proyecto23072020.services;

import com.formatoweb.proyecto23072020.entity.Alumno;

import java.util.List;

public interface AlumnoService {
    List<Alumno> getAlumnos();
    Alumno saveAlumno(Alumno alumno);
    Alumno getAlumnoById(Long id);
    void deleteAlumno(Long id);
}
