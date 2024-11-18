package co.edu.unbosque.viajesGlobal.database_service.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vuelos")
public class Vuelo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_vuelo", length = 20)
	private Integer idVuelo;

	@Column(nullable = false, length = 20)
	private String numeroVuelo;

	@Column(nullable = false, length = 50)
	private String aerolinea;

	@Column(nullable = false)
	private LocalDateTime fechaHoraInicio;

	@Column(nullable = false)
	private LocalDateTime fechaHoraFin;

	@Column(precision = 5, scale = 2)
	private BigDecimal duracion;

	@Column(nullable = false)
	private Integer maletasPermitidas;

	@Column(name = "precio_vuelo", precision = 10, scale = 2)
	private BigDecimal precioVuelo;

	private String imagen;

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public BigDecimal getPrecioVuelo() {
		return precioVuelo;
	}

	public void setPrecioVuelo(BigDecimal precioVuelo) {
		this.precioVuelo = precioVuelo;
	}

	public Integer getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(Integer idVuelo) {
		this.idVuelo = idVuelo;
	}

	public String getNumeroVuelo() {
		return numeroVuelo;
	}

	public void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}

	public String getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}

	public LocalDateTime getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public LocalDateTime getFechaHoraFin() {
		return fechaHoraFin;
	}

	public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}

	public BigDecimal getDuracion() {
		return duracion;
	}

	public void setDuracion(BigDecimal duracion) {
		this.duracion = duracion;
	}

	public Integer getMaletasPermitidas() {
		return maletasPermitidas;
	}

	public void setMaletasPermitidas(Integer maletasPermitidas) {
		this.maletasPermitidas = maletasPermitidas;
	}

}
