package co.edu.unbosque.viajesGlobal.database_service.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ClientePaqueteTuristicoId implements Serializable {
	@Column(name = "id_cliente", length = 20)
	private Integer idCliente;

	@Column(name = "id_paquete", length = 20)
	private Integer idPaquete;

	// Getters y Setters

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdPaquete() {
		return idPaquete;
	}

	public void setIdPaquete(Integer idPaquete) {
		this.idPaquete = idPaquete;
	}

	// hashCode y equals
}
