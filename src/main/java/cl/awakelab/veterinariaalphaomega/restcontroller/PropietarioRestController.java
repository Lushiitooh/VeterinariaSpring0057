package cl.awakelab.veterinariaalphaomega.restcontroller;

import cl.awakelab.veterinariaalphaomega.entity.Propietario;
import cl.awakelab.veterinariaalphaomega.repository.IPropietarioRepository;
import cl.awakelab.veterinariaalphaomega.service.IPropietarioService;
import cl.awakelab.veterinariaalphaomega.service.serviceimpl.PropietarioServiceImpl;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propietario")
public class PropietarioRestController {
    @Autowired
    IPropietarioService objPropietarioService;

    @PostMapping
    public Propietario crearPropietario(@RequestBody Propietario propietario){
        return objPropietarioService.crearPropietario(propietario);
    }

    @GetMapping("/all")
    public List<Propietario> listarPropietario(){
        return objPropietarioService.listarPropietarios();
    }

    @GetMapping("/{id}")
    public Propietario buscarPropietarioId(@PathVariable int id){
        return objPropietarioService.buscarPropietarioId(id);
    }
    @PutMapping("/{id}")
    public Propietario actualizarPropietario(@RequestBody Propietario modificacionPropietario, @PathVariable int id){
        return objPropietarioService.actualizarPropietario(id,modificacionPropietario);
    }

    @DeleteMapping("/{id}")
    public void eliminarPropietario(@PathVariable int id){
        objPropietarioService.eliminarPropietario(id);
    }
}
