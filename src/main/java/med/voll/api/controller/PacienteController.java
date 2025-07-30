package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.domain.medico.DatosListaPaciente;
import med.voll.api.domain.medico.Paciente;
import med.voll.api.domain.medico.PacienteRepository;
import med.voll.api.domain.paciente.DatosResgistroPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {


    @Autowired
    private PacienteRepository repository;


    @Transactional
    @PostMapping
    public void registro(@RequestBody @Valid DatosResgistroPaciente datos){
        repository.save(new Paciente(datos));

    }

    // Para lista la lista de Paciente
    @GetMapping
     public List<DatosListaPaciente> listar(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable paginacion){
       return repository.findAll(paginacion).stream().map(DatosListaPaciente::new).toList();



}

}
