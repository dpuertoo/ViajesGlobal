package co.edu.unbosque.viajesGlobal.database_service.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.viajesGlobal.database_service.model.Usuario;
import co.edu.unbosque.viajesGlobal.database_service.model.Usuario.MedioNotificacion;
import co.edu.unbosque.viajesGlobal.database_service.model.Usuario.Rol;
import co.edu.unbosque.viajesGlobal.database_service.repository.UsuarioRepository;

@RestController
public class UsuarioController {
	@Autowired
	private UsuarioRepository ur;

	@PostMapping("/agregarUsuario")
	public ResponseEntity<String> agregarUsuario(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido, @RequestParam("correo") String correo,
			@RequestParam("contraseña") String contraseña,
			@RequestParam(value = "telefono", required = false) String telefono, @RequestParam("rol") Rol rol,
			@RequestParam(value = "medioNotificacion", required = false) MedioNotificacion medioNotificacion) {

		Usuario usuario = new Usuario(id, nombre, apellido, correo, contraseña, telefono, rol, medioNotificacion,
				LocalDateTime.now());
		this.ur.save(usuario);
		return ResponseEntity.ok("Usuario agregado exitosamente");
	}

	@GetMapping("/obtenerUsuarios")
	public ResponseEntity<List<Usuario>> obtenerUsuarios() {
		List<Usuario> usuarios = this.ur.findAll();
		if (usuarios.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarios);
	}

	@GetMapping("/obtenerUsuarioPorId")
	public ResponseEntity<Usuario> obtenerUsuarios(@RequestParam("idUsuario") String id) {
		Optional<Usuario> usuario = this.ur.findById(id);
		if (!usuario.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuario.get());
	}

	@PostMapping("/eliminarUsuario")
	public ResponseEntity<String> eliminarUsuario(@RequestParam("idUsuario") String id) {
		try {
			this.ur.deleteById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Elimado correctamente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No se encontró el usuario en la base de datos");
		}
	}

	@PostMapping("/actualizarUsuario")
	public ResponseEntity<String> actualizarUsuario(@RequestParam("id") String id,
			@RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido,
			@RequestParam("correo") String correo, @RequestParam("contraseña") String contraseña,
			@RequestParam(value = "telefono", required = false) String telefono, @RequestParam("rol") Rol rol,
			@RequestParam(value = "medioNotificacion", required = false) MedioNotificacion medioNotificacion) {

		Optional<Usuario> usuario;
		usuario = this.ur.findById(id);
		if (!usuario.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("El usuario no fue encontrado en la base de datos");
		}
		Usuario usuarioAux = usuario.get();
		usuarioAux.setNombre(nombre);
		usuarioAux.setApellido(apellido);
		usuarioAux.setContraseña(contraseña);
		usuarioAux.setCorreo(correo);
		usuarioAux.setFechaCreacion(LocalDateTime.now());
		usuarioAux.setTelefono(telefono);
		usuarioAux.setRol(rol);
		usuarioAux.setMedioNotificacion(medioNotificacion);
		
		this.ur.save(usuarioAux);
		return ResponseEntity.ok("Usuario actualizado exitosamente");
	}

}
