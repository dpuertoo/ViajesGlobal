package co.edu.unbosque.viajesGlobal.database_service.controller;

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

import co.edu.unbosque.viajesGlobal.database_service.model.ReservaActividad;
import co.edu.unbosque.viajesGlobal.database_service.repository.ReservaActividadRepository;

@RestController
public class ReservaActividadController {

	@Autowired
	private ReservaActividadRepository rar;

	@PostMapping("/agregarReservaActividad")
	public ResponseEntity<String> agregarReservaActividad(@RequestParam("idActividad") Integer idActividad,
			@RequestParam("fechaInicio") Date fechaInicio, @RequestParam("fechaFin") Date fechaFin,
			@RequestParam("participantes") Integer participantes, @RequestParam("idUsuarios") String idUsuarios) {

		ReservaActividad reservaActividad = new ReservaActividad();
		reservaActividad.setIdActividad(idActividad);
		reservaActividad.setFechaInicio(fechaInicio);
		reservaActividad.setFechaFin(fechaFin);
		reservaActividad.setParticipantes(participantes);
		reservaActividad.setIdUsuarios(idUsuarios);

		rar.save(reservaActividad);
		return ResponseEntity.ok("Reserva de actividad agregada exitosamente");
	}

	@GetMapping("/obtenerReservasActividades")
	public ResponseEntity<List<ReservaActividad>> obtenerReservasActividades() {
		List<ReservaActividad> reservas = rar.findAll();
		if (reservas.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(reservas);
	}

	@GetMapping("/obtenerReservaActividadPorId")
	public ResponseEntity<ReservaActividad> obtenerReservaActividadPorId(
			@RequestParam("idReservaActividad") Integer id) {
		Optional<ReservaActividad> reserva = rar.findById(id);
		if (!reserva.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(reserva.get());
	}

	@PostMapping("/eliminarReservaActividad")
	public ResponseEntity<String> eliminarReservaActividad(@RequestParam("idReservaActividad") Integer id) {
		try {
			rar.deleteById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Reserva de actividad eliminada correctamente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva de actividad no encontrada");
		}
	}
}
