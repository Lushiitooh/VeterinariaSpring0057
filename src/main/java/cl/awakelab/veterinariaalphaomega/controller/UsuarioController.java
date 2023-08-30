package cl.awakelab.veterinariaalphaomega.controller;

import cl.awakelab.veterinariaalphaomega.entity.Usuario;
import cl.awakelab.veterinariaalphaomega.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Usuario usuario, BindingResult result) {
        Usuario nuevoUsuario = null;
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
            nuevoUsuario = usuarioService.crearUsuario(usuario);
        } catch (DataAccessException e) {
            response.put("message", "Error al realizar el insert en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Cliente creado con exito");
        response.put("usuario", nuevoUsuario);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public List<Usuario> getAll() {
        return usuarioService.listarUsuarios();
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> show(@PathVariable Integer id) {
        Usuario usuario = null;
        Map<String, Object> response = new HashMap<>();

        try {
            usuario = usuarioService.buscarUsuarioPorId(id);
        } catch (DataAccessException e) {
            response.put("message", "Error al buscar en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (usuario == null) {
            response.put("message", "El usuario ID: ".concat(id.toString()).concat(" no existe en la base de datos"));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Usuario usuario, BindingResult result, @PathVariable Integer id) {
        Usuario usuarioActual = usuarioService.buscarUsuarioPorId(id);
        Usuario usuarioNuevo = null;

        Map<String, Object> response = new HashMap<>();

        //TODO: Hacer el manejo de errores.
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream().map(
                            err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                    .toList();
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if (usuarioActual == null) {
            response.put("message", "Error: no se pudo editar, el usuario ID: ".concat(id.toString().concat(" no existe en la base de datos.")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        try {
            usuarioActual.setNombreUsuario(usuario.getNombreUsuario());
            usuarioActual.setContrasena(usuario.getContrasena());
            usuarioNuevo = usuarioService.crearUsuario(usuarioActual);
        } catch (DataAccessException e) {
            response.put("message", "Error al actualizar la base de datos.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "El cliente ha sido actualizado con exito");
        response.put("usuario", usuarioNuevo);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @RequestMapping(value="/usuario/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            usuarioService.eliminarUsuario(id);
        } catch (DataAccessException e) {
            response.put("message", "Error al eliminar la base de datos.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El usuario fue eliminado con exito!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
