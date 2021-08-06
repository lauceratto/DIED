package tp.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Trayecto")
public class Trayecto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "estacionOrigen")
	private String estacionOrigen;
	
	@Column(name = "estacionDestino")
	private String estacionDestino;
	
	@Column(name = "transporte")
	private String transporte;
	
	public Trayecto() {
		
	}

	public Trayecto(String nombreEstacionOrigen,String nombreEstacionDestino, String nombreTransporte) {
		this.estacionOrigen = nombreEstacionOrigen;
		this.transporte = nombreTransporte;
		this.estacionDestino = nombreEstacionDestino;
	}

	public String getEstacionOrigen() {
		return estacionOrigen;
	}

	public void setEstacionOrigen(String estacionOrigen) {
		this.estacionOrigen = estacionOrigen;
	}

	public String getEstacionDestino() {
		return estacionDestino;
	}

	public void setEstacionDestino(String estacionDestino) {
		this.estacionDestino = estacionDestino;
	}

	public String getTransporte() {
		return transporte;
	}

	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
