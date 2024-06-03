package es.druedam.ProyectoNaves.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "alumno")
public class Alumno
{
    @Id
    @Column(name = "correo")
    private String correo;
    @Column(name = "nombre_alumno")
    private String nombre_alumno;
    @Column(name = "curso")
    private String curso;

    @OneToMany(mappedBy = "alumno")
    @JsonIgnore
    private List<Codigo> codigos;
}
