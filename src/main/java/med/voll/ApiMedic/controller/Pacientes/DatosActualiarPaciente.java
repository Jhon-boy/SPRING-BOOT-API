package med.voll.ApiMedic.controller.Pacientes;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DatosActualiarPaciente(
        @NotNull
        Long id,
        String nombre,
        String telefono,
       @Valid DatosDireccionP direccionP
) {
}
