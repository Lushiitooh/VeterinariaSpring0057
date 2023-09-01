package cl.awakelab.veterinariaalphaomega.service;

import cl.awakelab.veterinariaalphaomega.entity.Propietario;

import java.util.List;

public interface IPropietarioService {
    public Propietario crearPropietario(Propietario nuevoPropietario);
    public Propietario actualizarPropietario(int id, Propietario propietarioActualizado);
    public List<Propietario> listarPropietarios();
    public void eliminarPropietario(int id);
    public Propietario buscarPropietarioId(int id);

}
