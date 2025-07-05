package med.voll.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// ES UNA APLICACION REST NO ES UNA PAGINA WEB NORMAL QUE SOLO SERIA CONTROLLER
@RestController
@RequestMapping("/hello")

public class HelloController {

    @GetMapping
    public String hello(){
        return "Hello  Wolrd!sss";
    }

}
