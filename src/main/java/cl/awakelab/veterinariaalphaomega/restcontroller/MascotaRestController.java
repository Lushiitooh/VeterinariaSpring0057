package cl.awakelab.veterinariaalphaomega.restcontroller;

import cl.awakelab.veterinariaalphaomega.entity.Mascota;
import cl.awakelab.veterinariaalphaomega.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/mascota")
public class MascotaRestController {
    @Autowired
    IMascotaService objMascotaService;

    @PostMapping
    public Mascota crearMascota(@RequestBody Mascota mascota){
        return  objMascotaService.crearMascota(mascota);
    }

    @GetMapping
    public List<Mascota> listarMascota(){
        return objMascotaService.listarMascota();
    }

    @GetMapping("/{id}")
    public Mascota listarMascotaId(@PathVariable int id){
        return objMascotaService.listarMascotaPorId(id);
    }

    @PutMapping("/{id}")
    public Mascota actualizarMascota(@RequestBody Mascota mascota, @PathVariable int id){
        Mascota mascotaActual = objMascotaService.listarMascotaPorId(id);
        Mascota mascotaNueva = null;

        mascotaActual.setNombre(mascota.getNombre());
        mascotaActual.setFechaNac(mascota.getFechaNac());
        mascotaActual.setEspecie(mascota.getEspecie());
        mascotaActual.setRaza(mascota.getRaza());
        mascotaActual.setColor(mascota.getColor());
        mascotaNueva = objMascotaService.crearMascota(mascotaActual);
        return mascotaNueva;
    }
    @DeleteMapping("/{idMascota}")
    public void eliminarMascota(@PathVariable int idMascota){
        objMascotaService.eliminarMascota(idMascota);
    }

}
