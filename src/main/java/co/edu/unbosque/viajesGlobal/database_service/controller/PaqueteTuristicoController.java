package co.edu.unbosque.viajesGlobal.database_service.controller;

import java.math.BigDecimal;
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

import co.edu.unbosque.viajesGlobal.database_service.model.PaqueteTuristico;
import co.edu.unbosque.viajesGlobal.database_service.repository.PaqueteTuristicoRepository;

@RestController
public class PaqueteTuristicoController {
    
    @Autowired
    private PaqueteTuristicoRepository ptr;

    @PostMapping("/agregarPaqueteTuristico")
    public ResponseEntity<String> agregarPaqueteTuristico(@RequestParam("destino") String destino,
                                                           @RequestParam("fechaInicio") String fechaInicio,
                                                           @RequestParam("fechaFin") String fechaFin,
                                                           @RequestParam("precioTotal") BigDecimal precioTotal,
                                                           @RequestParam(value = "incluyeVuelos", required = false) Boolean incluyeVuelos,
                                                           @RequestParam(value = "incluyeAlojamiento", required = false) Boolean incluyeAlojamiento,
                                                           @RequestParam(value = "incluyeActividades", required = false) Boolean incluyeActividades,
                                                           @RequestParam(value = "incluyeTraslados", required = false) Boolean incluyeTraslados) {

        PaqueteTuristico paquete = new PaqueteTuristico();
        paquete.setDestino(destino);
        paquete.setFechaInicio(LocalDate.parse(fechaInicio));
        paquete.setFechaFin(LocalDate.parse(fechaFin));
        paquete.setPrecioTotal(precioTotal);
        paquete.setIncluyeVuelos(incluyeVuelos != null ? incluyeVuelos : false);
        paquete.setIncluyeAlojamiento(incluyeAlojamiento != null ? incluyeAlojamiento : false);
        paquete.setIncluyeActividades(incluyeActividades != null ? incluyeActividades : false);
        paquete.setIncluyeTraslados(incluyeTraslados != null ? incluyeTraslados : false);

        this.ptr.save(paquete);
        return ResponseEntity.ok("Paquete turístico agregado exitosamente");
    }

    @GetMapping("/obtenerPaquetesTuristicos")
    public ResponseEntity<List<PaqueteTuristico>> obtenerPaquetesTuristicos() {
        List<PaqueteTuristico> paquetes = this.ptr.findAll();
        if (paquetes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paquetes);
    }

    @GetMapping("/obtenerPaqueteTuristicoPorId")
    public ResponseEntity<PaqueteTuristico> obtenerPaqueteTuristicoPorId(@RequestParam("idPaquete") Integer id) {
        Optional<PaqueteTuristico> paquete = this.ptr.findById(id);
        if (!paquete.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paquete.get());
    }

    @PostMapping("/eliminarPaqueteTuristico")
    public ResponseEntity<String> eliminarPaqueteTuristico(@RequestParam("idPaquete") Integer id) {
        try {
            this.ptr.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No se encontró el paquete turístico en la base de datos");
        }
    }

    @PostMapping("/actualizarPaqueteTuristico")
    public ResponseEntity<String> actualizarPaqueteTuristico(@RequestParam("idPaquete") Integer id,
                                                             @RequestParam("destino") String destino,
                                                             @RequestParam("fechaInicio") String fechaInicio,
                                                             @RequestParam("fechaFin") String fechaFin,
                                                             @RequestParam("precioTotal") BigDecimal precioTotal,
                                                             @RequestParam(value = "incluyeVuelos", required = false) Boolean incluyeVuelos,
                                                             @RequestParam(value = "incluyeAlojamiento", required = false) Boolean incluyeAlojamiento,
                                                             @RequestParam(value = "incluyeActividades", required = false) Boolean incluyeActividades,
                                                             @RequestParam(value = "incluyeTraslados", required = false) Boolean incluyeTraslados) {

        Optional<PaqueteTuristico> paquete = this.ptr.findById(id);
        if (!paquete.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("El paquete turístico no fue encontrado en la base de datos");
        }
        PaqueteTuristico paqueteAux = paquete.get();
        paqueteAux.setDestino(destino);
        paqueteAux.setFechaInicio(LocalDate.parse(fechaInicio));
        paqueteAux.setFechaFin(LocalDate.parse(fechaFin));
        paqueteAux.setPrecioTotal(precioTotal);
        paqueteAux.setIncluyeVuelos(incluyeVuelos != null ? incluyeVuelos : false);
        paqueteAux.setIncluyeAlojamiento(incluyeAlojamiento != null ? incluyeAlojamiento : false);
        paqueteAux.setIncluyeActividades(incluyeActividades != null ? incluyeActividades : false);
        paqueteAux.setIncluyeTraslados(incluyeTraslados != null ? incluyeTraslados : false);

        this.ptr.save(paqueteAux);
        return ResponseEntity.ok("Paquete turístico actualizado exitosamente");
    }
}
