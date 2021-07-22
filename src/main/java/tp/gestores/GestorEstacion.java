package tp.gestores;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import tp.Exceptions.EstacionException;
import tp.Exceptions.TransporteException;
import tp.dao.EstacionDAO;
import tp.dominio.EstacionMultimodal;
import tp.dominio.Transporte;

public class GestorEstacion {
	private EstacionDAO dao = new EstacionDAO();
	public GestorEstacion() {
		
	}
	public List<EstacionMultimodal> getEstaciones() {
		List<EstacionMultimodal> e =  new ArrayList<EstacionMultimodal>();
		for(EstacionMultimodal est: this.dao.getEstaciones()) {
			EstacionMultimodal edto = new EstacionMultimodal();
			edto.setId(est.getId());
			edto.setNombre(est.getNombre());
			edto.setHorarioApertura(est.getHorarioApertura());
			edto.setHorarioCierre(est.getHorarioCierre());
			edto.setEstado(est.getEstado());
			e.add(edto);
		}
		return e;
	}
	public EstacionMultimodal crearEstacion(EstacionMultimodal estacion) throws EstacionException{
		if(estacion.getNombre().isEmpty() || estacion.getId().isEmpty() || estacion.getHorarioApertura().isEmpty() || estacion.getHorarioCierre().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No pueden haber campos nulos", "Advertencia", 0);
		}else {
		if(dao.existeId(estacion.getId()) == true) {
			JOptionPane.showMessageDialog(null, "El ID ya existe, elija otro");
//			throw new EstacionException("El ID ya existe");
		}else {
			if(dao.existeNombre(estacion.getNombre())== true) {
				JOptionPane.showMessageDialog(null, "El nombre de la estaci�n ya existe, elija otro");
				//throw new EstacionException("El nombre ya existe");
			}else {
			EstacionMultimodal tr = new EstacionMultimodal();
			tr.setId(estacion.getId());
			tr.setNombre(estacion.getNombre());
			tr.setHorarioApertura(estacion.getHorarioApertura());
			tr.setHorarioCierre(estacion.getHorarioCierre());
			tr.setEstado(estacion.getEstado());
			dao.guardar(tr);
			JOptionPane.showMessageDialog(null,"La estacion se ha creado con exito!");
			return tr;
			}
		}
		}
		return estacion;
	}
	
	public void eliminarEstacion(String id) {
		dao.eliminar(id);
	}
}
