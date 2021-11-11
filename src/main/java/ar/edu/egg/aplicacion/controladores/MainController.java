package ar.edu.egg.aplicacion.controladores;

import ar.edu.egg.aplicacion.servicios.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    
    @Autowired
    private LibroServicio libroServicio;

    @GetMapping("/")
    public String index(ModelMap modelo) {
        return "index.html";
    }
}
