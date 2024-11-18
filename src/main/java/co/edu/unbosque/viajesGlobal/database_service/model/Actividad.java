package co.edu.unbosque.viajesGlobal.database_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Actividades")
public class Actividad {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_actividad", length = 20)
	private Integer idActividad;

	@Column(nullable = false, length = 50)
	private String tipoActividad;

	@Column(name = "precio_actividad", precision = 10, scale = 2)
	private BigDecimal precioActividad;

	private Integer duracion;

	private String Ciudad;

	private String Imagen;

	private String nombre;

	@Lob
	private String descripcion;

	@Column(name = "fecha_inicio", nullable = false)
	private Date fechaInicio;

	@Column(name = "fecha_fin", nullable = false)
	private Date fechaFin;

	// Getters y Setters

	public Integer getIdActividad() {
		return idActividad;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public String getImagen() {
		return Imagen;
	}

	public void setImagen(String imagen) {
		Imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

	public String getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	public BigDecimal getPrecioActividad() {
		return precioActividad;
	}

	public void setPrecioActividad(BigDecimal precioActividad) {
		this.precioActividad = precioActividad;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
}
