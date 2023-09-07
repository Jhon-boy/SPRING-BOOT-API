package med.voll.ApiMedic.controller.Pacientes;
import jakarta.validation.constraints.NotBlank;

public record DatosDireccionP(
    @NotBlank
    String distrito,
    @NotBlank
    String ciudad,
    @NotBlank
    String numero,
    @NotBlank
    String complemento,

    @NotBlank
    String provincia,
    @NotBlank
    String urbanizacion,

    @NotBlank
    String codigo_postal
){}
