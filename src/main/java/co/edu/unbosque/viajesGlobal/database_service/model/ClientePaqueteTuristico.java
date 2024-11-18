package co.edu.unbosque.viajesGlobal.database_service.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clientes_PaquetesTuristicos")
public class ClientePaqueteTuristico {
	@EmbeddedId
	private ClientePaqueteTuristicoId id;

	@ManyToOne
	@MapsId("idCliente")
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@ManyToOne
	@MapsId("idPaquete")
	@JoinColumn(name = "id_paquete")
	private PaqueteTuristico paquete;

	@Column(nullable = false)
	private LocalDate fechaContratacion;

	public ClientePaqueteTuristicoId getId() {
		return id;
	}

	public void setId(ClientePaqueteTuristicoId id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public PaqueteTuristico getPaquete() {
		return paquete;
	}

	public void setPaquete(PaqueteTuristico paquete) {
		this.paquete = paquete;
	}

	public LocalDate getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(LocalDate fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
}
