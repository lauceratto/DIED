package tp.dominio;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Ruta")
public class Ruta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "origen")
	private EstacionMultimodal origen;

	@Column(name = "destino")
	private EstacionMultimodal destino;
	
	@Column(name = "distancia")
	private String distancia;
	
	@Column(name = "duracion")
	private String duracion;
	
	@Column(name = "cantMaxPasajeros")
	private Integer cantMaxPasajeros;
	
	@Column(name = "estado")
	private Boolean estado;
	
	@Column(name = "costo")
	private Float costo;

	public Ruta() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstacionMultimodal getOrigen() {
		return origen;
	}

	public void setOrigen(EstacionMultimodal origen) {
		this.origen = origen;
	}

	public EstacionMultimodal getDestino() {
		return destino;
	}

	public void setDestino(EstacionMultimodal destino) {
		this.destino = destino;
	}

	public String getDistancia() {
		return distancia;
	}

	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public Integer getCantMaxPasajeros() {
		return cantMaxPasajeros;
	}

	public void setCantMaxPasajeros(Integer cantMaxPasajeros) {
		this.cantMaxPasajeros = cantMaxPasajeros;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}
	
	
}
