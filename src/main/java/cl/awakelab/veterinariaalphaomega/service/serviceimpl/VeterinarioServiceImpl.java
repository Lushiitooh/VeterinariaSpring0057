package cl.awakelab.veterinariaalphaomega.service.serviceimpl;

import cl.awakelab.veterinariaalphaomega.entity.Veterinario;
import cl.awakelab.veterinariaalphaomega.service.IVeterinarioService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("veterinarioServiceImpl")
public class VeterinarioServiceImpl implements IVeterinarioService {


    @Override
    public Veterinario crearVeterinario(Veterinario veterinarioCreado) {
        return null;
    }

    @Override
    public Veterinario actualizarVeterinario(int idVeterinario) {
        return null;
    }

    @Override
    public List<Veterinario> listarVeterinarios() {
        return null;
    }

    @Override
    public void eliminarVeterinario(int idVeterinario) {

    }

    @Override
    public Veterinario listarVeterinarioId(int id) {
        return null;
    }

    @Override
    public Veterinario buscarVeterinarioPorId(Integer id) {
        return null;
    }
}
