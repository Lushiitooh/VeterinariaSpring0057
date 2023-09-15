package cl.awakelab.veterinariaalphaomega.controller;

import cl.awakelab.veterinariaalphaomega.entity.Usuario;
import cl.awakelab.veterinariaalphaomega.entity.Veterinario;
import cl.awakelab.veterinariaalphaomega.service.IUsuarioService;
import cl.awakelab.veterinariaalphaomega.service.IVeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/veterinario")
public class VeterinarioController {
    @Autowired
    IVeterinarioService objVeterinarioService;
    @Autowired
    IUsuarioService objUsuarioService;
    @GetMapping
    public String listarVeterinarios(Model model){
        List<Veterinario> listaVeterinarios = objVeterinarioService.listarVeterinarios();
        model.addAttribute("atributoListaVeterinarios", listaVeterinarios);
        return "templateListarVeterinarios";
    }
    @GetMapping("/crearVeterinario")//Llama al formulario
    public String mostrarFormularioCrearVeterinario(Model model){
        List<Usuario> listaUsuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "templateFormularioCrearVeterinario";
    }
    @PostMapping("/crearVeterinario")
    public String crearVeterinario(@ModelAttribute Veterinario veterinario){
        objVeterinarioService.crearVeterinario(veterinario);
        return "redirect:/veterinario";
    }
    @GetMapping("/editarVeterinario/{id}")
    public String mostrarFormularioEdicion(@PathVariable int id, Model model) {
        Veterinario veterinario = objVeterinarioService.listarVeterinarioId(id);

        if (veterinario == null) {
            // Manejo de error si el veterinario no existe
            return "redirect:/veterinario";
        }

        model.addAttribute("veterinario", veterinario);
        return "templateFormularioEditarVeterinario";
    }
    @PostMapping("/editarVeterinario/{id}")
    public String actualizarVeterinario(@PathVariable int id, @ModelAttribute Veterinario veterinario) {
        // Lógica para actualizar el veterinario en la base de datos
        objVeterinarioService.actualizarVeterinario(id, veterinario);
        // Redirecciona a la página de lista de veterinarios o a donde desees después de la edición
        return "redirect:/veterinario";
    }

}
