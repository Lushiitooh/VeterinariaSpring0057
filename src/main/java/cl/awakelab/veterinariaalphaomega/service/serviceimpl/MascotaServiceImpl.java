package cl.awakelab.veterinariaalphaomega.service.serviceimpl;

import cl.awakelab.veterinariaalphaomega.entity.Mascota;
import cl.awakelab.veterinariaalphaomega.entity.Propietario;
import cl.awakelab.veterinariaalphaomega.entity.Veterinario;
import cl.awakelab.veterinariaalphaomega.repository.IMascotaRepository;
import cl.awakelab.veterinariaalphaomega.repository.IPropietarioRepository;
import cl.awakelab.veterinariaalphaomega.repository.IVeterinarioRepository;
import cl.awakelab.veterinariaalphaomega.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("mascotaServiceImpl")
public class MascotaServiceImpl implements IMascotaService {
    @Autowired
    private IMascotaRepository objMascotaRepo;
    @Autowired
    IPropietarioRepository objPropietarioRepo;
    @Autowired
    private IVeterinarioRepository objVeterinarioRepo;
    @Override
    public Mascota crearMascota(Mascota mascotaCreada) {
        Mascota nuevaMascota = new Mascota();
        Propietario propietarioMascota = new Propietario();
        Veterinario vetAsignado = new Veterinario();
        vetAsignado = objVeterinarioRepo.findById(mascotaCreada.getVeterinarioAsignado().getId()).orElse(null);
        propietarioMascota = objPropietarioRepo.findById(mascotaCreada.getPropietarioMascota().getId()).orElse(null);
        mascotaCreada.setVeterinarioAsignado(vetAsignado);
        mascotaCreada.setPropietarioMascota(propietarioMascota);
        nuevaMascota = objMascotaRepo.save(mascotaCreada);
        return nuevaMascota;
    }
    @Override
    public List<Mascota> listarMascota() {
        List<Mascota> listaMascota = new ArrayList<>();
        listaMascota = objMascotaRepo.findAll();
        return listaMascota;
    }
    @Override
    public Mascota listarMascotaPorId(int idMascota) {
        return objMascotaRepo.findById(idMascota).orElse(null);
    }

    @Override
    public Mascota actualizarMascota(Mascota mascota) {
        Mascota mascotaActualizada = new Mascota();
        mascotaActualizada = objMascotaRepo.findById(mascota.getId()).orElse(null);
        mascotaActualizada.setNombre(mascota.getNombre());
        mascotaActualizada.setFechaNac(mascota.getFechaNac());
        mascotaActualizada.setEspecie(mascota.getEspecie());
        mascotaActualizada.setRaza(mascota.getRaza());
        mascotaActualizada.setColor(mascota.getColor());
        mascotaActualizada.setPropietarioMascota(mascota.getPropietarioMascota());
        mascotaActualizada.setVeterinarioAsignado(mascota.getVeterinarioAsignado());
        mascotaActualizada = objMascotaRepo.save(mascotaActualizada);
        return mascotaActualizada;
    }
    @Override
    public void eliminarMascota(int idMascota) {
        objMascotaRepo.deleteById(idMascota);
    }
}
