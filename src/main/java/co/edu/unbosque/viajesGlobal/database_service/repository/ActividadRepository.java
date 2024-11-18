package co.edu.unbosque.viajesGlobal.database_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.viajesGlobal.database_service.model.Actividad;

public interface ActividadRepository extends CrudRepository<Actividad, Integer> {
    public List<Actividad> findAll();
    public Optional<Actividad> findById(Integer idActividad);
    public void deleteById(Integer idActividad);
}
