package cl.awakelab.veterinariaalphaomega.service;

import cl.awakelab.veterinariaalphaomega.entity.Mascota;

import java.util.List;

public interface IMascotaService {
    public List<Mascota> listarMascota();
    public Mascota crearMascota(Mascota alumno);
    public Mascota actualizarMascota(Mascota alumno);
    public void eliminarMascota(int idMascota);
}
