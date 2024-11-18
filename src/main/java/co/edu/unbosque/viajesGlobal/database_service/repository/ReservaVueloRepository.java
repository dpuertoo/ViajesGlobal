package co.edu.unbosque.viajesGlobal.database_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.viajesGlobal.database_service.model.ReservaVuelo;


public interface ReservaVueloRepository extends JpaRepository<ReservaVuelo, Integer> {
	public List<ReservaVuelo> findAll();
	public Optional<ReservaVuelo> findById(Integer id);
	public void deleteById(Integer id);
}
