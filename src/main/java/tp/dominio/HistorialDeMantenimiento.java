package tp.dominio;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HistorialMantenimiento")
public class HistorialDeMantenimiento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	@Column(name = "Id")
	private Integer id;
	@Column(name = "fechaInicio")
	private LocalDate fechaInicioMantenimiento;
	@Column(name = "fechaFin")
	private LocalDate fechaFinMantenimiento;
	@Column(name = "Observaciones")
	private String observaciones;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_estacion")
	@Column(name = "id_estacion")
	private String estacionMultimodal;
	
	public HistorialDeMantenimiento() {

	}
	
	public HistorialDeMantenimiento(LocalDate fechaInicioMantenimiento, LocalDate fechaFinMantenimiento,
			String observaciones, String id_estacion) {
		this.fechaInicioMantenimiento = fechaInicioMantenimiento;
		this.fechaFinMantenimiento = fechaFinMantenimiento;
		this.observaciones = observaciones;
		this.estacionMultimodal = id_estacion;
	}
	public LocalDate getFechaInicioMantenimiento() {
		return fechaInicioMantenimiento;
	}
	public void setFechaInicioMantenimiento(LocalDate fechaInicioMantenimiento) {
		this.fechaInicioMantenimiento = fechaInicioMantenimiento;
	}
	public LocalDate getFechaFinMantenimiento() {
		return fechaFinMantenimiento;
	}
	public void setFechaFinMantenimiento(LocalDate fechaFinMantenimiento) {
		this.fechaFinMantenimiento = fechaFinMantenimiento;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getId_estacion() {
		return estacionMultimodal;
	}
	public void setId_estacion(String id_estacion) {
		this.estacionMultimodal = id_estacion;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
