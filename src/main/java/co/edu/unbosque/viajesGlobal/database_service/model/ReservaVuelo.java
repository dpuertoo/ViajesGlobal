package co.edu.unbosque.viajesGlobal.database_service.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ReservaVuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva_vuelo")
    private Integer idReservaVuelo;

    @Column(name = "id_vuelo")
    private Integer idVuelo;

    @Column(name = "tipo_vuelo")
    private String tipoVuelo;

    @Column(name = "clase")
    private String clase;

    @Column(name = "cantidad_personas")
    private Integer cantidadPersonas;

    @Column(name = "id_usuario")
    private String idUsuario;

    @Column(name = "precio_total")
    private BigDecimal precioTotal;

    // Getters y Setters

    public Integer getIdReservaVuelo() {
        return idReservaVuelo;
    }

    public void setIdReservaVuelo(Integer idReservaVuelo) {
        this.idReservaVuelo = idReservaVuelo;
    }

    public Integer getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(Integer idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(String tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
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
