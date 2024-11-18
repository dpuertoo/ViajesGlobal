package co.edu.unbosque.viajesGlobal.database_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.viajesGlobal.database_service.model.ReservaHotel;

public interface ReservaHotelRepository extends JpaRepository<ReservaHotel, Integer> {
	public List<ReservaHotel> findAll();
	public Optional<ReservaHotel> findById(Integer id);
	public void deleteById(Integer id);
}
