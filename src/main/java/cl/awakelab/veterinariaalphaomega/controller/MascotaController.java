package cl.awakelab.veterinariaalphaomega.controller;

import cl.awakelab.veterinariaalphaomega.entity.Mascota;
import cl.awakelab.veterinariaalphaomega.entity.Propietario;
import cl.awakelab.veterinariaalphaomega.entity.Usuario;
import cl.awakelab.veterinariaalphaomega.entity.Veterinario;
import cl.awakelab.veterinariaalphaomega.service.IMascotaService;
import cl.awakelab.veterinariaalphaomega.service.IPropietarioService;
import cl.awakelab.veterinariaalphaomega.service.IVeterinarioService;
import cl.awakelab.veterinariaalphaomega.service.serviceimpl.MascotaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mascota")
public class MascotaController {
    @Autowired
    IMascotaService objMascotaService;
    @Autowired
    IPropietarioService objPropietarioService;
    @Autowired
    IVeterinarioService objVeterinarioService;
    @GetMapping
    public String listarMascotas(Model model){
        List<Mascota> listaMascotas = objMascotaService.listarMascota();
        model.addAttribute("atributoListaMascotas", listaMascotas);
        return "templateListarMascotas";
    }
    @GetMapping("/crearMascota")
    public String mostrarFormularioCrearMascota(Model model){
        List<Propietario> listaPropietarios = objPropietarioService.listarPropietarios();
        List<Veterinario> listaVeterinarios = objVeterinarioService.listarVeterinarios();
        model.addAttribute("listaPropietarios", listaPropietarios);
        model.addAttribute("listaPropietarios", listaVeterinarios);
        return  "templateFormularioCrearMascota";
    }
    @PostMapping("/crearMascota")
    public String crearMascota(@ModelAttribute Mascota mascota){
        objMascotaService.crearMascota(mascota);
        return "redirect:/mascota";
    }
    @PostMapping("/eliminarMascota/{id}")
    public String eliminarMascota(@PathVariable int id){
        objMascotaService.eliminarMascota(id);
        return "redirect:/mascota";
    }
    @GetMapping("/editarMascota/{id}")
    public String mostrarFormularioEdicion(@PathVariable int id, Model model) {
        Mascota mascota = objMascotaService.listarMascotaPorId(id);

        if (mascota == null) {
            // Manejo de error si la mascota no existe
            return "redirect:/mascota";
        }

        List<Veterinario> listarVeterinarios = objVeterinarioService.listarVeterinarios();

        model.addAttribute("mascota", mascota);
        model.addAttribute("listaVeterinarios", listarVeterinarios);
        return "templateFormularioEditarMascota";
    }
    @PostMapping("/editarMascota/{id}")
    public String actualizarMascota(@PathVariable int id, @ModelAttribute Mascota mascota) {
        // Lógica para actualizar la mascota en la base de datos
        objMascotaService.actualizarMascota(mascota);
        // Redirecciona a la página de lista de mascotas o a donde desees después de la edición
        return "redirect:/mascota";
    }

}
