package co.edu.unbosque.viajesGlobal.database_service.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ReservaActividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservaActividad;

    @Column(nullable = false)
    private Integer idActividad;

    @Column(nullable = false)
    private Date fechaInicio;

    @Column(nullable = false)
    private Date fechaFin;

    @Column(nullable = false)
    private Integer participantes;

    @Column(nullable = false, length = 10)
    private String idUsuarios;

    // Getters y Setters

    public Integer getIdReservaActividad() {
        return idReservaActividad;
    }

    public void setIdReservaActividad(Integer idReservaActividad) {
        this.idReservaActividad = idReservaActividad;
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Integer participantes) {
        this.participantes = participantes;
    }

    public String getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(String idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
}
