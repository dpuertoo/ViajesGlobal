package co.edu.unbosque.viajesGlobal.database_service.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.viajesGlobal.database_service.model.Actividad;
import co.edu.unbosque.viajesGlobal.database_service.repository.ActividadRepository;

@RestController
public class ActividadController {

	@Autowired
	private ActividadRepository ar;

	@PostMapping("/agregarActividad")
	public ResponseEntity<String> agregarActividad(@RequestParam("tipoActividad") String tipoActividad,
			@RequestParam("precioActividad") BigDecimal precioActividad, @RequestParam("duracion") Integer duracion,
			@RequestParam("descripcion") String descripcion, @RequestParam("fechaInicio") Date fechaInicio,
			@RequestParam("fechaFin") Date fechaFin, @RequestParam("ciudad") String ciudad,
			@RequestParam("imagen") String imagen, @RequestParam("nombre") String nombre) {

		Actividad actividad = new Actividad();
		actividad.setTipoActividad(tipoActividad);
		actividad.setPrecioActividad(precioActividad);
		actividad.setDuracion(duracion);
		actividad.setDescripcion(descripcion);
		actividad.setFechaInicio(fechaInicio);
		actividad.setFechaFin(fechaFin);
		actividad.setCiudad(ciudad);
		actividad.setImagen(imagen);
		actividad.setNombre(nombre);

		ar.save(actividad);
		return ResponseEntity.ok("Actividad agregada exitosamente");
	}

	@GetMapping("/obtenerActividades")
	public ResponseEntity<List<Actividad>> obtenerActividades() {
		List<Actividad> actividades = ar.findAll();
		if (actividades.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(actividades);
	}

	@GetMapping("/obtenerActividadPorId")
	public ResponseEntity<Actividad> obtenerActividadPorId(@RequestParam("idActividad") Integer id) {
		Optional<Actividad> actividad = ar.findById(id);
		if (!actividad.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(actividad.get());
	}

	@PostMapping("/eliminarActividad")
	public ResponseEntity<String> eliminarActividad(@RequestParam("idActividad") Integer id) {
		try {
			ar.deleteById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Actividad eliminada correctamente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No se encontró la actividad en la base de datos");
		}
	}

	@PostMapping("/actualizarActividad")
	public ResponseEntity<String> actualizarActividad(@RequestParam("idActividad") Integer id,
			@RequestParam("tipoActividad") String tipoActividad,
			@RequestParam("precioActividad") BigDecimal precioActividad, @RequestParam("duracion") Integer duracion,
			@RequestParam("descripcion") String descripcion, @RequestParam("fechaInicio") Date fechaInicio,
			@RequestParam("fechaFin") Date fechaFin, @RequestParam("ciudad") String ciudad,
			@RequestParam("imagen") String imagen, @RequestParam("nombre") String nombre) {

		Optional<Actividad> actividadOpt = ar.findById(id);
		if (!actividadOpt.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT)
					.body("La actividad no fue encontrada en la base de datos");
		}

		Actividad actividad = actividadOpt.get();
		actividad.setTipoActividad(tipoActividad);
		actividad.setPrecioActividad(precioActividad);
		actividad.setDuracion(duracion);
		actividad.setDescripcion(descripcion);
		actividad.setFechaInicio(fechaInicio);
		actividad.setFechaFin(fechaFin);
		actividad.setCiudad(ciudad);
		actividad.setImagen(imagen);
		actividad.setNombre(nombre);

		ar.save(actividad);
		return ResponseEntity.ok("Actividad actualizada exitosamente");
	}
}
