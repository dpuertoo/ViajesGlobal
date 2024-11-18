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

import co.edu.unbosque.viajesGlobal.database_service.model.Cliente;
import co.edu.unbosque.viajesGlobal.database_service.model.Usuario;
import co.edu.unbosque.viajesGlobal.database_service.repository.ClienteRepository;
import co.edu.unbosque.viajesGlobal.database_service.repository.UsuarioRepository;

@RestController
public class ClienteController {
    
    @Autowired
    private ClienteRepository cr;
    
    @Autowired
    private UsuarioRepository ur;

    @PostMapping("/agregarCliente")
    public ResponseEntity<String> agregarCliente(@RequestParam("idCliente") Integer idCliente, 
                                                 @RequestParam("direccion") String direccion, 
                                                 @RequestParam("fechaNacimiento") LocalDate fechaNacimiento, 
                                                 @RequestParam("idUsuario") String idUsuario) {

        // Obtener el usuario para asociarlo al cliente
        Optional<Usuario> usuario = ur.findById(idUsuario);
        if (!usuario.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario no encontrado");
        }

        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);
        cliente.setDireccion(direccion);
        cliente.setFechaNacimiento(fechaNacimiento);
        cliente.setUsuario(usuario.get());
        
        cr.save(cliente);
        return ResponseEntity.ok("Cliente agregado exitosamente");
    }

    @GetMapping("/obtenerClientes")
    public ResponseEntity<List<Cliente>> obtenerClientes() {
        List<Cliente> clientes = cr.findAll();
        if (clientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(clientes);
    }

    @GetMapping("/obtenerClientePorId")
    public ResponseEntity<Cliente> obtenerClientePorId(@RequestParam("idCliente") Integer idCliente) {
        Optional<Cliente> cliente = cr.findById(idCliente);
        if (!cliente.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cliente.get());
    }

    @PostMapping("/eliminarCliente")
    public ResponseEntity<String> eliminarCliente(@RequestParam("idCliente") Integer idCliente) {
        try {
            cr.deleteById(idCliente);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Cliente eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cliente no encontrado");
        }
    }

    @PostMapping("/actualizarCliente")
    public ResponseEntity<String> actualizarCliente(@RequestParam("idCliente") Integer idCliente, 
                                                   @RequestParam("direccion") String direccion, 
                                                   @RequestParam("fechaNacimiento") LocalDate fechaNacimiento, 
                                                   @RequestParam("idUsuario") String idUsuario) {

        Optional<Cliente> cliente = cr.findById(idCliente);
        if (!cliente.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cliente no encontrado");
        }

        Optional<Usuario> usuario = ur.findById(idUsuario);
        if (!usuario.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario no encontrado");
        }

        Cliente clienteAux = cliente.get();
        clienteAux.setDireccion(direccion);
        clienteAux.setFechaNacimiento(fechaNacimiento);
        clienteAux.setUsuario(usuario.get());
        
        cr.save(clienteAux);
        return ResponseEntity.ok("Cliente actualizado exitosamente");
    }
}
