package co.edu.unbosque.viajesGlobal.database_service.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PaquetesTuristicos")
public class PaqueteTuristico {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_paquete", length = 20)
	private Integer idPaquete;

	@Column(nullable = false, length = 100)
	private String destino;

	@Column(nullable = false)
	private LocalDate fechaInicio;

	@Column(nullable = false)
	private LocalDate fechaFin;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal precioTotal;

	private Boolean incluyeVuelos = false;
	private Boolean incluyeAlojamiento = false;

	// Nuevos campos añadidos
	private Boolean incluyeActividades = false;
	private Boolean incluyeTraslados = false;

	public Integer getIdPaquete() {
		return idPaquete;
	}

	public void setIdPaquete(Integer idPaquete) {
		this.idPaquete = idPaquete;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
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

	public BigDecimal getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(BigDecimal precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Boolean getIncluyeVuelos() {
		return incluyeVuelos;
	}

	public void setIncluyeVuelos(Boolean incluyeVuelos) {
		this.incluyeVuelos = incluyeVuelos;
	}

	public Boolean getIncluyeAlojamiento() {
		return incluyeAlojamiento;
	}

	public void setIncluyeAlojamiento(Boolean incluyeAlojamiento) {
		this.incluyeAlojamiento = incluyeAlojamiento;
	}

	public Boolean getIncluyeActividades() {
		return incluyeActividades;
	}

	public void setIncluyeActividades(Boolean incluyeActividades) {
		this.incluyeActividades = incluyeActividades;
	}

	public Boolean getIncluyeTraslados() {
		return incluyeTraslados;
	}

	public void setIncluyeTraslados(Boolean incluyeTraslados) {
		this.incluyeTraslados = incluyeTraslados;
	}
}
