package es.druedam.ProyectoNaves.Controller;

import es.druedam.ProyectoNaves.DTO.CodigoDTO;
import es.druedam.ProyectoNaves.DTO.UpdateCodigoValidadoDTO;
import es.druedam.ProyectoNaves.Implementation.CodigoServiceImplementation;
import es.druedam.ProyectoNaves.Models.Codigo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-lasnaves")
public class CodigoController
{
    @Autowired
    CodigoServiceImplementation codigoServiceImplementation;

    @GetMapping("codigo")
    public List<Codigo> getAllCodigos()
    {
        return codigoServiceImplementation.getAllCodigos();
    }

    @GetMapping("/alumno/{correo}")
    public List<Codigo> getCodigosByAlumnoCorreo(@PathVariable String correo)
    {
        return codigoServiceImplementation.getCodigosByAlumnoCorreo(correo);
    }

    @PostMapping("/save-specific-codigo")
    public Codigo createCodigo(@RequestBody Codigo codigo)
    {
        return codigoServiceImplementation.saveCodigo(codigo);
    }


    @PatchMapping("/{codigo}/validado")
    public Codigo updateCodigoValidado(@PathVariable String codigo, @RequestBody UpdateCodigoValidadoDTO updateCodigoValidadoDTO) throws Exception {
        return codigoServiceImplementation.updateCodigoValidado(codigo, updateCodigoValidadoDTO.isValidado());
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Codigo> updateCodigo(@PathVariable String codigo, @RequestBody Codigo updatedCodigo)
    {
        Codigo existingCodigo = codigoServiceImplementation.findByCodigo(codigo);
        if(existingCodigo == null)
        {
            return ResponseEntity.notFound().build();
        }
        existingCodigo.setValidado(updatedCodigo.isValidado());
        existingCodigo.setEnviado(updatedCodigo.isEnviado());
        existingCodigo.setFecha_validacion(updatedCodigo.getFecha_validacion());
        Codigo savedCodigo = codigoServiceImplementation.saveCodigo(existingCodigo);
        return ResponseEntity.ok(savedCodigo);

    }

    @PostMapping("/save-codigos")
    public Codigo createCodigos(@RequestBody CodigoDTO createCodigoDTO) throws Exception {
        return codigoServiceImplementation.createCodigo(createCodigoDTO);
    }

    @GetMapping("/count/{correo}")
    public long countCodigoByCorreo(@RequestParam String correo)
    {
        return codigoServiceImplementation.countCodigosByCorreo(correo);
    }

    @GetMapping("/all-correos-codigos")
    public List<CodigoDTO> getAllCorreosAndCodigos()
    {
        return codigoServiceImplementation.getAllCorreosAndCodigos();
    }

    @GetMapping("/find-codigos/{correo}")
    public List<String> getAllcodigosByCorreo(@PathVariable String correo)
    {
        return codigoServiceImplementation.getAllCodigosByCorreo(correo);
    }
}
