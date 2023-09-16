package cl.awakelab.veterinariaalphaomega.restcontroller;

import cl.awakelab.veterinariaalphaomega.entity.Mascota;
import cl.awakelab.veterinariaalphaomega.service.IMascotaService;
import cl.awakelab.veterinariaalphaomega.service.IPropietarioService;
import cl.awakelab.veterinariaalphaomega.service.IVeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascota")
public class MascotaRestController {
    @Autowired
    IMascotaService objMascotaService;
    @Autowired
    IPropietarioService objPropietarioService;
    @Autowired
    IVeterinarioService objVeterinarioService;
    @PostMapping
    public Mascota crearMascota(@RequestBody Mascota mascota){
        objMascotaService.crearMascota(mascota);
        return mascota;
    }

    @GetMapping
    public List<Mascota> listarMascota(){
        return objMascotaService.listarMascota();
    }

    @GetMapping("/{id}")
    public Mascota listarMascotaId(@PathVariable int id){
        return objMascotaService.listarMascotaPorId(id);
    }

    @PutMapping
    public Mascota actualizarMascota(@RequestBody Mascota mascota){
        return  objMascotaService.actualizarMascota(mascota);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMascota(@PathVariable int id){
        objMascotaService.eliminarMascota(id);
        return ResponseEntity.ok("Mascota eliminado exitosamente");
    }

}
