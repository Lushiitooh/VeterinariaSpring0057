package cl.awakelab.veterinariaalphaomega.service.serviceimpl;

import cl.awakelab.veterinariaalphaomega.entity.Usuario;
import cl.awakelab.veterinariaalphaomega.repository.IUsuarioRepository;
import cl.awakelab.veterinariaalphaomega.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    IUsuarioRepository objUsuarioRepo;
    private IUsuarioRepository usuarioRepository;
    @Override
    public Usuario crearUsuario(Usuario nuevoUsuario) {
        return usuarioRepository.save(nuevoUsuario);
    }
    @Override
    public Usuario actualizarUsuario(int id) {
        return null;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void eliminarUsuario(int id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario listarUsuarioId(int id) {
        return null;
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }
}
