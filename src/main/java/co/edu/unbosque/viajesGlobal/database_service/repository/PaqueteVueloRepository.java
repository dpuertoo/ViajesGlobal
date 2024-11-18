package co.edu.unbosque.viajesGlobal.database_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.viajesGlobal.database_service.model.PaqueteVuelo;
import co.edu.unbosque.viajesGlobal.database_service.model.PaqueteVueloId;

public interface PaqueteVueloRepository extends CrudRepository<PaqueteVuelo, PaqueteVueloId>{
    List<PaqueteVuelo> findAll();
    Optional<PaqueteVuelo> findById(PaqueteVueloId idPaqueteVuelo);
    void deleteById(PaqueteVueloId idPaqueteVuelo);
}
