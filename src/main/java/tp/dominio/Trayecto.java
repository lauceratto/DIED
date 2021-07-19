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
	
//	@OneToMany(mappedBy = "est", cascade = CascadeType.ALL)
//	List<EstacionMultimodal> estaciones = new ArrayList<EstacionMultimodal>();
	
	public Trayecto() {
		
	}

//	public List<EstacionMultimodal> getEstaciones() {
//		return estaciones;
//	}
//
//	public void setEstaciones(List<EstacionMultimodal> estaciones) {
//		this.estaciones = estaciones;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
