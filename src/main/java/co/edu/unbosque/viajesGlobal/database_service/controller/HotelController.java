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

import co.edu.unbosque.viajesGlobal.database_service.model.Hotel;
import co.edu.unbosque.viajesGlobal.database_service.repository.HotelRepository;

@RestController
public class HotelController {
	@Autowired
	private HotelRepository hr;

	@PostMapping("/agregarHotel")
	public ResponseEntity<String> agregarHotel(@RequestParam("nombreHotel") String nombreHotel,
			@RequestParam("direccion") String direccion, @RequestParam("ciudad") String ciudad,
			@RequestParam("estadia") Integer estadia, @RequestParam("precioHotel") BigDecimal precioHotel,
			@RequestParam("habitaciones") Integer habitaciones, @RequestParam("personas") Integer personas,
			@RequestParam("imagen") String imagen) {
		Hotel hotel = new Hotel();
		hotel.setNombreHotel(nombreHotel);
		hotel.setDireccion(direccion);
		hotel.setCiudad(ciudad);
		hotel.setEstadia(estadia);
		hotel.setPrecioHotel(precioHotel);
		hotel.setHabitaciones(habitaciones);
		hotel.setPersonas(personas);
		hotel.setImagen(imagen);

		hr.save(hotel);
		return ResponseEntity.ok("Hotel agregado exitosamente");
	}

	@GetMapping("/obtenerHoteles")
	public ResponseEntity<List<Hotel>> obtenerHoteles() {
		List<Hotel> hoteles = hr.findAll();
		if (hoteles.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(hoteles);
	}

	@GetMapping("/obtenerHotelPorId")
	public ResponseEntity<Hotel> obtenerHotelPorId(@RequestParam("idHotel") Integer idHotel) {
		Optional<Hotel> hotel = hr.findById(idHotel);
		if (!hotel.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(hotel.get());
	}

	@PostMapping("/eliminarHotel")
	public ResponseEntity<String> eliminarHotel(@RequestParam("idHotel") Integer idHotel) {
		try {
			hr.deleteById(idHotel);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hotel eliminado correctamente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No se encontró el hotel en la base de datos");
		}
	}

	@PostMapping("/actualizarHotel")
	public ResponseEntity<String> actualizarHotel(@RequestParam("idHotel") Integer idHotel,
			@RequestParam("nombreHotel") String nombreHotel, @RequestParam("direccion") String direccion,
			@RequestParam("ciudad") String ciudad, @RequestParam("estadia") Integer estadia,
			@RequestParam("precioHotel") BigDecimal precioHotel, @RequestParam("habitaciones") Integer habitaciones, @RequestParam("personas") Integer personas,
			@RequestParam("imagen") String imagen) {
		Optional<Hotel> hotel = hr.findById(idHotel);
		if (!hotel.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("El hotel no fue encontrado en la base de datos");
		}
		Hotel hotelAux = hotel.get();
		hotelAux.setNombreHotel(nombreHotel);
		hotelAux.setDireccion(direccion);
		hotelAux.setCiudad(ciudad);
		hotelAux.setEstadia(estadia);
		hotelAux.setPrecioHotel(precioHotel);
		hotelAux.setHabitaciones(habitaciones);
		hotelAux.setPersonas(personas);
		hotelAux.setImagen(imagen);

		hr.save(hotelAux);
		return ResponseEntity.ok("Hotel actualizado exitosamente");
	}
}
