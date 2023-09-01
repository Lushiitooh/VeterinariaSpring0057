package cl.awakelab.veterinariaalphaomega.restcontroller;

import cl.awakelab.veterinariaalphaomega.entity.Usuario;
import cl.awakelab.veterinariaalphaomega.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PutMapping
    public Usuario actualizarUsuario(@RequestBody Usuario usuario, @PathVariable int id){
        Usuario usuarioActual = objUsuarioService.buscarUsuarioPorId(id);
        Usuario usuarioNuevo = null;

        usuarioActual.setNombreUsuario(usuario.getNombreUsuario());
        usuarioActual.setVeterinario(usuario.getVeterinario());
        usuarioActual.setContrasena(usuario.getContrasena());
        usuarioNuevo = objUsuarioService.crearUsuario(usuarioActual);
        return usuarioNuevo;
    }
    @DeleteMapping
    public void eliminarUsuario(@RequestBody int id){
        objUsuarioService.eliminarUsuario(id);
    }
    @GetMapping("/{id}")
    public Usuario listarUsuarioId(@PathVariable int id){
        return objUsuarioService.listarUsuarioId(id);
    }
}
