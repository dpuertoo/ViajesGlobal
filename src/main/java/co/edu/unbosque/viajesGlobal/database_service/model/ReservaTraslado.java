package co.edu.unbosque.viajesGlobal.database_service.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ReservaTraslado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservaTraslado;

    private String idTraslado;
    private LocalDate fechaSalida;
    private LocalTime horaSalida;
    private Integer pasajeros;
    private BigDecimal precioTotal;
    private String idUsuarios;

    // Getters y Setters

    public Integer getIdReservaTraslado() {
        return idReservaTraslado;
    }

    public void setIdReservaTraslado(Integer idReservaTraslado) {
        this.idReservaTraslado = idReservaTraslado;
    }

    public String getIdTraslado() {
        return idTraslado;
    }

    public void setIdTraslado(String idTraslado) {
        this.idTraslado = idTraslado;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Integer getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(Integer pasajeros) {
        this.pasajeros = pasajeros;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(String idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
}