package cl.awakelab.veterinariaalphaomega.repository;

import cl.awakelab.veterinariaalphaomega.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMascotaRepository extends JpaRepository<Mascota, Integer> {
}
