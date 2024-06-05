package es.druedam.ProyectoNaves.Models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Getter
@Setter
@Table(name = "codigo")
public class Codigo
{
    @Id
    @Column(name = "id_codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_codigo;

    @Column(name = "codigo")
    private String codigo;
    @Column(name = "validado")
    private boolean validado;
    @Column(name = "enviado")
    private boolean enviado;
    @Column(name = "fecha_validacion")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fecha_validacion;


    @ManyToOne
    @JoinColumn(name = "correo")
    private Alumno alumno;
    

}
