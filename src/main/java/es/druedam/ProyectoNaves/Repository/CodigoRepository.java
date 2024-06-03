package es.druedam.ProyectoNaves.Repository;

import es.druedam.ProyectoNaves.DTO.CodigoDTO;
import es.druedam.ProyectoNaves.DTO.UpdateCodigoValidadoDTO;
import es.druedam.ProyectoNaves.Models.Codigo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CodigoRepository extends CrudRepository<Codigo, String>
{
    List<Codigo> findByAlumnoCorreo(String correo);

    @Query("SELECT COUNT(c) FROM Codigo c WHERE c.alumno.correo = :correo")
    long countByAlumnoCorreo(@Param("correo") String correo);

    @Query("SELECT c.alumno.correo, c.codigo FROM Codigo c WHERE c.validado = false")
    List<CodigoDTO> findAllCorreosAndCodigos();

    @Query("SELECT c.codigo FROM Codigo c WHERE c.alumno.correo = :correo AND c.enviado = false ORDER BY c.alumno.correo")
    List<String> getAllCodigosByCorreo(@Param("correo") String correo);

    @Query("SELECT c from Codigo c WHERE c.codigo = :codigo")
    Codigo findByCodigo(@Param("codigo") String codigo);
}
