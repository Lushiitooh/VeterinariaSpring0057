package cl.awakelab.veterinariaalphaomega.restcontroller;


import cl.awakelab.veterinariaalphaomega.entity.Usuario;
import cl.awakelab.veterinariaalphaomega.entity.Veterinario;
import cl.awakelab.veterinariaalphaomega.service.IVeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinario")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarVeterinario(@PathVariable int id){
        objVeterinarioService.eliminarVeterinario(id);
        return ResponseEntity.ok("Veterinario eliminado exitosamente");
    }

    @PutMapping("/{id}")
    public Veterinario actualizarVeterinario (@RequestBody Veterinario veterinario, @PathVariable int id){
        return objVeterinarioService.actualizarVeterinario(id,veterinario);
    }
}
