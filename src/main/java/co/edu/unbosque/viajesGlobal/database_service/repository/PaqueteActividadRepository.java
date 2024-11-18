package co.edu.unbosque.viajesGlobal.database_service.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.viajesGlobal.database_service.model.PaqueteActividad;
import co.edu.unbosque.viajesGlobal.database_service.model.PaqueteActividadId;

public interface PaqueteActividadRepository extends CrudRepository<PaqueteActividad, PaqueteActividadId> {
	// Método para obtener todos los paquetes de actividades
	public Iterable<PaqueteActividad> findAll();

	// Método para obtener un paquete de actividad por su ID compuesto
	public Optional<PaqueteActividad> findById(PaqueteActividadId id);

	// Métodos adicionales si se necesitan para búsquedas específicas
}
