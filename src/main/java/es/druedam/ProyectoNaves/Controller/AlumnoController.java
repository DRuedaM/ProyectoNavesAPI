package es.druedam.ProyectoNaves.Controller;

import es.druedam.ProyectoNaves.Implementation.AlumnoServiceImplementation;
import es.druedam.ProyectoNaves.Models.Alumno;
import es.druedam.ProyectoNaves.Repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-lasnaves")
public class AlumnoController
{
    @Autowired
    AlumnoServiceImplementation alumnoServiceImplementation;

    @GetMapping
    public List<Alumno> getAllAlumnos()
    {
        return alumnoServiceImplementation.getAllAlumnos();
    }

    @PostMapping("/save")
    public Alumno guardarAlumno(@RequestBody Alumno alumno)
    {
        return alumnoServiceImplementation.saveAlumno(alumno);
    }

    @GetMapping(path = "/{correo}")
    public Optional<Alumno> getSpecificAlumno(@PathVariable String correo)
    {
        return alumnoServiceImplementation.getSpecificAlumno(correo);
    }

    @PutMapping("/update/{correo}")
    public Alumno updateAlumno(@PathVariable String correo, @RequestBody Alumno alumno)
    {
        alumno.setCorreo(correo);
        return alumnoServiceImplementation.saveAlumno(alumno);
    }

    @DeleteMapping("/{correo}")
    public void deleteAlumno(@PathVariable String correo){
        alumnoServiceImplementation.deleteAlumno(correo);
    }

    @DeleteMapping("/delete-all")
    public void deleteAll(){
        alumnoServiceImplementation.deleteAllData();
    }

    @GetMapping("/find-distinct-correos")
    public Optional<List<String>> getDistinctAlumnos()
    {
        return alumnoServiceImplementation.findDistinctAllCorreosAndCodigos();
    }




}
