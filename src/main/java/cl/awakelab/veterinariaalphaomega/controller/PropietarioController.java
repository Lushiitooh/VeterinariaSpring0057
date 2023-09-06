package cl.awakelab.veterinariaalphaomega.controller;

import cl.awakelab.veterinariaalphaomega.entity.Propietario;
import cl.awakelab.veterinariaalphaomega.service.IPropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
