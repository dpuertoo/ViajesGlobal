package co.edu.unbosque.viajesGlobal.database_service.model;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ReservaHotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservaHotel;

    private Integer idHotel;
    private Date fechaIngreso;
    private Date fechaSalida;
    private String idUsuario;
    private BigDecimal precioTotal;

    // Getters y Setters

    public Integer getIdReservaHotel() {
        return idReservaHotel;
    }

    public void setIdReservaHotel(Integer idReservaHotel) {
        this.idReservaHotel = idReservaHotel;
    }

    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }
}