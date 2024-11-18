package co.edu.unbosque.viajesGlobal.database_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.viajesGlobal.database_service.model.Auto;

public interface AutoRepository extends JpaRepository<Auto, String> {
	public List<Auto> findAll();
	public Optional<Auto> findById(String idUsuario);
	public void deleteById(String idUsuario);
}