package cl.awakelab.veterinariaalphaomega.service.serviceimpl;

import cl.awakelab.veterinariaalphaomega.entity.Mascota;
import cl.awakelab.veterinariaalphaomega.service.IMascotaService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("mascotaServiceImpl")
public class MascotaServiceImpl implements IMascotaService {
    @Override
    public List<Mascota> listarMascota() {
        return null;
    }

    @Override
    public Mascota crearMascota(Mascota mascota) {
        return null;
    }

    @Override
    public Mascota actualizarMascota(Mascota mascota) {
        return null;
    }

    @Override
    public void eliminarMascota(int idMascota) {

    }
}
