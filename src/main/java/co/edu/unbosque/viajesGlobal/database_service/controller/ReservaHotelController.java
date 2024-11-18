package co.edu.unbosque.viajesGlobal.database_service.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.viajesGlobal.database_service.model.ReservaHotel;
import co.edu.unbosque.viajesGlobal.database_service.repository.ReservaHotelRepository;

@RestController
public class ReservaHotelController {

    @Autowired
    private ReservaHotelRepository reservaHotelRepository;

    @PostMapping("/agregarReservaHotel")
    public ResponseEntity<String> agregarReservaHotel(@RequestParam("idHotel") Integer idHotel,
                                                      @RequestParam("fechaIngreso") Date fechaIngreso,
                                                      @RequestParam("fechaSalida") Date fechaSalida,
                                                      @RequestParam("idUsuario") String idUsuario,
                                                      @RequestParam("precioTotal") BigDecimal precioTotal) {

        ReservaHotel reservaHotel = new ReservaHotel();
        reservaHotel.setIdHotel(idHotel);
        reservaHotel.setFechaIngreso(fechaIngreso);
        reservaHotel.setFechaSalida(fechaSalida);
        reservaHotel.setIdUsuario(idUsuario);
        reservaHotel.setPrecioTotal(precioTotal);

        reservaHotelRepository.save(reservaHotel);
        return ResponseEntity.ok("Reserva de hotel agregada exitosamente");
    }

    @GetMapping("/obtenerReservasHotel")
    public ResponseEntity<List<ReservaHotel>> obtenerReservasHotel() {
        List<ReservaHotel> reservas = reservaHotelRepository.findAll();
        if (reservas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(reservas);
    }

    @GetMapping("/obtenerReservaHotelPorId")
    public ResponseEntity<ReservaHotel> obtenerReservaHotelPorId(@RequestParam("idReservaHotel") Integer id) {
        Optional<ReservaHotel> reserva = reservaHotelRepository.findById(id);
        if (!reserva.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(reserva.get());
    }

    @PostMapping("/eliminarReservaHotel")
    public ResponseEntity<String> eliminarReservaHotel(@RequestParam("idReservaHotel") Integer id) {
        try {
            reservaHotelRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Reserva de hotel eliminada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva de hotel no encontrada");
        }
    }
}