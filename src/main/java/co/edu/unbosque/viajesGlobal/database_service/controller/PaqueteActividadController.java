package co.edu.unbosque.viajesGlobal.database_service.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unbosque.viajesGlobal.database_service.model.PaqueteActividad;
import co.edu.unbosque.viajesGlobal.database_service.model.PaqueteActividadId;
import co.edu.unbosque.viajesGlobal.database_service.repository.PaqueteActividadRepository;

@RestController
public class PaqueteActividadController {

    @Autowired
    private PaqueteActividadRepository paqueteActividadRepository;

    // Método para agregar un paquete de actividad
    @PostMapping("/agregarPaqueteActividad")
    public ResponseEntity<String> agregarPaqueteActividad(@RequestParam("idPaquete") Integer idPaquete,
                                                           @RequestParam("idActividad") Integer idActividad) {

        PaqueteActividadId id = new PaqueteActividadId();
        id.setIdPaquete(idPaquete);
        id.setIdActividad(idActividad);

        PaqueteActividad paqueteActividad = new PaqueteActividad();
        paqueteActividad.setId(id);
        
        this.paqueteActividadRepository.save(paqueteActividad);

        return ResponseEntity.ok("Paquete de actividad agregado exitosamente");
    }

    // Método para obtener todos los paquetes de actividad
    @GetMapping("/obtenerPaquetesActividades")
    public ResponseEntity<Iterable<PaqueteActividad>> obtenerPaquetesActividades() {
        Iterable<PaqueteActividad> paquetesActividades = this.paqueteActividadRepository.findAll();
        if (!paquetesActividades.iterator().hasNext()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paquetesActividades);
    }

    // Método para obtener un paquete de actividad por su ID compuesto
    @GetMapping("/obtenerPaqueteActividadPorId")
    public ResponseEntity<Optional<PaqueteActividad>> obtenerPaqueteActividad(@RequestParam("idPaquete") Integer idPaquete,
                                                                    @RequestParam("idActividad") Integer idActividad) {
        PaqueteActividadId id = new PaqueteActividadId();
        id.setIdPaquete(idPaquete);
        id.setIdActividad(idActividad);

        Optional<PaqueteActividad> paqueteActividad = this.paqueteActividadRepository.findById(id);
        if (paqueteActividad == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paqueteActividad);
    }

    // Método para eliminar un paquete de actividad por su ID compuesto
    @PostMapping("/eliminarPaqueteActividad")
    public ResponseEntity<String> eliminarPaqueteActividad(@RequestParam("idPaquete") Integer idPaquete,
                                                           @RequestParam("idActividad") Integer idActividad) {
        PaqueteActividadId id = new PaqueteActividadId();
        id.setIdPaquete(idPaquete);
        id.setIdActividad(idActividad);

        try {
            this.paqueteActividadRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Paquete de actividad eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No se encontró el paquete de actividad");
        }
    }
}
