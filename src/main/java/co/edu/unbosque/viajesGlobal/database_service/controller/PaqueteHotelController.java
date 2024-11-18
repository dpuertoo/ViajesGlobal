package co.edu.unbosque.viajesGlobal.database_service.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unbosque.viajesGlobal.database_service.model.PaqueteHotel;
import co.edu.unbosque.viajesGlobal.database_service.model.PaqueteHotelId;
import co.edu.unbosque.viajesGlobal.database_service.repository.PaqueteHotelRepository;

@RestController
public class PaqueteHotelController {

    @Autowired
    private PaqueteHotelRepository phr;

    @PostMapping("/agregarPaqueteHotel")
    public ResponseEntity<String> agregarPaqueteHotel(@RequestParam("idPaquete") Integer idPaquete,
                                                      @RequestParam("idHotel") Integer idHotel) {
        PaqueteHotelId id = new PaqueteHotelId();
        id.setIdPaquete(idPaquete);
        id.setIdHotel(idHotel);

        PaqueteHotel paqueteHotel = new PaqueteHotel();
        paqueteHotel.setId(id);

        this.phr.save(paqueteHotel);
        return ResponseEntity.ok("Paquete de hotel agregado exitosamente");
    }

    @GetMapping("/obtenerPaquetesHotel")
    public ResponseEntity<Iterable<PaqueteHotel>> obtenerPaquetesHotel() {
        Iterable<PaqueteHotel> paquetesHotel = this.phr.findAll();
        if (!paquetesHotel.iterator().hasNext()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(paquetesHotel);
    }

    @GetMapping("/obtenerPaqueteHotelPorId")
    public ResponseEntity<Optional<PaqueteHotel>> obtenerPaqueteHotelPorId(@RequestParam("idPaquete") Integer idPaquete,
                                                                           @RequestParam("idHotel") Integer idHotel) {
        PaqueteHotelId id = new PaqueteHotelId();
        id.setIdPaquete(idPaquete);
        id.setIdHotel(idHotel);

        Optional<PaqueteHotel> paqueteHotel = this.phr.findById(id);
        if (!paqueteHotel.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(paqueteHotel);
    }

    @PostMapping("/eliminarPaqueteHotel")
    public ResponseEntity<String> eliminarPaqueteHotel(@RequestParam("idPaquete") Integer idPaquete,
                                                       @RequestParam("idHotel") Integer idHotel) {
        PaqueteHotelId id = new PaqueteHotelId();
        id.setIdPaquete(idPaquete);
        id.setIdHotel(idHotel);

        try {
            this.phr.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Paquete de hotel eliminado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No se encontró el paquete de hotel");
        }
    }

    @PostMapping("/actualizarPaqueteHotel")
    public ResponseEntity<String> actualizarPaqueteHotel(@RequestParam("idPaquete") Integer idPaquete,
                                                         @RequestParam("idHotel") Integer idHotel) {
        PaqueteHotelId id = new PaqueteHotelId();
        id.setIdPaquete(idPaquete);
        id.setIdHotel(idHotel);

        Optional<PaqueteHotel> paqueteHotelOptional = this.phr.findById(id);
        if (!paqueteHotelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("El paquete de hotel no fue encontrado");
        }

        PaqueteHotel paqueteHotel = paqueteHotelOptional.get();
        // Aquí puedes actualizar los campos del PaqueteHotel si es necesario

        this.phr.save(paqueteHotel);
        return ResponseEntity.ok("Paquete de hotel actualizado exitosamente");
    }
}
