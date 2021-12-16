package mx.com.gm.web;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;


@Controller
@Slf4j
public class ControladorInicio {

    /*@Value("${index.saludo}")
    private String saludo;*/

    //inyectamos la interfaz controlador

    /*@Autowired
    private PersonaDao personaDao;*/

    @Autowired
    private PersonaService personaService;


    @GetMapping("/")
    public String inicio(Model model) {
        var personas=personaService.listarPersonas();
        log.info("ejecutando el controlador spring mvc");
        model.addAttribute("personas" , personas);
        return "index";


        /*var mensaje="Adios mundo con Thymeleaf";

        var persona= new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setEmail("jperez@gmail.com");
        persona.setTelefono("554467");

        var persona2= new Persona();
        persona2.setNombre("Karla");
        persona2.setApellido("Gomez");
        persona2.setEmail("kgomez@gmail.com");
        persona2.setTelefono("759844");

        var  personas = Arrays.asList(persona , persona2);

        //log.info("ejecutando el controlador rest");
        log.info("ejecutando el controlador spring mvc");
        model.addAttribute("mensaje" , mensaje);
        model.addAttribute("saludo" , saludo);
        //model.addAttribute("persona" , persona);
        model.addAttribute("personas" , personas);
        return "index";*/
        // en el htlm
        // <p th:text="${mensaje}"></p>
        //<p th:text="${saludo}"></p>
    }

    @GetMapping("/agregar")
        public String agregar(Persona persona){
          return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona,Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona" ,persona);
        return "modificar";
    }

    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona){
         personaService.eliminar(persona);
          return "redirect:/";
        }
    }


