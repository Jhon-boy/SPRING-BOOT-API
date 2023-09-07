package med.voll.ApiMedic.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.ApiMedic.DTO_MEDICO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/medicos")
public class MedicosController {

    @Autowired
    private MedicoRepository medicoRepositor;

    @PostMapping
    public void RegistrarMedico(@RequestBody @Valid  DatosRegistroMedico datosRegistroMedico){
        //medicoRepositor.save(new Medico(datosRegistroMedico));
        medicoRepositor.save(new Medico(datosRegistroMedico));
    }
    // traemos todos los listados
   /* @GetMapping
    public List<DatosListadoMedico> listadoMedico(){
        // mapeamos los datos donde por medio de findAll le decimos que datos nomas tenemos que pasar
        // creamos otro record con los datos que deben ser enviados tranformamos a una lista
        return medicoRepositor.findAll().stream().map(DatosListadoMedico::new).toList();
    }*/
    // Mapeamos unicamente el parametro -> y ademas declaramos que unicamente se me envie unicamente 2 por default
     @GetMapping
    public Page<DatosListadoMedico> listadoMedico(@PageableDefault(size = 5) Pageable paginacion){
        return medicoRepositor.findByActiveTrue(paginacion).map(DatosListadoMedico::new);
    }
    // findByActiveTrue si el parametro Active esta en TRUE de lo devuelve
    /* actualziar medico */
    @PutMapping
    @Transactional
    public void actualizarMedico(@RequestBody @Valid  DatosActualizarMedico actualizarMedico){
        Medico medico = medicoRepositor.getReferenceById(actualizarMedico.id());
        medico.actualizarDatos(actualizarMedico);
    }
/*    @DeleteMapping("/{id}")  // Delete en base de datos
    @Transactional // nos permite tener un efecto en la base de datos
    public void eliminarMedico(@PathVariable Long id){
        Medico medico = medicoRepositor.getReferenceById(id); // obtenemos por referncia
        medicoRepositor.delete((medico));

    }*/
    // DELETE LOGICO
        @DeleteMapping("/{id}")
        @Transactional // nos permite tener un efecto en la base de datos
            public void eliminarMedico(@PathVariable Long id){
            Medico medico = medicoRepositor.getReferenceById(id); // obtenemos por el id
            medico.desactivarMedico();
        }
}
