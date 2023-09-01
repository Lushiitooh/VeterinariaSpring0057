package cl.awakelab.veterinariaalphaomega.restcontroller;


import cl.awakelab.veterinariaalphaomega.entity.Usuario;
import cl.awakelab.veterinariaalphaomega.entity.Veterinario;
import cl.awakelab.veterinariaalphaomega.service.IVeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
public class VeterinarioRestController {
    @Autowired
    IVeterinarioService objVeterinarioService;

    @PostMapping
    public Veterinario crearVeterinario(@RequestBody Veterinario veterinario){
        return objVeterinarioService.crearVeterinario(veterinario);
    }

    @GetMapping
    public List<Veterinario> listarVeterinarios(){
        return objVeterinarioService.listarVeterinarios();
    }

    @GetMapping("/{id}")
    public Veterinario listarVeterinarioId(@PathVariable int id){
        return objVeterinarioService.listarVeterinarioId(id);
    }

    @DeleteMapping
    public void eliminarVeterinario (@RequestBody int idVeterinario){
        objVeterinarioService.eliminarVeterinario(idVeterinario);
    }

    @PutMapping
    public Veterinario actualizarVeterinario (@RequestBody Veterinario veterinario, @PathVariable int idVeterinario){
        Veterinario veterinarioActual =objVeterinarioService.buscarVeterinarioPorId(idVeterinario);
        Veterinario veterinarioNuevo =null;

        veterinarioActual.setNombres(veterinario.getNombres());
        veterinarioActual.setApellido1(veterinario.getApellido1());
        veterinarioActual.setApellido2(veterinario.getApellido2());
        veterinarioActual.setEspecialidad(veterinario.getEspecialidad());
        veterinarioNuevo = objVeterinarioService.crearVeterinario(veterinarioActual);
        return veterinarioNuevo;
    }



}
