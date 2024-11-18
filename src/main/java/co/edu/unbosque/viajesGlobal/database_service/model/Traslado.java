package co.edu.unbosque.viajesGlobal.database_service.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Traslados")
public class Traslado {
    @Id
    @Column(name = "id_traslado", length = 20)
    private String idTraslado;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTraslado tipoTraslado;

    @Column(precision = 10, scale = 2)
    private BigDecimal distancia;

    @Column(name = "precio_traslado", precision = 10, scale = 2)
    private BigDecimal precioTraslado;

    @Column(length = 100)
    private String empresaProveedora;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    public enum TipoTraslado {
        Terrestre, Aéreo, Marítimo
    }

    public String getIdTraslado() {
        return idTraslado;
    }

    public void setIdTraslado(String idTraslado) {
        this.idTraslado = idTraslado;
    }

    public TipoTraslado getTipoTraslado() {
        return tipoTraslado;
    }

    public void setTipoTraslado(TipoTraslado tipoTraslado) {
        this.tipoTraslado = tipoTraslado;
    }

    public BigDecimal getDistancia() {
        return distancia;
    }

    public void setDistancia(BigDecimal distancia) {
        this.distancia = distancia;
    }

    public BigDecimal getPrecioTraslado() {
        return precioTraslado;
    }

    public void setPrecioTraslado(BigDecimal precioTraslado) {
        this.precioTraslado = precioTraslado;
    }

    public String getEmpresaProveedora() {
        return empresaProveedora;
    }

    public void setEmpresaProveedora(String empresaProveedora) {
        this.empresaProveedora = empresaProveedora;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}
