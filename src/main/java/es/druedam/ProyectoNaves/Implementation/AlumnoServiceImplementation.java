package es.druedam.ProyectoNaves.Implementation;

import es.druedam.ProyectoNaves.Models.Alumno;
import es.druedam.ProyectoNaves.Repository.AlumnoRepository;
import es.druedam.ProyectoNaves.Service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImplementation implements AlumnoService
{
    @Autowired
    AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> getAllAlumnos() {
        return (List<Alumno>) alumnoRepository.findAll();
    }

    @Override
    public Alumno saveAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public void deleteAlumno(String correo) {
        alumnoRepository.deleteById(correo);
    }

    @Override
    public Optional<Alumno> getSpecificAlumno(String correo) {
        return alumnoRepository.findById(correo);
    }

    @Override
    public void deleteAllData() {
        alumnoRepository.deleteAll();
    }

    @Override
    public Optional<List<String>> findDistinctAllCorreosAndCodigos() {
        return alumnoRepository.findDistinctAllCorreosAndCodigos();
    }


}
