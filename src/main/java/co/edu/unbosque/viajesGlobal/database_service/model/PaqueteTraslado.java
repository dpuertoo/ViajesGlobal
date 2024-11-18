package co.edu.unbosque.viajesGlobal.database_service.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "Paquetes_Traslados")
public class PaqueteTraslado {
	@EmbeddedId
	private PaqueteTrasladoId id;

	@ManyToOne
	@MapsId("idPaquete")
	@JoinColumn(name = "id_paquete")
	private PaqueteTuristico paquete;

	@ManyToOne
	@MapsId("idTraslado")
	@JoinColumn(name = "id_traslado")
	private Traslado traslado;

	public PaqueteTrasladoId getId() {
		return id;
	}

	public void setId(PaqueteTrasladoId id) {
		this.id = id;
	}

	public PaqueteTuristico getPaquete() {
		return paquete;
	}

	public void setPaquete(PaqueteTuristico paquete) {
		this.paquete = paquete;
	}

	public Traslado getTraslado() {
		return traslado;
	}

	public void setTraslado(Traslado traslado) {
		this.traslado = traslado;
	}

}
