package cl.awakelab.veterinariaalphaomega.service.serviceimpl;

import cl.awakelab.veterinariaalphaomega.entity.Mascota;
import cl.awakelab.veterinariaalphaomega.repository.IMascotaRepository;
import cl.awakelab.veterinariaalphaomega.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("mascotaServiceImpl")
public class MascotaServiceImpl implements IMascotaService {
    @Autowired
    private IMascotaRepository objMascotaRepo;
    @Override
    public Mascota crearMascota(Mascota mascota) {
        return objMascotaRepo.save(mascota);
    }
    @Override
    public List<Mascota> listarMascota() {
        List<Mascota> listaMascota = new ArrayList<>();
        listaMascota = objMascotaRepo.findAll();
        return listaMascota;
    }

    @Override
    public Mascota listarMascotaPorId(int id) {
        return objMascotaRepo.findById(id).orElse(null);
    }

    @Override
    public Mascota actualizarMascota(Mascota mascota) {
        Mascota usuarioActualizado = new Mascota();
        usuarioActualizado = objMascotaRepo.findById(mascota.getId()).orElse(null);
        usuarioActualizado.setNombre(mascota.getNombre());
        usuarioActualizado.setFechaNac(mascota.getFechaNac());
        usuarioActualizado.setEspecie(mascota.getEspecie());
        usuarioActualizado.setRaza(mascota.getRaza());
        usuarioActualizado.setColor(mascota.getColor());
        usuarioActualizado.setPropietarioMascota(mascota.getPropietarioMascota());
        objMascotaRepo.save(usuarioActualizado);
        return usuarioActualizado;
    }
    @Override
    public void eliminarMascota(int idMascota) {
        objMascotaRepo.deleteById(idMascota);
    }
}
