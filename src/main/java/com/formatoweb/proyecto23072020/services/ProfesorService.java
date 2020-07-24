package com.formatoweb.proyecto23072020.services;

import com.formatoweb.proyecto23072020.entity.Profesor;

import java.util.List;

public interface ProfesorService {
    List<Profesor> getProfesores();
    Profesor saveProfesor(Profesor profesor);
    Profesor getProfesorById(Long id);
    void deleteProfesor(Long id);
}
