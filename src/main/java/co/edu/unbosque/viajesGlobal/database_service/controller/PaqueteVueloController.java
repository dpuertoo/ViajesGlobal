package co.edu.unbosque.viajesGlobal.database_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.viajesGlobal.database_service.model.PaqueteTuristico;
import co.edu.unbosque.viajesGlobal.database_service.model.PaqueteVuelo;
import co.edu.unbosque.viajesGlobal.database_service.model.PaqueteVueloId;
import co.edu.unbosque.viajesGlobal.database_service.model.Vuelo;
import co.edu.unbosque.viajesGlobal.database_service.repository.PaqueteTuristicoRepository;
import co.edu.unbosque.viajesGlobal.database_service.repository.PaqueteVueloRepository;
import co.edu.unbosque.viajesGlobal.database_service.repository.VueloRepository;

@RestController
public class PaqueteVueloController {

    @Autowired
    private PaqueteVueloRepository pvr;

    @Autowired
    private PaqueteTuristicoRepository ptr;

    @Autowired
    private VueloRepository vr;

    @PostMapping("/agregarPaqueteVuelo")
    public ResponseEntity<String> agregarPaqueteVuelo(@RequestParam("idPaquete") Integer idPaquete,
                                                      @RequestParam("idVuelo") Integer idVuelo) {
        // Obtener las entidades relacionadas
        PaqueteTuristico paquete = ptr.findById(idPaquete).orElse(null);
        Vuelo vuelo = vr.findById(idVuelo).orElse(null);

        if (paquete == null || vuelo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paquete o Vuelo no encontrado");
        }

        // Crear el objeto PaqueteVuelo
        PaqueteVueloId id = new PaqueteVueloId(idPaquete, idVuelo);
        PaqueteVuelo paqueteVuelo = new PaqueteVuelo();
        paqueteVuelo.setId(id);
        paqueteVuelo.setPaquete(paquete);
        paqueteVuelo.setVuelo(vuelo);

        // Guardar el PaqueteVuelo
        pvr.save(paqueteVuelo);
        return ResponseEntity.ok("PaqueteVuelo agregado exitosamente");
    }

    @GetMapping("/obtenerPaquetesVuelos")
    public ResponseEntity<List<PaqueteVuelo>> obtenerPaquetesVuelos() {
        List<PaqueteVuelo> paquetesVuelos = this.pvr.findAll();
        if (paquetesVuelos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paquetesVuelos);
    }

    @GetMapping("/obtenerPaqueteVueloPorId")
    public ResponseEntity<PaqueteVuelo> obtenerPaqueteVueloPorId(@RequestParam("idPaquete") Integer idPaquete,
                                                                  @RequestParam("idVuelo") Integer idVuelo) {
        PaqueteVueloId id = new PaqueteVueloId(idPaquete, idVuelo);
        Optional<PaqueteVuelo> paqueteVuelo = this.pvr.findById(id);
        if (!paqueteVuelo.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paqueteVuelo.get());
    }

    @PostMapping("/eliminarPaqueteVuelo")
    public ResponseEntity<String> eliminarPaqueteVuelo(@RequestParam("idPaquete") Integer idPaquete,
                                                       @RequestParam("idVuelo") Integer idVuelo) {
        PaqueteVueloId id = new PaqueteVueloId(idPaquete, idVuelo);
        try {
            this.pvr.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No se encontró el PaqueteVuelo en la base de datos");
        }
    }

    @PostMapping("/actualizarPaqueteVuelo")
    public ResponseEntity<String> actualizarPaqueteVuelo(@RequestParam("idPaquete") Integer idPaquete,
                                                         @RequestParam("idVuelo") Integer idVuelo) {
        PaqueteVueloId id = new PaqueteVueloId(idPaquete, idVuelo);
        Optional<PaqueteVuelo> paqueteVuelo = this.pvr.findById(id);

        if (!paqueteVuelo.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("PaqueteVuelo no encontrado");
        }

        // Obtener las entidades relacionadas
        PaqueteTuristico paquete = ptr.findById(idPaquete).orElse(null);
        Vuelo vuelo = vr.findById(idVuelo).orElse(null);

        if (paquete == null || vuelo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paquete o Vuelo no encontrado");
        }

        // Actualizar los datos del PaqueteVuelo
        PaqueteVuelo paqueteVueloActualizado = paqueteVuelo.get();
        paqueteVueloActualizado.setPaquete(paquete);
        paqueteVueloActualizado.setVuelo(vuelo);

        // Guardar el PaqueteVuelo actualizado
        pvr.save(paqueteVueloActualizado);
        return ResponseEntity.ok("PaqueteVuelo actualizado exitosamente");
    }
}
