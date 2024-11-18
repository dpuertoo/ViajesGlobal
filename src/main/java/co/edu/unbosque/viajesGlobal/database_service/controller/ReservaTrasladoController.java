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

import co.edu.unbosque.viajesGlobal.database_service.model.ReservaTraslado;
import co.edu.unbosque.viajesGlobal.database_service.repository.ReservaTrasladoRepository;

@RestController
public class ReservaTrasladoController {

	@Autowired
	private ReservaTrasladoRepository rtr;

	@PostMapping("/agregarReservaTraslado")
	public ResponseEntity<String> agregarReservaTraslado(@RequestParam("idTraslado") String idTraslado,
			@RequestParam("fechaSalida") LocalDate fechaSalida, @RequestParam("horaSalida") LocalTime horaSalida,
			@RequestParam("pasajeros") Integer pasajeros, @RequestParam("precioTotal") BigDecimal precioTotal,
			@RequestParam("idUsuarios") String idUsuarios) {

		ReservaTraslado reserva = new ReservaTraslado();
		reserva.setIdTraslado(idTraslado);
		reserva.setFechaSalida(fechaSalida);
		reserva.setHoraSalida(horaSalida);
		reserva.setPasajeros(pasajeros);
		reserva.setPrecioTotal(precioTotal);
		reserva.setIdUsuarios(idUsuarios);

		rtr.save(reserva);
		return ResponseEntity.ok("Reserva de traslado agregada exitosamente");
	}

	@GetMapping("/obtenerReservasTraslado")
	public ResponseEntity<List<ReservaTraslado>> obtenerReservasTraslado() {
		List<ReservaTraslado> reservas = rtr.findAll();
		if (reservas.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(reservas);
	}

	@GetMapping("/obtenerReservaTrasladoPorId")
	public ResponseEntity<ReservaTraslado> obtenerReservaTrasladoPorId(@RequestParam("idReservaTraslado") Integer id) {
		Optional<ReservaTraslado> reserva = rtr.findById(id);
		if (!reserva.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(reserva.get());
	}

	@PostMapping("/eliminarReservaTraslado")
	public ResponseEntity<String> eliminarReservaTraslado(@RequestParam("idReservaTraslado") Integer id) {
		try {
			rtr.deleteById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Reserva de traslado eliminada correctamente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Reserva de traslado no encontrada");
		}
	}
}
