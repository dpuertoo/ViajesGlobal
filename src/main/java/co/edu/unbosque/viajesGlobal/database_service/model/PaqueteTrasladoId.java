package co.edu.unbosque.viajesGlobal.database_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PaqueteTrasladoId implements Serializable {
	private Integer idPaquete;

	@Column(name = "id_traslado", length = 20)
	private String idTraslado;  // Cambiado a String

	// Getters y Setters

	public Integer getIdPaquete() {
		return idPaquete;
	}

	public void setIdPaquete(Integer idPaquete) {
		this.idPaquete = idPaquete;
	}

	public String getIdTraslado() {
		return idTraslado;
	}

	public void setIdTraslado(String idTraslado) {
		this.idTraslado = idTraslado;
	}

	// Implementación de hashCode y equals
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PaqueteTrasladoId that = (PaqueteTrasladoId) o;
		return Objects.equals(idPaquete, that.idPaquete) &&
				Objects.equals(idTraslado, that.idTraslado);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPaquete, idTraslado);
	}
}
