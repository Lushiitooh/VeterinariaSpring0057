package cl.awakelab.veterinariaalphaomega.service;

import cl.awakelab.veterinariaalphaomega.entity.Usuario;
import cl.awakelab.veterinariaalphaomega.entity.Veterinario;

import java.util.List;

public interface IVeterinarioService {
    public Veterinario crearVeterinario(Veterinario veterinarioCreado);
    public Veterinario actualizarVeterinario (int idVeterinario, Veterinario veterinario);
    public List<Veterinario> listarVeterinarios();
    public void eliminarVeterinario(int idVeterinario);
    public Veterinario listarVeterinarioId(int id);
    public Veterinario buscarVeterinarioPorId (Integer id);
}
