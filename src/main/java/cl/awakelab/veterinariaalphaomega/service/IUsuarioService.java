package cl.awakelab.veterinariaalphaomega.service;

import cl.awakelab.veterinariaalphaomega.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    public Usuario crearUsuario(Usuario nuevoUsuario);
    public Usuario actualizarUsuario(Usuario usuario);
    public List<Usuario> listarUsuarios();
    public Usuario buscarUsuarioPorId(Integer id);
    public void eliminarUsuario(int idUsuario);
    public Usuario listarUsuarioId(int id);
}
