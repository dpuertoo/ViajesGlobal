package co.edu.unbosque.viajesGlobal.database_service.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ReservaAuto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservaAuto;

    private String idAuto;
    private LocalDate fechaRecogida;
    private LocalTime horaRecogida;
    private LocalDate fechaDevolucion;
    private LocalTime horaDevolucion;
    private BigDecimal precioTotal;
    private String idUsuario;

    // Getters y Setters
    public Integer getIdReservaAuto() {
        return idReservaAuto;
    }

    public void setIdReservaAuto(Integer idReservaAuto) {
        this.idReservaAuto = idReservaAuto;
    }

    public String getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(String idAuto) {
        this.idAuto = idAuto;
    }

    public LocalDate getFechaRecogida() {
        return fechaRecogida;
    }

    public void setFechaRecogida(LocalDate fechaRecogida) {
        this.fechaRecogida = fechaRecogida;
    }

    public LocalTime getHoraRecogida() {
        return horaRecogida;
    }

    public void setHoraRecogida(LocalTime horaRecogida) {
        this.horaRecogida = horaRecogida;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public LocalTime getHoraDevolucion() {
        return horaDevolucion;
    }

    public void setHoraDevolucion(LocalTime horaDevolucion) {
        this.horaDevolucion = horaDevolucion;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
