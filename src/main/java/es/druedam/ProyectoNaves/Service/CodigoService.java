package es.druedam.ProyectoNaves.Service;

import es.druedam.ProyectoNaves.DTO.CodigoDTO;
import es.druedam.ProyectoNaves.Models.Codigo;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CodigoService
{
    List<Codigo> getAllCodigos();
    List<Codigo> getCodigosByAlumnoCorreo(String correo);
    Codigo saveCodigo(Codigo codigo);
    Codigo createCodigo(CodigoDTO createCodigoDTO) throws Exception;
    Codigo updateCodigoValidado(String correo, boolean validado) throws Exception;
    ResponseEntity<Object> updateCorreoEnviado(String correo) throws Exception;
    int countCodigosByCorreo(@RequestParam("correo") String correo);
    List<CodigoDTO> getAllCorreosAndCodigos();
    List<String> getAllCodigosByCorreo(@Param("correo") String correo);
    Codigo findByCodigo(@Param("codigo") String codigo);
    List<Codigo> findByCorreo(@Param("correo") String correo);
}
