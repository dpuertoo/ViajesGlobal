package co.edu.unbosque.viajesGlobal.database_service.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class PaqueteActividadId implements Serializable {
	private Integer idPaquete;
	private Integer idActividad;

	public Integer getIdPaquete() {
		return idPaquete;
	}

	public void setIdPaquete(Integer idPaquete) {
		this.idPaquete = idPaquete;
	}

	public Integer getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

}
