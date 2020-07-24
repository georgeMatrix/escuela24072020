package com.formatoweb.proyecto23072020.converters;

import com.formatoweb.proyecto23072020.entity.Alumno;
import com.formatoweb.proyecto23072020.entity.Curso;
import com.formatoweb.proyecto23072020.models.AlumnoDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AlumnoConverter {

    public AlumnoDto EntityToModel(Alumno alumno){
        Map<String, Object> response = new HashMap<>();
        AlumnoDto alumnoDto = new AlumnoDto();
        alumnoDto.setId(alumno.getId());
        alumnoDto.setNombre(alumno.getNombre());
        alumnoDto.setApellido(alumno.getApellido());
        alumnoDto.setCurso(alumno.getCurso());
        return alumnoDto;
    }

    public List<AlumnoDto> EntityToModel(List<Alumno> alumnos){
        List<AlumnoDto> alumnoDtos = new ArrayList<>();
        for (Alumno a: alumnos
             ) {
            alumnoDtos.add(EntityToModel(a));
        }
        return alumnoDtos;
    }

    public Alumno ModelToEntity(AlumnoDto alumnoDto, Curso curso){
        Alumno alumno = new Alumno();
        alumno.setId(alumnoDto.getId());
        alumno.setNombre(alumnoDto.getNombre());
        alumno.setApellido(alumnoDto.getApellido());
        alumno.setCurso(curso);
        return alumno;
    }
}
