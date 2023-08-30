package cl.awakelab.veterinariaalphaomega.repository;

import cl.awakelab.veterinariaalphaomega.entity.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVeterinarioRepository extends JpaRepository<Veterinario,Integer> {
}
