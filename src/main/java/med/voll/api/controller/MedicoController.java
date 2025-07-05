package med.voll.api.controller;

import med.voll.medico.DatosRegistroMedico;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {


    @PostMapping
    public void registrar(@RequestBody DatosRegistroMedico datos){
        System.out.println(datos);
    }

}
