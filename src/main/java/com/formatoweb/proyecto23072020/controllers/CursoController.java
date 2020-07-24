package com.formatoweb.proyecto23072020.controllers;

import com.formatoweb.proyecto23072020.entity.Curso;
import com.formatoweb.proyecto23072020.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/cursos")
    public List<Curso> getCursos(){
        return cursoService.getCursos();
    }
}
