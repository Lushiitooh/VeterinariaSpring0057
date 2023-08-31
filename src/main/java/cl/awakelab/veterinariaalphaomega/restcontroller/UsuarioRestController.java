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
    @GetMapping("/{id}")
    public Usuario listarUsuarioId(@PathVariable int id){
        return objUsuarioService.listarUsuarioId(id);
    }
}
