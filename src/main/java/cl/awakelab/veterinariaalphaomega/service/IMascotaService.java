package cl.awakelab.veterinariaalphaomega.service;

import cl.awakelab.veterinariaalphaomega.entity.Mascota;

import java.util.List;

public interface IMascotaService {
    public Mascota crearMascota(Mascota mascota);
    public List<Mascota> listarMascota();
    public Mascota listarMascotaPorId(int idMascota);
    public Mascota actualizarMascota(Mascota mascota);
    public void eliminarMascota(int idMascota);
}
