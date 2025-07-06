package med.voll.api.controller;


import med.voll.api.paciente.DatosResgistroPaciente;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @PostMapping
    public void registro(@RequestBody DatosResgistroPaciente datos){
        System.out.println( datos);

    }


}
