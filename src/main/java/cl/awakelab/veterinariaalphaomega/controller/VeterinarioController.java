package cl.awakelab.veterinariaalphaomega.controller;

import cl.awakelab.veterinariaalphaomega.entity.Veterinario;
import cl.awakelab.veterinariaalphaomega.service.IVeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/veterinario")
public class VeterinarioController {
    @Autowired
    IVeterinarioService objVeterinarioService;

    @GetMapping
    public String listarVeterinarios(Model model){
        List<Veterinario> listaVeterinarios = objVeterinarioService.listarVeterinarios();
        model.addAttribute("atributoListaVeterinarios", listaVeterinarios);
        return "templateListarVeterinarios";
    }

}
