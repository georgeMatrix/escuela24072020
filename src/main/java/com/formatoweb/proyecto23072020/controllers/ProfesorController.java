package com.formatoweb.proyecto23072020.controllers;

import com.formatoweb.proyecto23072020.entity.Profesor;
import com.formatoweb.proyecto23072020.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;
    @GetMapping("/profesores")
    public List<Profesor> getProfesores(){
        return profesorService.getProfesores();
    }
}
