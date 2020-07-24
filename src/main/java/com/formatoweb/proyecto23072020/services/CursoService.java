package com.formatoweb.proyecto23072020.services;

import com.formatoweb.proyecto23072020.entity.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> getCursos();
    Curso saveCurso(Curso curso);
    Curso getCursoById(Long id);
    void deleteCurso(Long id);
}
