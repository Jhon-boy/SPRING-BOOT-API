package med.voll.ApiMedic.controller.Pacientes;

import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroPacientes(
        @NotBlank
        String nombre,
        @NotBlank
        String email,
        @NotBlank
        String documento_identidad,
        @NotBlank
        String telefono,

       @Embedded
        @Valid
        DatosDireccionP direccion

) { }
