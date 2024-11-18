package co.edu.unbosque.viajesGlobal.database_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.viajesGlobal.database_service.model.ReservaTraslado;

public interface ReservaTrasladoRepository extends JpaRepository<ReservaTraslado, Integer> {
    List<ReservaTraslado> findAll();
    Optional<ReservaTraslado> findById(Integer id);
    void deleteById(Integer id);
}