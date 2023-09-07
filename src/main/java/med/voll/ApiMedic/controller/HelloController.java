package med.voll.ApiMedic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Controller: Necesitamos decirle que es un Controller
@RequestMapping("/hola") // le decimos la ruta HTTP sigue
public class HelloController {

    @GetMapping
    public String helloWord(){

        return  "Se va  a casar la Mishel :c yo queria ser su primera vez XD";
    }

}
