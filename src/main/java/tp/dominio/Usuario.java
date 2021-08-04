package tp.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "Contrase�a")
	private String contrase�a;

	public Usuario() {
		
	}
	public String getNombre() {
		return "TPDIED";
	}

	public void setNombre(String nombre) {
		this.nombre = "TPDIED";
	}

	public String getContrase�a() {
		return "12345";
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = "12345";
	}
	
	
}
