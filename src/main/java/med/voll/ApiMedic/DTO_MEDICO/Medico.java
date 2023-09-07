package med.voll.ApiMedic.DTO_MEDICO;

import DTO_PACIENTES.Direccion;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@Entity(name = "Medico")
@Table(name = "medicos")
@Getter
@NoArgsConstructor // constructor sin parametro
@AllArgsConstructor // constructor con parametros
@EqualsAndHashCode(of = "id") // usa el iD para las comparaciones con los demas

public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String documento;
    private boolean active;
    private String telefono;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @Embedded
    private Direccion direccion;

    public Medico(DatosRegistroMedico datosRegistroMedico) {
        this.nombre = datosRegistroMedico.nombre();
        this.email = datosRegistroMedico.email();
        this.documento = datosRegistroMedico.documento();
         this.telefono = datosRegistroMedico.telefono();
        this.especialidad = datosRegistroMedico.especialidad();
        this.active = true;
        this.direccion = new Direccion( datosRegistroMedico.direccion());
    }

    public void actualizarDatos(DatosActualizarMedico actualizarMedico) {
        if(actualizarMedico.nombre() !=null){
            this.nombre = actualizarMedico.nombre();
        }
        if (actualizarMedico.documento() !=null){
            this.documento = actualizarMedico.documento();
        }
        if(actualizarMedico.direccion() !=null){
            this.direccion = direccion.actualizarDireccion(actualizarMedico.direccion());
        }
    }
// Desactivo LOGICO
    public void desactivarMedico() {
        this.active = false;
    }
}
