package com.formatoweb.proyecto23072020.services.impl;

import com.formatoweb.proyecto23072020.entity.Alumno;
import com.formatoweb.proyecto23072020.repository.AlumnoRepository;
import com.formatoweb.proyecto23072020.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoImplService implements AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Override
    public List<Alumno> getAlumnos() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno saveAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno getAlumnoById(Long id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAlumno(Long id) {
        alumnoRepository.deleteById(id);
    }
}
