package cl.awakelab.veterinariaalphaomega.repository;

import cl.awakelab.veterinariaalphaomega.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
