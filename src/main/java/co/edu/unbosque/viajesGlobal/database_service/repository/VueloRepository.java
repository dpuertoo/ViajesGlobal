package co.edu.unbosque.viajesGlobal.database_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.viajesGlobal.database_service.model.Vuelo;

public interface VueloRepository extends CrudRepository<Vuelo, Integer> {
    public List<Vuelo> findAll();
    public Optional<Vuelo> findById(Integer idVuelo);
    public void deleteById(Integer idVuelo);
}
