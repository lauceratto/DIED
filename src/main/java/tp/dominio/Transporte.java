package tp.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Transporte")
public class Transporte implements Serializable {
	private static final long serialVersionUID = 1L;
//	public Transporte(String id, String nombre, String color, Boolean estado) {
//		this.id = id;
//		this.nombre = nombre;
//		this.color = color;
//		this.estado = estado;
//	}
	public Transporte( String nombre, String color, Boolean estado) {
		this.nombre = nombre;
		this.color = color;
		this.estado = estado;
	}
	
	
	@Id @GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "color")
	private String color;
	
	@Column(name = "estado")
	private Boolean estado;

	public Transporte() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
}
