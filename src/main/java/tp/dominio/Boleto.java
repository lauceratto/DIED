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
	
//	@OneToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "estacionOrigen")
//	private EstacionMultimodal estacionOrigen;
//	
//	@OneToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "estacionDestino")
//	private EstacionMultimodal estacionDestino;
//	
//	@OneToMany(mappedBy = "es", cascade = CascadeType.ALL)
//	private List<EstacionMultimodal> camino = new ArrayList<>();
	
	@Column(name = "costo")
	private Float costo;

	public Boleto() {
		
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

//	public EstacionMultimodal getEstacionOrigen() {
//		return estacionOrigen;
//	}
//
//	public void setEstacionOrigen(EstacionMultimodal estacionOrigen) {
//		this.estacionOrigen = estacionOrigen;
//	}
//
//	public EstacionMultimodal getEstacionDestino() {
//		return estacionDestino;
//	}
//
//	public void setEstacionDestino(EstacionMultimodal estacionDestino) {
//		this.estacionDestino = estacionDestino;
//	}
//
//	public List<EstacionMultimodal> getCamino() {
//		return camino;
//	}
//
//	public void setCamino(List<EstacionMultimodal> camino) {
//		this.camino = camino;
//	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}
	
	
}
