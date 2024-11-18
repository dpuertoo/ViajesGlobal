package co.edu.unbosque.viajesGlobal.database_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.viajesGlobal.database_service.model.PaqueteTuristico;

public interface PaqueteTuristicoRepository extends CrudRepository<PaqueteTuristico, Integer> {
    public List<PaqueteTuristico> findAll();
    public Optional<PaqueteTuristico> findById(Integer idPaquete);
    public void deleteById(Integer idPaquete);
}
