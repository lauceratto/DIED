package tp.gestores;

import javax.swing.JOptionPane;

import tp.dao.TrayectoDAO;
import tp.dominio.Trayecto;

public class GestorTrayecto {
	private TrayectoDAO dao = new TrayectoDAO(); 
	
	public void guardarTrayecto(String nombreEstacion, String nombreTransporte) {
		Trayecto t = new Trayecto(nombreEstacion, nombreTransporte);
		dao.guardar(t);	
		JOptionPane.showMessageDialog(null, "El trayecto se ha guardado con exito!");
		
	}

	public void conectar() {
		
	}

}
