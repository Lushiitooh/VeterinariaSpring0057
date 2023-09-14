package cl.awakelab.veterinariaalphaomega.service.serviceimpl;

import cl.awakelab.veterinariaalphaomega.entity.Propietario;
import cl.awakelab.veterinariaalphaomega.repository.IPropietarioRepository;
import cl.awakelab.veterinariaalphaomega.service.IPropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("propietarioServiceImpl")
public class PropietarioServiceImpl implements IPropietarioService {
    @Autowired
    IPropietarioRepository objPropietarioRepo;
    @Override
    public Propietario crearPropietario(Propietario nuevoPropietario) {
        return objPropietarioRepo.save(nuevoPropietario);
    }
    @Override
    public Propietario actualizarPropietario(int id, Propietario propietario) {
        Propietario propietarioActualizado = new Propietario();
        propietarioActualizado = objPropietarioRepo.findById(propietarioActualizado.getId()).orElse(null);
        propietarioActualizado.setNombre(propietarioActualizado.getNombre());
        propietarioActualizado.setApellido(propietarioActualizado.getApellido());
        propietarioActualizado.setTelefono(propietarioActualizado.getTelefono());
        propietarioActualizado.setCorreoElectronico(propietarioActualizado.getCorreoElectronico());
        objPropietarioRepo.save(propietarioActualizado);
        return propietarioActualizado;
    }
    @Override
    public List<Propietario> listarPropietarios() {
        List<Propietario> listaPropietarios =new ArrayList<>();
        listaPropietarios = objPropietarioRepo.findAll();
        return listaPropietarios;
    }
    @Override
    public void eliminarPropietario(int id) {
        objPropietarioRepo.deleteById(id);
    }
    @Override
    public Propietario buscarPropietarioId(int id) {
        return objPropietarioRepo.findById(id).orElse(null);
    }
}
