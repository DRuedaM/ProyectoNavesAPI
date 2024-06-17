package es.druedam.ProyectoNaves.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
public class AllDTO
{
    private String correo;
    private String nombre_alumno;
    private String curso;
    private String codigo;
    private boolean validado;
    private boolean enviado;
    private Date fecha_validacion;


    public AllDTO(String correo, String nombre_alumno, String curso, String codigo, boolean validado, boolean enviado, Date fecha_validacion) {
        this.correo = correo;
        this.nombre_alumno = nombre_alumno;
        this.curso = curso;
        this.codigo = codigo;
        this.validado = validado;
        this.enviado = enviado;
        this.fecha_validacion = fecha_validacion;
    }
}
