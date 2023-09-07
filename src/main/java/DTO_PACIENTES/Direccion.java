package DTO_PACIENTES;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.ApiMedic.DTO_MEDICO.DatosActualizarMedico;
import med.voll.ApiMedic.DTO_MEDICO.DatosDireccion;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {
    private String calle;
    private String distrito;
    private String cuidad;
    private String numero;
    private String complemento;

    public Direccion(DatosDireccion direccion) {
        this.calle = direccion.calle();
        this.distrito = direccion.distrito();
        this.cuidad = direccion.cuidad();
        this.numero = direccion.numero();
        this.complemento = direccion.complemento();
    }

    public Direccion actualizarDireccion(DatosDireccion actualizarDireccion) {
        this.calle = actualizarDireccion.calle();
        this.distrito = actualizarDireccion.distrito();
        this.cuidad = actualizarDireccion.cuidad();
        this.numero = actualizarDireccion.numero();
        this.complemento = actualizarDireccion.complemento();
        return  this;
    }
}
