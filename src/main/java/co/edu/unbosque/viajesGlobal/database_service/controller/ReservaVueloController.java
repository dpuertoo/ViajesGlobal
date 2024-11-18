package co.edu.unbosque.viajesGlobal.database_service.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.viajesGlobal.database_service.model.ReservaVuelo;
import co.edu.unbosque.viajesGlobal.database_service.repository.ReservaVueloRepository;

@RestController
public class ReservaVueloController {

    @Autowired
    private ReservaVueloRepository rvr;

    @PostMapping("/agregarReservaVuelo")
    public ResponseEntity<String> agregarReservaVuelo(@RequestParam("idVuelo") Integer idVuelo,
                                                      @RequestParam("tipoVuelo") String tipoVuelo,
                                                      @RequestParam("clase") String clase,
                                                      @RequestParam("cantidadPersonas") Integer cantidadPersonas,
                                                      @RequestParam("idUsuario") String idUsuario,
                                                      @RequestParam("precioTotal") BigDecimal precioTotal) {
        ReservaVuelo reservaVuelo = new ReservaVuelo();
        reservaVuelo.setIdVuelo(idVuelo);
        reservaVuelo.setTipoVuelo(tipoVuelo);
        reservaVuelo.setClase(clase);
        reservaVuelo.setCantidadPersonas(cantidadPersonas);
        reservaVuelo.setIdUsuario(idUsuario);
        reservaVuelo.setPrecioTotal(precioTotal);

        rvr.save(reservaVuelo);
        return ResponseEntity.ok("Reserva de vuelo agregada exitosamente");
    }

    @GetMapping("/obtenerReservasVuelo")
    public ResponseEntity<List<ReservaVuelo>> obtenerReservasVuelo() {
        List<ReservaVuelo> reservas = rvr.findAll();
        if (reservas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(reservas);
    }

    @GetMapping("/obtenerReservaVueloPorId")
    public ResponseEntity<ReservaVuelo> obtenerReservaVueloPorId(@RequestParam("idReservaVuelo") Integer id) {
        Optional<ReservaVuelo> reserva = rvr.findById(id);
        if (!reserva.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(reserva.get());
    }

    @PostMapping("/eliminarReservaVuelo")
    public ResponseEntity<String> eliminarReservaVuelo(@RequestParam("idReservaVuelo") Integer id) {
        try {
            rvr.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Reserva de vuelo eliminada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Reserva de vuelo no encontrada");
        }
    }
}
