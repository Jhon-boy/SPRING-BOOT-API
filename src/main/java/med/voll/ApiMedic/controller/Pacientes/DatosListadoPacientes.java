package med.voll.ApiMedic.controller.Pacientes;

public record DatosListadoPacientes(String nombre, String email, String documentoIdentidad) {

    public DatosListadoPacientes(Pacientes paciente) {
        this(paciente.getNombre(), paciente.getEmail(), paciente.getDocumento_identidad());
    }
}