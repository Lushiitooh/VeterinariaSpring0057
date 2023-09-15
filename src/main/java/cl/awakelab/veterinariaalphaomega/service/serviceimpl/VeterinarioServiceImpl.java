package cl.awakelab.veterinariaalphaomega.service.serviceimpl;

import cl.awakelab.veterinariaalphaomega.entity.Propietario;
import cl.awakelab.veterinariaalphaomega.entity.Veterinario;
import cl.awakelab.veterinariaalphaomega.repository.IVeterinarioRepository;
import cl.awakelab.veterinariaalphaomega.service.IVeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("veterinarioServiceImpl")
public class VeterinarioServiceImpl implements IVeterinarioService {
    @Autowired
    IVeterinarioRepository objVeterinarioRepo;
    @Override
    public Veterinario crearVeterinario(Veterinario veterinarioCreado) {
        return objVeterinarioRepo.save(veterinarioCreado);
    }
    @Override
    public Veterinario actualizarVeterinario(int idVeterinario, Veterinario veterinario) {
        Veterinario veterinarioActualizado = new Veterinario();
        veterinarioActualizado = objVeterinarioRepo.findById(veterinarioActualizado.getId()).orElse(null);
        veterinarioActualizado.setNombres(veterinarioActualizado.getNombres());
        veterinarioActualizado.setApellido1(veterinarioActualizado.getApellido1());
        veterinarioActualizado.setApellido2(veterinarioActualizado.getApellido2());
        veterinarioActualizado.setEspecialidad(veterinarioActualizado.getEspecialidad());
        objVeterinarioRepo.save(veterinarioActualizado);
        return veterinarioActualizado;
    }

    @Override
    public List<Veterinario> listarVeterinarios() {
        List<Veterinario> listaVeterinarios =new ArrayList<>();
        listaVeterinarios = objVeterinarioRepo.findAll();
        return listaVeterinarios;
    }

    @Override
    public void eliminarVeterinario(int idVeterinario) {
        objVeterinarioRepo.deleteById(idVeterinario);
    }

    @Override
    public Veterinario listarVeterinarioId(int id) {
        return objVeterinarioRepo.findById(id).orElse(null);
    }

    @Override
    public Veterinario buscarVeterinarioPorId(Integer id) {
        return null;
    }
}
