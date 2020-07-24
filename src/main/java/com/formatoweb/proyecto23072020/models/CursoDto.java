package com.formatoweb.proyecto23072020.models;

import com.formatoweb.proyecto23072020.entity.Alumno;
import com.formatoweb.proyecto23072020.entity.Profesor;

import java.util.List;

public class CursoDto {
    private Long id;
    private String matematicas;
    private String espanol;
    private String fisica;
    private String quimica;
    private String creditos;
    private Long idProfesor;
    private List<Alumno> alumnos;
    private Profesor profesor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatematicas() {
        return matematicas;
    }

    public void setMatematicas(String matematicas) {
        this.matematicas = matematicas;
    }

    public String getEspanol() {
        return espanol;
    }

    public void setEspanol(String espanol) {
        this.espanol = espanol;
    }

    public String getFisica() {
        return fisica;
    }

    public void setFisica(String fisica) {
        this.fisica = fisica;
    }

    public String getQuimica() {
        return quimica;
    }

    public void setQuimica(String quimica) {
        this.quimica = quimica;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
