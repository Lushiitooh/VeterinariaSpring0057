package cl.awakelab.veterinariaalphaomega.service.serviceimpl;

import cl.awakelab.veterinariaalphaomega.entity.Usuario;
import cl.awakelab.veterinariaalphaomega.service.IUsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements IUsuarioService {
    @Override
    public Usuario crearUsuario(Usuario nuevoUsuario) {
        return null;
    }

    @Override
    public Usuario actualizarUsuario(int id) {
        return null;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return null;
    }

    @Override
    public void eliminarUsuario(int id) {

    }
}
