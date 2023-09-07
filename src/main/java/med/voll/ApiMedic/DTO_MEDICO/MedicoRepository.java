package med.voll.ApiMedic.DTO_MEDICO;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

// un repositorio es un tipo de Java que tiene ya todas las implementaciones
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findByActiveTrue(Pageable paginacion);
}
