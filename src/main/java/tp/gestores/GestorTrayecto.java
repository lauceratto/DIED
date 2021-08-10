package tp.gestores;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import tp.dao.TrayectoDAO;
import tp.dominio.Ruta;
import tp.dominio.Transporte;
import tp.dominio.Trayecto;

public class GestorTrayecto {
	private TrayectoDAO dao = new TrayectoDAO(); 
	
	public void guardarTrayecto(String nombreEstacionOrigen,String nombreEstacionDestino, String nombreTransporte) {
		Trayecto t = new Trayecto(nombreEstacionOrigen, nombreEstacionDestino, nombreTransporte);
		dao.guardar(t);	
//		JOptionPane.showMessageDialog(null, "El trayecto se ha guardado con exito!");
		
	}
	
	public List<Trayecto> obtenerTrayectos(){
		List<Trayecto> t =  new ArrayList<Trayecto>();
		for(Trayecto trayectos: this.dao.getTrayecto()) {
			Trayecto tdto = new Trayecto();
			tdto.setEstacionOrigen(trayectos.getEstacionOrigen());
			tdto.setEstacionDestino(trayectos.getEstacionDestino());
			t.add(tdto);
		}
		return t;
	}
	
//	public String obtenerTransporte(String origen, String destino) {
//		dao.obtenerTransp(origen,destino);
//		return null;
//	}

}
