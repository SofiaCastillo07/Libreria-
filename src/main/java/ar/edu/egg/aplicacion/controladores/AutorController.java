
package ar.edu.egg.aplicacion.controladores;

import ar.edu.egg.aplicacion.entidades.Autor;
import ar.edu.egg.aplicacion.servicios.AutorServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorServicio autorServicio;

    @GetMapping("/cargarautor")
    public String formulario() {
        return "cargar-autor";
    }

    @PostMapping("/cargarautor")
    public String lista(ModelMap modelo, @RequestParam String nombre) { //hashmap para que puedair guardando por prioridades 

        List<Autor> autores = autorServicio.buscarPorNombre(nombre);

        modelo.addAttribute("autores", autores); //cada vez que nombre autores hago referendia a la lista autores 

        modelo.put("exito", "Registro exitoso"); //si la palabra es exito me pone el cartel exitoso
        return "cargar-autor";

    }
    
    @PostMapping("/registro")
    public String guardarAutor(ModelMap modelo, @RequestParam String nombre) {

        try {

            autorServicio.guardar(nombre);

            modelo.put("exitoGuardar", "Registro exitoso");
            return "cargar-autor";
        } catch (Exception e) {
            modelo.put("errorGuardar", "Falto algun dato");
            return "cargar-autor";
        }
    }
    
    @GetMapping("/baja/{id}")
	public String baja(ModelMap modelo, @PathVariable String id) {

		try {
			autorServicio.baja(id);
			return "redirect:/autor/cargarautor";
		} catch (Exception e) {
			return "redirect:/";
		}
	}
	@GetMapping("/alta/{id}")
	public String alta(ModelMap modelo, @PathVariable String id) {

		try {
			autorServicio.alta(id);
			return "redirect:/autor/cargarautor";
		} catch (Exception e) {
			return "redirect:/";
		}
	}
}
