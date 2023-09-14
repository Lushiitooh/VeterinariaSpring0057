package cl.awakelab.veterinariaalphaomega.restcontroller;

import cl.awakelab.veterinariaalphaomega.entity.Usuario;
import cl.awakelab.veterinariaalphaomega.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
public class UsuarioRestController {
    @Autowired
    IUsuarioService objUsuarioService;
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return objUsuarioService.crearUsuario(usuario);
    }
    @GetMapping
    public List<Usuario> listarUsuario(){
        return objUsuarioService.listarUsuarios();
    }
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@RequestBody Usuario usuario, @PathVariable int id){
        Usuario usuarioActual = objUsuarioService.buscarUsuarioPorId(id);
        //Usuario usuarioNuevo = null;

        usuarioActual.setNombreUsuario(usuario.getNombreUsuario());
        usuarioActual.setContrasena(usuario.getContrasena());
        //usuarioNuevo = objUsuarioService.crearUsuario(usuarioActual);
        //return usuarioNuevo;
        return objUsuarioService.actualizarUsuario(usuario);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable int id){
        objUsuarioService.eliminarUsuario(id);
        return ResponseEntity.ok("Usuario eliminado exitosamente");
    }
    @GetMapping("/{id}")
    public Usuario listarUsuarioId(@PathVariable int id){
        return objUsuarioService.listarUsuarioId(id);
    }
}
