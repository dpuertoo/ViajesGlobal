package co.edu.unbosque.viajesGlobal.database_service.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.viajesGlobal.database_service.model.Vuelo;
import co.edu.unbosque.viajesGlobal.database_service.repository.VueloRepository;

@RestController
public class VueloController {
	@Autowired
	private VueloRepository vr;

	@PostMapping("/agregarVuelo")
	public ResponseEntity<String> agregarVuelo(@RequestParam("numeroVuelo") String numeroVuelo,
			@RequestParam("aerolinea") String aerolinea, @RequestParam("fechaHoraInicio") LocalDateTime fechaHoraInicio,
			@RequestParam("fechaHoraFin") LocalDateTime fechaHoraFin,
			@RequestParam(value = "duracion", required = false) BigDecimal duracion,
			@RequestParam("maletasPermitidas") Integer maletasPermitidas,
			@RequestParam(value = "precioVuelo", required = false) BigDecimal precioVuelo,
			@RequestParam("imagen") String imagen) {

		Vuelo vuelo = new Vuelo();
		vuelo.setNumeroVuelo(numeroVuelo);
		vuelo.setAerolinea(aerolinea);
		vuelo.setFechaHoraInicio(fechaHoraInicio);
		vuelo.setFechaHoraFin(fechaHoraFin);
		vuelo.setDuracion(duracion);
		vuelo.setMaletasPermitidas(maletasPermitidas);
		vuelo.setPrecioVuelo(precioVuelo);
		vuelo.setImagen(imagen);

		this.vr.save(vuelo);
		return ResponseEntity.ok("Vuelo agregado exitosamente");
	}

	@GetMapping("/obtenerVuelos")
	public ResponseEntity<List<Vuelo>> obtenerVuelos() {
		List<Vuelo> vuelos = this.vr.findAll();
		if (vuelos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(vuelos);
	}

	@GetMapping("/obtenerVueloPorId")
	public ResponseEntity<Vuelo> obtenerVueloPorId(@RequestParam("idVuelo") Integer id) {
		Optional<Vuelo> vuelo = this.vr.findById(id);
		if (!vuelo.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(vuelo.get());
	}

	@PostMapping("/eliminarVuelo")
	public ResponseEntity<String> eliminarVuelo(@RequestParam("idVuelo") Integer id) {
		try {
			this.vr.deleteById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Vuelo eliminado correctamente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No se encontró el vuelo en la base de datos");
		}
	}

	@PostMapping("/actualizarVuelo")
	public ResponseEntity<String> actualizarVuelo(@RequestParam("idVuelo") Integer id,
			@RequestParam("numeroVuelo") String numeroVuelo, @RequestParam("aerolinea") String aerolinea,
			@RequestParam("fechaHoraInicio") LocalDateTime fechaHoraInicio,
			@RequestParam("fechaHoraFin") LocalDateTime fechaHoraFin,
			@RequestParam(value = "duracion", required = false) BigDecimal duracion,
			@RequestParam("maletasPermitidas") Integer maletasPermitidas,
			@RequestParam(value = "precioVuelo", required = false) BigDecimal precioVuelo,
			@RequestParam("imagen") String imagen) {

		Optional<Vuelo> vuelo = this.vr.findById(id);
		if (!vuelo.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("El vuelo no fue encontrado en la base de datos");
		}

		Vuelo vueloAux = vuelo.get();
		vueloAux.setNumeroVuelo(numeroVuelo);
		vueloAux.setAerolinea(aerolinea);
		vueloAux.setFechaHoraInicio(fechaHoraInicio);
		vueloAux.setFechaHoraFin(fechaHoraFin);
		vueloAux.setDuracion(duracion);
		vueloAux.setMaletasPermitidas(maletasPermitidas);
		vueloAux.setPrecioVuelo(precioVuelo);
		vueloAux.setImagen(imagen);

		this.vr.save(vueloAux);
		return ResponseEntity.ok("Vuelo actualizado exitosamente");
	}
}
