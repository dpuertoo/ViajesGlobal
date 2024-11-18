package co.edu.unbosque.viajesGlobal.database_service.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class PaqueteHotelId implements Serializable {
	private Integer idPaquete;
	private Integer idHotel;

	public Integer getIdPaquete() {
		return idPaquete;
	}

	public void setIdPaquete(Integer idPaquete) {
		this.idPaquete = idPaquete;
	}

	public Integer getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
	}

}
