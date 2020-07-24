package com.formatoweb.proyecto23072020.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "curso", schema = "escuela", catalog = "")
public class Curso {
    private Long id;
    private String matematicas;
    private String espanol;
    private String fisica;
    private String quimica;
    private String creditos;
    private List<Alumno> alumnos;
    private Profesor profesor;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "matematicas")
    public String getMatematicas() {
        return matematicas;
    }

    public void setMatematicas(String matematicas) {
        this.matematicas = matematicas;
    }

    @Basic
    @Column(name = "espanol")
    public String getEspanol() {
        return espanol;
    }

    public void setEspanol(String espanol) {
        this.espanol = espanol;
    }

    @Basic
    @Column(name = "fisica")
    public String getFisica() {
        return fisica;
    }

    public void setFisica(String fisica) {
        this.fisica = fisica;
    }

    @Basic
    @Column(name = "quimica")
    public String getQuimica() {
        return quimica;
    }

    public void setQuimica(String quimica) {
        this.quimica = quimica;
    }

    @Basic
    @Column(name = "creditos")
    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    @OneToMany(mappedBy = "curso")
    @JsonManagedReference
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "profesor", referencedColumnName = "id", nullable = false)
    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
