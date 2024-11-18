package co.edu.unbosque.viajesGlobal.database_service.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "Paquetes_Actividades")
public class PaqueteActividad {
	@EmbeddedId
	private PaqueteActividadId id;

	@ManyToOne
	@MapsId("idPaquete")
	@JoinColumn(name = "id_paquete")
	private PaqueteTuristico paquete;

	@ManyToOne
	@MapsId("idActividad")
	@JoinColumn(name = "id_actividad")
	private Actividad actividad;

	public PaqueteActividadId getId() {
		return id;
	}

	public void setId(PaqueteActividadId id) {
		this.id = id;
	}

	public PaqueteTuristico getPaquete() {
		return paquete;
	}

	public void setPaquete(PaqueteTuristico paquete) {
		this.paquete = paquete;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

}