package cl.awakelab.veterinariaalphaomega.service.serviceimpl;

import cl.awakelab.veterinariaalphaomega.entity.Usuario;
import cl.awakelab.veterinariaalphaomega.repository.IUsuarioRepository;
import cl.awakelab.veterinariaalphaomega.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Usuario actualizarUsuario(Usuario usuario) {
        Usuario usuarioActualizado = new Usuario();
        usuarioActualizado = objUsuarioRepo.findById(usuario.getId()).orElse(null);
        usuarioActualizado.setNombreUsuario(usuario.getNombreUsuario());
        usuarioActualizado.setRol(usuario.getRol());
        usuarioActualizado.setContrasena(usuario.getContrasena());
        objUsuarioRepo.save(usuarioActualizado);
        return usuarioActualizado;
    }
    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios= objUsuarioRepo.findAll();
        return listaUsuarios;
    }
    @Override
    public void eliminarUsuario(int id) {
        usuarioRepository.deleteById(id);
    }
    @Override
    public Usuario listarUsuarioId(int id) {
        return objUsuarioRepo.findById(id).orElse(null);
    }
    @Override
    public Usuario buscarUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }
}
