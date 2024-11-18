package co.edu.unbosque.viajesGlobal.database_service.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Auto {

	@Id
	private String idAuto;

	private String nombre;
	private String ciudad;
	private Integer duracion;
	private BigDecimal precio;
	private String imagen;
	private Integer capacidad;

	// Getters y Setters

	public String getIdAuto() {
		return idAuto;
	}

	public void setIdAuto(String idAutos) {
		this.idAuto = idAutos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
}
