package co.edu.unbosque.viajesGlobal.database_service.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.viajesGlobal.database_service.model.Auto;
import co.edu.unbosque.viajesGlobal.database_service.repository.AutoRepository;

@RestController
public class AutoController {

    @Autowired
    private AutoRepository AutoRepository;

    @PostMapping("/agregarAuto")
    public ResponseEntity<String> agregarAuto(@RequestParam("idAuto") String idAuto,
                                              @RequestParam("nombre") String nombre,
                                              @RequestParam("ciudad") String ciudad,
                                              @RequestParam("duracion") Integer duracion,
                                              @RequestParam("precio") BigDecimal precio,
                                              @RequestParam("imagen") String imagen,
                                              @RequestParam("capacidad") Integer capacidad) {

        Auto auto = new Auto();
        auto.setIdAuto(idAuto);
        auto.setNombre(nombre);
        auto.setCiudad(ciudad);
        auto.setDuracion(duracion);
        auto.setPrecio(precio);
        auto.setImagen(imagen);
        auto.setCapacidad(capacidad);

        AutoRepository.save(auto);
        return ResponseEntity.ok("Auto agregado exitosamente");
    }

    @GetMapping("/obtenerAuto")
    public ResponseEntity<List<Auto>> obtenerAuto() {
        List<Auto> Auto = AutoRepository.findAll();
        if (Auto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(Auto);
    }

    @GetMapping("/obtenerAutoPorId")
    public ResponseEntity<Auto> obtenerAutoPorId(@RequestParam("idAuto") String idAuto) {
        Optional<Auto> auto = AutoRepository.findById(idAuto);
        if (!auto.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(auto.get());
    }

    @PostMapping("/eliminarAuto")
    public ResponseEntity<String> eliminarAuto(@RequestParam("idAuto") String idAuto) {
        try {
            AutoRepository.deleteById(idAuto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Auto eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Auto no encontrado");
        }
    }
}
