package med.voll.ApiMedic.DTO_MEDICO;

import jakarta.validation.constraints.NotBlank;

public record DatosDireccion (
        @NotBlank
        String calle,
        @NotBlank
        String distrito,
        @NotBlank
        String cuidad,
        @NotBlank
        String numero,
        @NotBlank
        String complemento
){

}
