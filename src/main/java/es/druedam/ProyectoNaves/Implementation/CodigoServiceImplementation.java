package es.druedam.ProyectoNaves.Implementation;

import es.druedam.ProyectoNaves.DTO.CodigoDTO;
import es.druedam.ProyectoNaves.Models.Alumno;
import es.druedam.ProyectoNaves.Models.Codigo;
import es.druedam.ProyectoNaves.Repository.AlumnoRepository;
import es.druedam.ProyectoNaves.Repository.CodigoRepository;
import es.druedam.ProyectoNaves.Service.CodigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class CodigoServiceImplementation implements CodigoService
{
    @Autowired
    CodigoRepository codigoRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;


    @Override
    public List<Codigo> getAllCodigos() {
        return (List<Codigo>) codigoRepository.findAll();
    }

    @Override
    public List<Codigo> getCodigosByAlumnoCorreo(String correo) {
        return codigoRepository.findByAlumnoCorreo(correo);
    }

    @Override
    public Codigo saveCodigo(Codigo codigo) {
        return codigoRepository.save(codigo);
    }

    @Override
    public Codigo createCodigo(CodigoDTO createCodigoDTO) throws Exception {
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(createCodigoDTO.getCorreo());
        if(alumnoOptional.isPresent())
        {
            Codigo codigo = new Codigo();
            codigo.setAlumno(alumnoOptional.get());
            codigo.setCodigo(createCodigoDTO.getCodigo());
            return codigoRepository.save(codigo);
        }
        else
        {
            throw new Exception("Alumno not found with correo " + createCodigoDTO.getCorreo());
        }
    }

    @Override
    public Codigo updateCodigoValidado(String correo, boolean validado) throws Exception {
        Optional<Codigo> codigoOpt = codigoRepository.findById(correo);
        if (codigoOpt.isPresent()) {
            Codigo codigo = codigoOpt.get();
            codigo.setValidado(validado);
            return codigoRepository.save(codigo);
        } else {
            throw new Exception("Codigo not found with id " + correo);
        }
    }

    @Override
    public int countCodigosByCorreo(String correo) {
        return codigoRepository.countByAlumnoCorreo(correo);
    }

    @Override
    public List<CodigoDTO> getAllCorreosAndCodigos() {
        return codigoRepository.findAllCorreosAndCodigos();
    }

    @Override
    public List<String> getAllCodigosByCorreo(String correo) {
        return codigoRepository.getAllCodigosByCorreo(correo);
    }

    @Override
    public Codigo findByCodigo(String codigo) {
        return codigoRepository.findByCodigo(codigo);
    }


}
