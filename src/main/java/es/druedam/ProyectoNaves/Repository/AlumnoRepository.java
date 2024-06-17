package es.druedam.ProyectoNaves.Repository;

import es.druedam.ProyectoNaves.DTO.AllDTO;
import es.druedam.ProyectoNaves.DTO.CodigoDTO;
import es.druedam.ProyectoNaves.Models.Alumno;
import es.druedam.ProyectoNaves.Models.Codigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface AlumnoRepository extends CrudRepository<Alumno, String>
{
    @Query("SELECT DISTINCT c.alumno.correo FROM Codigo c WHERE c.enviado = false ORDER BY c.alumno.correo")
    Optional<List<String>> findDistinctAllCorreosAndCodigos();

    @Query("SELECT new es.druedam.ProyectoNaves.DTO.AllDTO(a.correo, a.nombre_alumno, a.curso, c.codigo, c.validado, c.enviado, c.fecha_validacion) FROM Alumno a LEFT JOIN a.codigos c")
    Optional<List<AllDTO>> getAllAlumnosAndCodigos();

}
