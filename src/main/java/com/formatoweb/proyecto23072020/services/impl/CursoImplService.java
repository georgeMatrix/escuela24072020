package com.formatoweb.proyecto23072020.services.impl;

import com.formatoweb.proyecto23072020.entity.Curso;
import com.formatoweb.proyecto23072020.repository.CursoRepository;
import com.formatoweb.proyecto23072020.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoImplService implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    @Override
    public List<Curso> getCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso saveCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso getCursoById(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}
