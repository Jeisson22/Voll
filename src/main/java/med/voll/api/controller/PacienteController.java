package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.medico.Paciente;
import med.voll.api.medico.PacienteRepository;
import med.voll.api.paciente.DatosResgistroPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


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


}
