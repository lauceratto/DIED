package tp.dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Boleto")
public class Boleto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	@Column(name = "nroBoleto")
	private Integer nroBoleto;

	@Column(name = "correo")
	private String correo;
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "fecha")
	private LocalDate fecha;
	
	@Column(name = "camino")
	private String camino;
	
	@Column(name = "costo")
	private Double costo;
	
	@Column(name = "origen")
	private String origen;
	
	@Column(name = "destino")
	private String destino;

	public Boleto() {
		
	}

	public Boleto(Double costo,String correo2, String nombre2, LocalDate fechaVenta, String camino, String origen, String destino) {
		this.correo = correo2;
		this.nombre = nombre2;
		this.fecha = fechaVenta;
		this.camino = camino;
		this.origen = origen;
		this.destino = destino;
		this.costo = costo;
	}

	public Integer getNroBoleto() {
		return nroBoleto;
	}

	public void setNroBoleto(Integer nroBoleto) {
		this.nroBoleto = nroBoleto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public String getCamino() {
		return camino;
	}

	public void setCamino(String camino) {
		this.camino = camino;
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

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}
	
	
}
