package co.edu.unbosque.viajesGlobal.database_service.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.viajesGlobal.database_service.model.PaqueteHotel;
import co.edu.unbosque.viajesGlobal.database_service.model.PaqueteHotelId;

public interface PaqueteHotelRepository extends CrudRepository<PaqueteHotel, PaqueteHotelId> {
	// Método para obtener todos los paquetes de hotel
	public Iterable<PaqueteHotel> findAll();

	// Método para obtener un paquete de hotel por su ID
	public Optional<PaqueteHotel> findById(PaqueteHotelId id);
}
