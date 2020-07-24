package com.formatoweb.proyecto23072020.controllers;

import com.formatoweb.proyecto23072020.converters.AlumnoConverter;
import com.formatoweb.proyecto23072020.entity.Alumno;
import com.formatoweb.proyecto23072020.entity.Curso;
import com.formatoweb.proyecto23072020.models.AlumnoDto;
import com.formatoweb.proyecto23072020.services.AlumnoService;
import com.formatoweb.proyecto23072020.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200"})
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;
    @Autowired
    private CursoService cursoService;
    @Autowired
    private AlumnoConverter alumnoConverter;

    @GetMapping("/alumnos")
    public List<AlumnoDto> getAlumnos(){
        List<Alumno> alumno = alumnoService.getAlumnos();
        return alumnoConverter.EntityToModel(alumno);
    }

    @PostMapping("/alumnos")
    public ResponseEntity<?> guardarAlumno(@RequestBody AlumnoDto alumnoDto){
        Alumno alumnoNew = null;
        Curso curso = null;
        Map<String, Object> response = new HashMap<>();
        if (alumnoDto.getIdCurso() == null){
            response.put("mensaje", "El valor del curso no puede ir vacio");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        curso = cursoService.getCursoById(alumnoDto.getIdCurso());
        Alumno alumno = alumnoConverter.ModelToEntity(alumnoDto, curso);
        try{
            alumnoService.saveAlumno(alumno);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al insertar en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Dato guardado correctamente");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/alumnos/{id}")
    public ResponseEntity<?> ObtenerAlumnoId(@PathVariable Long id){
        Alumno alumno = null;
        AlumnoDto alumnoDto = null;
        Map<String, Object> response = new HashMap<>();

        try{
            alumno = alumnoService.getAlumnoById(id);
        }catch(DataAccessException e){
            response.put("mensaje", "Error en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (alumno == null){
            response.put("mensaje", "No existe el id: ".concat(id.toString()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        alumnoDto = alumnoConverter.EntityToModel(alumno);
        response.put("mensaje", alumnoDto);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PutMapping("/alumnos/{id}")
    public ResponseEntity<?> ActualizarAlumno(@RequestBody AlumnoDto alumnoDtoNew, @PathVariable Long id){
        Alumno alumnoOld = null;
        Alumno alumnoActualizado = null;
        AlumnoDto alumnoDtoActualizado = null;
        Map<String, Object> response = new HashMap<>();
        Curso cursoNew = cursoService.getCursoById(alumnoDtoNew.getIdCurso());
        if (alumnoDtoNew.getIdCurso() == null){
            response.put("mensaje", "Se necesita un curso: ".concat(id.toString()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        alumnoOld = alumnoService.getAlumnoById(id);
        if (alumnoOld == null){
            response.put("mensaje", "El id: ".concat(id.toString()).concat(": ").concat("no existe"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try{
            alumnoOld.setNombre(alumnoDtoNew.getNombre());
            alumnoOld.setApellido(alumnoDtoNew.getApellido());
            alumnoOld.setCurso(cursoNew);
            alumnoActualizado = alumnoService.saveAlumno(alumnoOld);
            alumnoDtoActualizado = alumnoConverter.EntityToModel(alumnoActualizado);
        }catch (DataAccessException e){
            response.put("mensaje", "No se pudo actualizar el registro");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "registro actualizado");
        response.put("registro", alumnoDtoActualizado);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @DeleteMapping("/alumnos/{id}")
    public ResponseEntity<?> eliminarAlumno(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        try{
            alumnoService.deleteAlumno(id);
        }catch (DataAccessException e){
            response.put("mensaje", "El registro con id ".concat(id.toString()).concat(" no pudo ser eliminado"));
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El registro fue eliminado");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
