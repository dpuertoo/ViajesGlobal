package co.edu.unbosque.viajesGlobal.database_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.viajesGlobal.database_service.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	public List<Usuario> findAll();
	public Optional<Usuario> findById(String idUsuario);
	public void deleteById(String idUsuario);
}
