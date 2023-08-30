package cl.awakelab.veterinariaalphaomega.service;

import cl.awakelab.veterinariaalphaomega.entity.Veterinario;

import java.util.List;

public interface IVeterinarioService {
    public Veterinario crearVeterinario(Veterinario veterinarioCreado);

    public Veterinario actualizarVeterinario (int idVeterinario);

    public List<Veterinario> listarVeterinarios();

    public void eliminarVeterinario(int idVeterinario);
}
