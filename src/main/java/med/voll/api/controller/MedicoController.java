package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;


    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid DatosRegistroMedico datos){

        repository.save(new Medico(datos));

    }


    // cambia el list por page
    /*public List<DatosListaMedico> listar(Pageable  paginacion){
       return repository.findAll(paginacion).stream().map(DatosListaMedico::new).toList();
    }*/
    @GetMapping
    public Page<DatosListaMedico> listar(@PageableDefault(size=10, sort = {"nombre"}) Pageable  paginacion){
        return repository.findAllByActivoTrue(paginacion).map(DatosListaMedico::new);
    }


    @Transactional
    @PutMapping
    public void actualizar(@RequestBody @Valid DatosActualizacionMedico datos){
        // De esta forma obtenemos el medico dela base de datos por el id
        var medico = repository.getReferenceById(datos.id());
        // Ahora tenemos que crear un metodo para actualizar medico
        medico.actualizarInformaciones(datos);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void  eliminar(@PathVariable  Long id){
       var medico = repository.getReferenceById(id);
       medico.eliminar();

    }


    // SPRING BOOT 3
    // donde se agrego algunas depedencias
}
