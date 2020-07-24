package com.formatoweb.proyecto23072020.services.impl;

import com.formatoweb.proyecto23072020.entity.Profesor;
import com.formatoweb.proyecto23072020.repository.ProfesorRepository;
import com.formatoweb.proyecto23072020.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorImplService implements ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;
    @Override
    public List<Profesor> getProfesores() {
        return profesorRepository.findAll();
    }

    @Override
    public Profesor saveProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public Profesor getProfesorById(Long id) {
        return profesorRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProfesor(Long id) {
        profesorRepository.deleteById(id);
    }
}
