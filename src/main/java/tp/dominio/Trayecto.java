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
	
	@Column(name = "estacion")
	private String estaciones;
	
	@Column(name = "transporte")
	private String transporte;
	
	public Trayecto() {
		
	}

	public Trayecto(String nombreEstacion, String nombreTransporte) {
		this.estaciones = nombreEstacion;
		this.transporte = nombreTransporte;
	}

	public String getTransporte() {
		return transporte;
	}

	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}

	public String getEstaciones() {
		return estaciones;
	}

	public void setEstaciones(String estaciones) {
		this.estaciones = estaciones;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
