package co.edu.unbosque.viajesGlobal.database_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.viajesGlobal.database_service.model.Hotel;

public interface HotelRepository extends CrudRepository<Hotel, Integer> {
    List<Hotel> findAll();
    Optional<Hotel> findById(Integer idHotel);
    void deleteById(Integer idHotel);
}
