package med.voll.ApiMedic.controller.Pacientes;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//Mostramos los datos
public interface PacienteRepository extends JpaRepository<Pacientes, Long> {
    Page<Pacientes> findByActivoTrue(Pageable paginacion);
}
