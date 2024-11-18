package co.edu.unbosque.viajesGlobal.database_service.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Hoteles")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_hotel", length = 20)
	private Integer idHotel;

	@Column(nullable = false, length = 100)
	private String nombreHotel;

	@Column(nullable = false, length = 255)
	private String direccion;

	@Column(nullable = false, length = 100)
	private String ciudad;

	@Column(nullable = false)
	private Integer estadia;

	@Column(name = "precio_hotel", nullable = false, precision = 10, scale = 2)
	private BigDecimal precioHotel;

	private Integer habitaciones;
	private Integer personas;
	private String imagen;

	public Integer getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Integer habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Integer getPersonas() {
		return personas;
	}

	public void setPersonas(Integer personas) {
		this.personas = personas;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public BigDecimal getPrecioHotel() {
		return precioHotel;
	}

	public void setPrecioHotel(BigDecimal precioHotel) {
		this.precioHotel = precioHotel;
	}

	public Integer getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
	}

	public String getNombreHotel() {
		return nombreHotel;
	}

	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Integer getEstadia() {
		return estadia;
	}

	public void setEstadia(Integer estadia) {
		this.estadia = estadia;
	}

}
