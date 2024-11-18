package co.edu.unbosque.viajesGlobal.database_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.viajesGlobal.database_service.model.ReservaActividad;

public interface ReservaActividadRepository extends JpaRepository<ReservaActividad, Integer> {
	public List<ReservaActividad> findAll();
	public Optional<ReservaActividad> findById(Integer id);
	public void deleteById(Integer id);
}
