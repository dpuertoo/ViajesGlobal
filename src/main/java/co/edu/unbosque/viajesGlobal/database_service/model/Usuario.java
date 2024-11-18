package co.edu.unbosque.viajesGlobal.database_service.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Usuario {

	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_usuario", length = 10)
	private String idUsuario;

	@Column(nullable = false, length = 50)
	private String nombre;

	@Column(nullable = false, length = 50)
	private String apellido;

	@Column(nullable = false, unique = true, length = 100)
	private String correo;

	@Column(nullable = false, length = 255)
	private String contraseña;

	@Column(length = 20)
	private String telefono;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Rol rol;

	@Enumerated(EnumType.STRING)
	private MedioNotificacion medioNotificacion;

	@Column(name = "fecha_creacion", nullable = false, updatable = false)
	private LocalDateTime fechaCreacion;

	public Usuario(String idUsuario, String nombre, String apellido, String correo, String contraseña, String telefono,
			Rol rol, MedioNotificacion medioNotificacion, LocalDateTime fechaCreacion) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contraseña = contraseña;
		this.telefono = telefono;
		this.rol = rol;
		this.medioNotificacion = medioNotificacion;
		this.fechaCreacion = fechaCreacion;
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public enum Rol {
		Cliente, Administrador
	}

	public enum MedioNotificacion {
		SMS, Correo, Push
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public MedioNotificacion getMedioNotificacion() {
		return medioNotificacion;
	}

	public void setMedioNotificacion(MedioNotificacion medioNotificacion) {
		this.medioNotificacion = medioNotificacion;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
