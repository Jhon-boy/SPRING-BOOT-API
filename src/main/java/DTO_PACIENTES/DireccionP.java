package DTO_PACIENTES;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.ApiMedic.controller.Pacientes.DatosDireccionP;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DireccionP {
    private String distrito;
    private String ciudad;
    private String numero;
    private String complemento;
    private  String provincia;
    private String urbanizacion;
    private  String codigo_postal;

    public DireccionP(DatosDireccionP direccion) {
        this.distrito = direccion.distrito();
        this.ciudad = direccion.ciudad();
        this.numero = direccion.numero();
        this.complemento = direccion.complemento();
        this.provincia = direccion.provincia();
        this.codigo_postal = direccion.codigo_postal();
        this.urbanizacion = direccion.urbanizacion();
    }

    public DireccionP actualizarDireccionP(DatosDireccionP actualizar) {
        this.distrito = actualizar.distrito();
        this.ciudad = actualizar.ciudad();
        this.numero = actualizar.numero();
        this.complemento = actualizar.complemento();
        this.provincia = actualizar.provincia();
        this.codigo_postal = actualizar.codigo_postal();
        this.urbanizacion = actualizar.urbanizacion();
        return  this;
    }
}
