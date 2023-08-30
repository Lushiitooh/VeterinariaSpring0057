package cl.awakelab.veterinariaalphaomega.repository;

import cl.awakelab.veterinariaalphaomega.entity.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPropietarioRepository extends JpaRepository<Propietario, Integer> {
}
