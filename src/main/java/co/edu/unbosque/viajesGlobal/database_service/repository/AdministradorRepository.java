package co.edu.unbosque.viajesGlobal.database_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.viajesGlobal.database_service.model.Administrador;

public interface AdministradorRepository extends CrudRepository<Administrador, Integer> {
    public List<Administrador> findAll();
    public Optional<Administrador> findById(Integer idAdmin);
    public void deleteById(Integer idAdmin);
}
