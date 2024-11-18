package co.edu.unbosque.viajesGlobal.database_service.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.viajesGlobal.database_service.model.Administrador;
import co.edu.unbosque.viajesGlobal.database_service.repository.AdministradorRepository;

@RestController
public class AdministradorController {
    
    @Autowired
    private AdministradorRepository ar;

    @PostMapping("/agregarAdministrador")
    public ResponseEntity<String> agregarAdministrador(@RequestParam("cargo") String cargo,
            @RequestParam("fechaAsignacion") LocalDate fechaAsignacion,
            @RequestParam("idUsuario") String idUsuario) {

        // Buscar el usuario asociado
        // Aquí puedes añadir una consulta al repositorio de Usuario si es necesario
        // para obtener el objeto Usuario relacionado por su id
        // Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow();

        // Crear el objeto Administrador
        Administrador administrador = new Administrador();
        administrador.setCargo(cargo);
        administrador.setFechaAsignacion(fechaAsignacion);
        // administrador.setUsuario(usuario); // Asignar el usuario al administrador

        this.ar.save(administrador);
        return ResponseEntity.ok("Administrador agregado exitosamente");
    }

    @GetMapping("/obtenerAdministradores")
    public ResponseEntity<List<Administrador>> obtenerAdministradores() {
        List<Administrador> administradores = this.ar.findAll();
        if (administradores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(administradores);
    }

    @GetMapping("/obtenerAdministradorPorId")
    public ResponseEntity<Administrador> obtenerAdministrador(@RequestParam("idAdmin") Integer idAdmin) {
        Optional<Administrador> administrador = this.ar.findById(idAdmin);
        if (!administrador.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(administrador.get());
    }

    @PostMapping("/eliminarAdministrador")
    public ResponseEntity<String> eliminarAdministrador(@RequestParam("idAdmin") Integer idAdmin) {
        try {
            this.ar.deleteById(idAdmin);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No se encontró el administrador en la base de datos");
        }
    }

    @PostMapping("/actualizarAdministrador")
    public ResponseEntity<String> actualizarAdministrador(@RequestParam("idAdmin") Integer idAdmin,
            @RequestParam("cargo") String cargo, @RequestParam("fechaAsignacion") LocalDate fechaAsignacion,
            @RequestParam("idUsuario") String idUsuario) {

        Optional<Administrador> administrador = this.ar.findById(idAdmin);
        if (!administrador.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("El administrador no fue encontrado en la base de datos");
        }

        Administrador administradorAux = administrador.get();
        administradorAux.setCargo(cargo);
        administradorAux.setFechaAsignacion(fechaAsignacion);
        // Aquí debes añadir la lógica para actualizar el usuario si es necesario
        // administradorAux.setUsuario(nuevoUsuario);

        this.ar.save(administradorAux);
        return ResponseEntity.ok("Administrador actualizado exitosamente");
    }
}
