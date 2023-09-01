package cl.awakelab.veterinariaalphaomega.service.serviceimpl;

import cl.awakelab.veterinariaalphaomega.entity.Propietario;
import cl.awakelab.veterinariaalphaomega.repository.IPropietarioRepository;
import cl.awakelab.veterinariaalphaomega.service.IPropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("propietarioServiceImpl")
public class PropietarioServiceImpl implements IPropietarioService {

    @Autowired
    private IPropietarioRepository propietarioRepository;
    @Override
    public Propietario crearPropietario(Propietario nuevoPropietario) {
        return null;
    }

    @Override
    public Propietario actualizarPropietario(int id) {
        return null;
    }

    @Override
    public List<Propietario> listarPropietarios() {
        return null;
    }

    @Override
    public void eliminarPropietario(int id) {
        propietarioRepository.deleteById(id);
    }
}
