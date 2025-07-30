package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;


    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroMedico datos, UriComponentsBuilder uriComponentsBuilder) {

        var medico = new Medico(datos);
        repository.save(medico);

        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

         return  ResponseEntity.created(uri).body(new DatosDetallesMedico(medico));
    }


    // cambia el list por page
    /*public List<DatosListaMedico> listar(Pageable  paginacion){
       return repository.findAll(paginacion).stream().map(DatosListaMedico::new).toList();
    }*/
    @GetMapping
    public ResponseEntity<Page<DatosListaMedico>> listar(@PageableDefault(size=10, sort = {"nombre"}) Pageable  paginacion){
        var page =  repository.findAllByActivoTrue(paginacion).map(DatosListaMedico::new);

        return  ResponseEntity.ok(page);
    }


    @Transactional
    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizacionMedico datos){
        // De esta forma obtenemos el medico dela base de datos por el id
        var medico = repository.getReferenceById(datos.id());
        // Ahora tenemos que crear un metodo para actualizar medico
        medico.actualizarInformaciones(datos);



        return  ResponseEntity.ok(new DatosDetallesMedico(medico));
    }



    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity  eliminar(@PathVariable  Long id){
       var medico = repository.getReferenceById(id);
       medico.eliminar();


       return ResponseEntity.noContent().build();
    }



    @GetMapping("/{id}")
    public ResponseEntity  detallar(@PathVariable  Long id){
        var medico = repository.getReferenceById(id);


        return ResponseEntity.ok( new DatosDetallesMedico(medico));
    }


    // SPRING BOOT 3
    // donde se agrego algunas depedencias
}
