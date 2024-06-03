package es.druedam.ProyectoNaves.Service;

import es.druedam.ProyectoNaves.Models.Alumno;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface AlumnoService
{
    List<Alumno> getAllAlumnos();
    Alumno saveAlumno(Alumno alumno);
    void deleteAlumno(String correo);
    Optional<Alumno> getSpecificAlumno(String correo);
    void deleteAllData();
    Optional<List<String>> findDistinctAllCorreosAndCodigos();
}
