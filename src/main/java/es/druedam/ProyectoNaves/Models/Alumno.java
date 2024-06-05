package es.druedam.ProyectoNaves.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Getter
@Setter
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<Codigo> getCodigos() {
        return codigos;
    }

    public void setCodigos(List<Codigo> codigos) {
        this.codigos = codigos;
    }
}
