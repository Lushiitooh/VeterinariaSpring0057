package cl.awakelab.veterinariaalphaomega.service.serviceimpl;

import cl.awakelab.veterinariaalphaomega.entity.Mascota;
import cl.awakelab.veterinariaalphaomega.repository.IMascotaRepository;
import cl.awakelab.veterinariaalphaomega.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("mascotaServiceImpl")
public class MascotaServiceImpl implements IMascotaService {

    @Autowired
    private IMascotaRepository mascotaRepository;

    @Override
    public Mascota crearMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }
    @Override
    public List<Mascota> listarMascota() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota listarMascotaPorId(int id) {
        return mascotaRepository.findById(id).orElse(null);
    }

    @Override
    public Mascota actualizarMascota(int id) {
        return null;
    }
    @Override
    public void eliminarMascota(int idMascota) {
        mascotaRepository.deleteById(idMascota);
    }
}
