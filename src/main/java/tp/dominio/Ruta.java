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
	private String origen;

	@Column(name = "destino")
	private String destino;
	
	@Column(name = "distancia")
	private Double distancia;
	
	@Column(name = "duracion")
	private Double duracion;
	
	@Column(name = "cantMaxPasajeros")
	private Integer cantMaxPasajeros;
	
	@Column(name = "estado")
	private Boolean estado;
	
	@Column(name = "costo")
	private Double costo;
	
	@Column(name = "transporte")
	private String nombreTransporte;

	public Ruta(String transporte,String origen, String destino, Double distancia, Double duracion, Integer cantMaxPasajeros,
			Boolean estado, Double costo) {
		this.origen = origen;
		this.destino = destino;
		this.distancia = distancia;
		this.duracion = duracion;
		this.cantMaxPasajeros = cantMaxPasajeros;
		this.estado = estado;
		this.costo = costo;
		this.nombreTransporte = transporte;
	}
	public Ruta() {
		
	}
	public Ruta(EstacionMultimodal ini,EstacionMultimodal fin){
		this();
		this.origen = ini.getNombre();
		this.destino = fin.getNombre();
	}

	public Ruta(EstacionMultimodal ini,EstacionMultimodal fin,Number valor){
		this(ini,fin);
		
	}
	
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreTransporte() {
		return nombreTransporte;
	}

	public void setNombreTransporte(String nombreTransporte) {
		this.nombreTransporte = nombreTransporte;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public Double getDuracion() {
		return duracion;
	}

	public void setDuracion(Double duracion) {
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

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	
	
	
}
