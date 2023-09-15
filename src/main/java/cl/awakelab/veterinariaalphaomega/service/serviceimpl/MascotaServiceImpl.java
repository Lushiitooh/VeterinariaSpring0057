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

        Mascota mascotaActualizada = objMascotaRepo.findById(mascota.getId()).orElse(null);

        if (mascotaActualizada != null) {
            // Actualizar los campos de la mascota existente
            mascotaActualizada.setNombre(mascota.getNombre());
            mascotaActualizada.setFechaNac(mascota.getFechaNac());
            mascotaActualizada.setEspecie(mascota.getEspecie());
            mascotaActualizada.setRaza(mascota.getRaza());
            mascotaActualizada.setColor(mascota.getColor());

            // Verifica y establece propietarioMascota si no es nulo
            if (mascota.getPropietarioMascota() != null) {
                Propietario propietarioMascota = objPropietarioRepo.findById(mascota.getPropietarioMascota().getId()).orElse(null);
                if (propietarioMascota != null) {
                    mascotaActualizada.setPropietarioMascota(propietarioMascota);
                } else {
                    // Manejar el caso en el que el propietario no existe
                }
            }

            // Verifica y establece veterinarioAsignado si no es nulo
            if (mascota.getVeterinarioAsignado() != null) {
                Veterinario vetAsignado = objVeterinarioRepo.findById(mascota.getVeterinarioAsignado().getId()).orElse(null);
                if (vetAsignado != null) {
                    mascotaActualizada.setVeterinarioAsignado(vetAsignado);
                } else {
                    // Manejar el caso en el que el veterinario no existe
                }
            }

            // Guarda la mascota actualizada en la base de datos
            mascotaActualizada = objMascotaRepo.save(mascotaActualizada);
        }

        return mascotaActualizada;
    }
    @Override
    public void eliminarMascota(int idMascota) {
        objMascotaRepo.deleteById(idMascota);
    }
}
