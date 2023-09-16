package cl.awakelab.veterinariaalphaomega.controller;

import cl.awakelab.veterinariaalphaomega.entity.Propietario;
import cl.awakelab.veterinariaalphaomega.entity.Usuario;
import cl.awakelab.veterinariaalphaomega.service.IMascotaService;
import cl.awakelab.veterinariaalphaomega.service.IPropietarioService;
import cl.awakelab.veterinariaalphaomega.service.IUsuarioService;
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
    @Autowired
    IUsuarioService objUsuarioService;
    @Autowired
    IMascotaService objMascotaService;
    @GetMapping
    public String listarPropietario(Model model){
        List<Propietario> listaPropietarios = objPropietarioService.listarPropietarios();
        model.addAttribute("atributoListaPropietarios", listaPropietarios);
        return "templateListarPropietarios";
    }

    @GetMapping("/crearPropietario")//Llama al formulario
    public String mostrarFormularioCrearPropietario(Model model){
        List<Usuario> listaUsuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "templateFormularioCrearPropietario";
    }
    @PostMapping("/crearPropietario")
    public String crearPropietario(@ModelAttribute Propietario propietario){
        objPropietarioService.crearPropietario(propietario);
        return "redirect:/propietario";
    }
    @GetMapping("/editarPropietario/{id}")
    public String mostrarFormularioEdicion(@PathVariable int id, Model model) {
        Propietario propietario = objPropietarioService.listarPropietarioId(id);

        if (propietario == null) {
            // Manejo de error si el propietario no existe
            return "redirect:/propietario";
        }

        model.addAttribute("propietario", propietario);
        return "templateFormularioEditarPropietario";
    }
    @PostMapping("/editarPropietario/{id}")
    public String actualizarPropietario(@PathVariable int id, @ModelAttribute Propietario propietario) {
        // Lógica para actualizar el propietario en la base de datos
        objPropietarioService.actualizarPropietario(propietario);
        // Redirecciona a la página de lista de propietarios o a donde desees después de la edición
        return "redirect:/propietario";
    }
}
