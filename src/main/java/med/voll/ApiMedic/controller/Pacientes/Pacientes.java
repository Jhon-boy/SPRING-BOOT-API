package med.voll.ApiMedic.controller.Pacientes;

import DTO_PACIENTES.DireccionP;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pacientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String documento_identidad;
    private String telefono;
    private  boolean activo;

    @Embedded
    private DireccionP direccionP;

    public  Pacientes(DatosRegistroPacientes datospacientes){
        this.activo = true;
        this.nombre = datospacientes.nombre();
        this.email = datospacientes.email();
        this.documento_identidad = datospacientes.documento_identidad();
        this.telefono = datospacientes.telefono();
        this.direccionP = new DireccionP(datospacientes.direccion());
    }

    public void actualizar(DatosActualiarPaciente datosActualiarPacientepaciente) {
        if(datosActualiarPacientepaciente.nombre() != null){
            this.nombre = datosActualiarPacientepaciente.nombre();
        }
       if(datosActualiarPacientepaciente.telefono() != null){
           this.telefono = datosActualiarPacientepaciente.telefono();
       }

       if(datosActualiarPacientepaciente.direccionP() != null){
           this.direccionP = direccionP.actualizarDireccionP(datosActualiarPacientepaciente.direccionP());
       }

    }

    public void desactivarPaciente() {
        this.activo = false;
    }
}
