package co.edu.unbosque.viajesGlobal.database_service.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Administradores")
public class Administrador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_admin", length = 20)
	private Integer idAdmin;

	@Column(length = 100)
	private String cargo;

	private LocalDate fechaAsignacion;

	@OneToOne
	@JoinColumn(name = "id_admin")
	private Usuario usuario;

	public Integer getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public LocalDate getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(LocalDate fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}