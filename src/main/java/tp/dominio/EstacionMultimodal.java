package tp.dominio;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "EstacionMultimodal")
public class EstacionMultimodal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "horarioApertura")
	private String horarioApertura;
	
	@Column(name = "horarioCierre")
	private String horarioCierre;

	@Column(name = "estado")
	private Boolean estado;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_trayecto")
//	private Trayecto tr;
//	
//	@ManyToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "id_rutaOrigen")
//	private Ruta id_rutaOrigen;
//	
//	@ManyToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "id_rutaDestino")
//	private Ruta id_rutaDestino;
//	
//	@ManyToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "nroBoleto")
//	private Boleto nroBoleto;
	public EstacionMultimodal() {
	
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

	public String getHorarioApertura() {
		return horarioApertura;
	}

	public void setHorarioApertura(String horarioApertura) {
		this.horarioApertura = horarioApertura;
	}

	public String getHorarioCierre() {
		return horarioCierre;
	}

	public void setHorarioCierre(String horarioCierre) {
		this.horarioCierre = horarioCierre;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
}
