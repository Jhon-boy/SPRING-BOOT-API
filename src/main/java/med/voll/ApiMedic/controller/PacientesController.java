package med.voll.ApiMedic.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.ApiMedic.controller.Pacientes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pacientes")
public class PacientesController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    public void registarPaciente(@RequestBody @Valid DatosRegistroPacientes registroPacientes){
        pacienteRepository.save(new Pacientes(registroPacientes));
    }

    //devuelve el listado de los pacientes, dado que solo mostrara los datos que se le pida y no mas
    // en este ejemplo realizamos el listado de nombre, email y documento_identidad;
 /*   @GetMapping
    public List<DatosListadoPacientes> listadoCompleto(){
        return pacienteRepository.findAll().stream().map(DatosListadoPacientes::new).toList();
    }*/
    //Listado por paginacion

    @GetMapping
    public Page<DatosListadoPacientes> listadoPacientes(@PageableDefault(size = 5) Pageable paginacion){
       return pacienteRepository.findByActivoTrue(paginacion).map(DatosListadoPacientes::new);
    }

    @PutMapping
    @Transactional
    public void actualizarPaciente(@RequestBody @Valid DatosActualiarPaciente actualiarPaciente){
    Pacientes paciente = pacienteRepository.getReferenceById(actualiarPaciente.id());
    paciente.actualizar(actualiarPaciente);
    }

 /*   @DeleteMapping("/{id}")
    @Transactional
    public  void eliminarPaciente(@PathVariable Long id){
        Pacientes paciente = pacienteRepository.getReferenceById(id);
        paciente.desactivarPaciente();
    }
    */
 @DeleteMapping("/{id}")
    @Transactional
    public void eliminarDeVerdad(@PathVariable Long id){
        Pacientes pacientes = pacienteRepository.getReferenceById(id);
        pacienteRepository.delete(pacientes);
    }
}
