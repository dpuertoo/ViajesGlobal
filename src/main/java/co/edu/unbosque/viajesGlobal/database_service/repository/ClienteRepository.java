package co.edu.unbosque.viajesGlobal.database_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.viajesGlobal.database_service.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    public List<Cliente> findAll();
    public Optional<Cliente> findById(Integer idCliente);
    public void deleteById(Integer idCliente);
}
