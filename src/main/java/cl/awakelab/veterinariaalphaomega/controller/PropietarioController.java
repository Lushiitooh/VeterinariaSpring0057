package cl.awakelab.veterinariaalphaomega.controller;

import cl.awakelab.veterinariaalphaomega.entity.Propietario;
import cl.awakelab.veterinariaalphaomega.service.IPropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/propietario")
public class PropietarioController {
    @Autowired
    IPropietarioService objPropietarioService;

    @GetMapping
    public String listarPropietario(Model model){
        List<Propietario> listaPropietarios = objPropietarioService.listarPropietarios();
        model.addAttribute("atributoListaPropietarios", listaPropietarios);
        return "templateListarPropietarios";
    }

    @GetMapping("/crearPropietario")//Llama al formulario
    public String mostrarFormularioCrearPropietario(){
        return "templateFormularioCrearPropietario";
    }
    @PostMapping("/crearPropietario")
    public String crearUsuario(@ModelAttribute Propietario propietario){
        objPropietarioService.crearPropietario(propietario);
        return "redirect:/propietario";
    }
    @GetMapping("/editarPropietario/{id}")
    public String mostrarFormularioEdicion(@PathVariable int id, Model model) {
        Propietario propietario = objPropietarioService.buscarPropietarioId(id);

        if (propietario == null) {
            // Manejo de error si el usuario no existe
            return "redirect:/propietario";
        }

        model.addAttribute("propietario", propietario);
        return "templateFormularioEditarUsuario";
    }
    @PostMapping("/editarPropietario/{id}")
    public String actualizarPropietario(@PathVariable int id, @ModelAttribute Propietario propietario) {
        // Lógica para actualizar el usuario en la base de datos
        objPropietarioService.actualizarPropietario(id, propietario);
        // Redirecciona a la página de lista de usuarios o a donde desees después de la edición
        return "redirect:/propietario";
    }
}
