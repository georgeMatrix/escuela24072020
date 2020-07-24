package com.formatoweb.proyecto23072020.converters;

import com.formatoweb.proyecto23072020.entity.Curso;
import com.formatoweb.proyecto23072020.models.CursoDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CursoConverter {
    public CursoDto entityToModel(Curso curso){
        CursoDto cursoDto = new CursoDto();
        cursoDto.setCreditos(curso.getCreditos());
        cursoDto.setEspanol(curso.getEspanol());
        cursoDto.setFisica(curso.getFisica());
        cursoDto.setMatematicas(curso.getMatematicas());
        cursoDto.setQuimica(curso.getQuimica());
        return cursoDto;
    }

    public List<CursoDto> entityToModel(List<Curso> curso){
        List<CursoDto> cursoDtoList = new ArrayList<>();
        for (Curso c: curso
             ) {
            cursoDtoList.add(entityToModel(c));
        }
        return cursoDtoList;
    }
}
