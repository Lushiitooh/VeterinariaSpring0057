package cl.awakelab.veterinariaalphaomega.controller;

import cl.awakelab.veterinariaalphaomega.entity.Mascota;
import cl.awakelab.veterinariaalphaomega.entity.Usuario;
import cl.awakelab.veterinariaalphaomega.service.IMascotaService;
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
@RequestMapping("/api/mascota")
public class MascotaController {

   /* @Autowired
    private MascotaServiceImpl mascotaService;*/


    /* Estructura del JSON
    *   {
           "id": no se coloca,
          "nombre": "Nombre de la Mascota",
          "fechaNac": "Fecha de Nacimiento",
          "especie": "Especie",
          "raza": "Raza",
          "color": "Color",
          "propietarioMascota": {
                  "id": 1,
                  "nombre": "Nombre del Propietario",
                  "apellido": "Apellido del Propietario",
                  "telefono": "Teléfono del Propietario",
                  "correoElectronico": "correo@example.com",
                  "usuario": {
                        "id": 1,
                        "nombreUsuario": "nombre_usuario",
                        "contrasena": "contraseña"
                  },
                  "listaMascotas": [
                        {
                          "id": 1,
                          "nombre": "Nombre de la Mascota 1",
                          "fechaNac": "Fecha de Nacimiento Mascota 1",
                          "especie": "Especie Mascota 1",
                          "raza": "Raza Mascota 1",
                          "color": "Color Mascota 1"
                        },
                        {
                          "id": 2,
                          "nombre": "Nombre de la Mascota 2",
                          "fechaNac": "Fecha de Nacimiento Mascota 2",
                          "especie": "Especie Mascota 2",
                          "raza": "Raza Mascota 2",
                          "color": "Color Mascota 2"
                        }
                  ]
            }
       }
    * */
   /* @RequestMapping(value = "/mascota", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Mascota mascota, BindingResult result) {
        Mascota nuevaMascota = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(error -> "El campo " + error.getField() + " " + error.getDefaultMessage())
                    .toList();

            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            nuevaMascota = mascotaService.crearMascota(mascota);
        } catch (DataAccessException e) {
            response.put("message", "Error al realizar el insert en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Mascota creada con exito");
        response.put("mascota", nuevaMascota);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/mascotas", method = RequestMethod.GET)
    public List<Mascota> getAll() {
        return mascotaService.listarMascota();
    }

    @RequestMapping(value = "/mascota/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> show(@PathVariable Integer id) {
        Mascota mascota = null;
        Map<String, Object> response = new HashMap<>();

        try {
            mascota = mascotaService.listarMascotaPorId(id);
        } catch (DataAccessException e) {
            response.put("message", "Error al buscar en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (mascota == null) {
            response.put("message", "La mascota ID: ".concat(id.toString()).concat(" no existe en la base de datos"));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mascota, HttpStatus.OK);
    }

    @RequestMapping(value = "/mascota/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Mascota mascota, BindingResult result, @PathVariable Integer id) {
        Mascota mascotaActual = mascotaService.listarMascotaPorId(id);
        Mascota mascotaNueva = null;

        Map<String, Object> response = new HashMap<>();

        //TODO: Hacer el manejo de errores.
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream().map(
                            err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                    .toList();
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if (mascotaActual == null) {
            response.put("message", "Error: no se pudo editar, la mascota ID: ".concat(id.toString().concat(" no existe en la base de datos.")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        try {
            mascotaActual.setNombre(mascota.getNombre());
            mascotaActual.setEspecie(mascota.getEspecie());
            mascotaActual.setRaza(mascota.getRaza());
            mascotaActual.setColor(mascota.getColor());
            mascotaActual.setFechaNac(mascota.getFechaNac());
            mascotaActual.setPropietarioMascota(mascota.getPropietarioMascota());
            mascotaNueva = mascotaService.crearMascota(mascotaActual);
        } catch (DataAccessException e) {
            response.put("message", "Error al actualizar la base de datos.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "la mascota ha sido actualizado con exito");
        response.put("mascota", mascotaNueva);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @RequestMapping(value="/mascota/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            mascotaService.eliminarMascota(id);
        } catch (DataAccessException e) {
            response.put("message", "Error al eliminar la base de datos.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "la mascota fue eliminada con exito!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/

    @Autowired
    IMascotaService objMascotaService;

    @GetMapping
    public String listarMascota(Model model){
        List<Mascota> listaMascotas = objMascotaService.listarMascota();
        model.addAttribute("atributoListaMascotas", listaMascotas);
        return "templateListarMascotas";
    }
}
