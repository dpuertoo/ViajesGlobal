package co.edu.unbosque.viajesGlobal.database_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.viajesGlobal.database_service.model.ReservaAuto;

public interface ReservaAutoRepository extends JpaRepository<ReservaAuto, Integer> {
    List<ReservaAuto> findAll();
    Optional<ReservaAuto> findById(Integer idHotel);
    void deleteById(Integer idHotel);
}
