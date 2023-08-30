package cl.awakelab.veterinariaalphaomega.service;

import cl.awakelab.veterinariaalphaomega.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    public Usuario crearUsuario(Usuario nuevoUsuario);
    public Usuario actualizarUsuario(int id);
    public List<Usuario> listarUsuarios();
    public Usuario buscarUsuarioPorId(Integer id);
    public void eliminarUsuario(int id);
}
