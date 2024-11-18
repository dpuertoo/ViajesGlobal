package co.edu.unbosque.viajesGlobal.database_service.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class PaqueteVueloId implements Serializable {
	private Integer idPaquete;
	private Integer idVuelo;
	
	public PaqueteVueloId() {
		// TODO Auto-generated constructor stub
	}

	public PaqueteVueloId(Integer idPaquete, Integer idVuelo) {
		super();
		this.idPaquete = idPaquete;
		this.idVuelo = idVuelo;
	}

	public Integer getIdPaquete() {
		return idPaquete;
	}

	public void setIdPaquete(Integer idPaquete) {
		this.idPaquete = idPaquete;
	}

	public Integer getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(Integer idVuelo) {
		this.idVuelo = idVuelo;
	}

}
