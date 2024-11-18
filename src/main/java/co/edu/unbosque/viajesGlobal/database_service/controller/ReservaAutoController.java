package co.edu.unbosque.viajesGlobal.database_service.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.viajesGlobal.database_service.model.ReservaAuto;
import co.edu.unbosque.viajesGlobal.database_service.repository.ReservaAutoRepository;

@RestController
public class ReservaAutoController {

    @Autowired
    private ReservaAutoRepository reservaAutoRepository;

    @PostMapping("/agregarReservaAuto")
    public ResponseEntity<String> agregarReservaAuto(@RequestParam("idAuto") String idAuto,
                                                     @RequestParam("fechaRecogida") LocalDate fechaRecogida,
                                                     @RequestParam("horaRecogida") LocalTime horaRecogida,
                                                     @RequestParam("fechaDevolucion") LocalDate fechaDevolucion,
                                                     @RequestParam("horaDevolucion") LocalTime horaDevolucion,
                                                     @RequestParam("precioTotal") BigDecimal precioTotal,
                                                     @RequestParam("idUsuario") String idUsuario) {

        ReservaAuto reservaAuto = new ReservaAuto();
        reservaAuto.setIdAuto(idAuto);
        reservaAuto.setFechaRecogida(fechaRecogida);
        reservaAuto.setHoraRecogida(horaRecogida);
        reservaAuto.setFechaDevolucion(fechaDevolucion);
        reservaAuto.setHoraDevolucion(horaDevolucion);
        reservaAuto.setPrecioTotal(precioTotal);
        reservaAuto.setIdUsuario(idUsuario);

        reservaAutoRepository.save(reservaAuto);
        return ResponseEntity.ok("Reserva de auto agregada exitosamente");
    }

    @GetMapping("/obtenerReservasAuto")
    public ResponseEntity<List<ReservaAuto>> obtenerReservasAuto() {
        List<ReservaAuto> reservas = reservaAutoRepository.findAll();
        if (reservas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(reservas);
    }

    @GetMapping("/obtenerReservaAutoPorId")
    public ResponseEntity<ReservaAuto> obtenerReservaAutoPorId(@RequestParam("idReservaAuto") Integer idReservaAuto) {
        Optional<ReservaAuto> reservaAuto = reservaAutoRepository.findById(idReservaAuto);
        if (!reservaAuto.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(reservaAuto.get());
    }

    @PostMapping("/eliminarReservaAuto")
    public ResponseEntity<String> eliminarReservaAuto(@RequestParam("idReservaAuto") Integer idReservaAuto) {
        try {
            reservaAutoRepository.deleteById(idReservaAuto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Reserva de auto eliminada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Reserva de auto no encontrada");
        }
    }
}

