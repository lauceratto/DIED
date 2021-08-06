package tp.gestores;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import tp.Exceptions.EstacionException;
import tp.Exceptions.TransporteException;
import tp.dao.EstacionDAO;
import tp.dominio.EstacionMultimodal;
import tp.dominio.HistorialDeMantenimiento;
import tp.dominio.Transporte;

public class GestorEstacion {
	private EstacionDAO dao = new EstacionDAO();
	private String obtenerid = null;
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
				JOptionPane.showMessageDialog(null, "El nombre de la estación ya existe, elija otro");
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
	
	public void guardarEnHistorial(LocalDate inicio, LocalDate fin, String obs, String id) {
		HistorialDeMantenimiento historial = new HistorialDeMantenimiento(inicio,fin,obs,id);
		//Deberia validar que los estado sean distintos antes de guardar.
		dao.guardarHistorial(historial);
		JOptionPane.showMessageDialog(null, "La estacion se actualizo con exito");
	}
	public void actualizarHistorial(LocalDate inicio, LocalDate fin, String obs, String id) {
		HistorialDeMantenimiento historial = new HistorialDeMantenimiento(inicio,fin,obs,id);
		obtenerid = obtenerID(historial);
		dao.actualizarHistorial(obtenerid,fin);
		JOptionPane.showMessageDialog(null, "La estacion se actualizo con exito");
	}
	public String obtenerID(HistorialDeMantenimiento historial) {
		return dao.getById(historial);
	}
	public void actualizarEstacion(EstacionMultimodal estac) {
		dao.actualizarEstacion(estac);
		
	}
	public List<EstacionMultimodal> getEstacionesDisponibles() {
		List<EstacionMultimodal> e =  new ArrayList<EstacionMultimodal>();
		LocalDateTime locaDate = LocalDateTime.now();
		int hora  = locaDate.getHour();
		int min = locaDate.getMinute();
		String horario = hora+":"+min;
		for(EstacionMultimodal est: this.dao.getEstacionesDisponibles(horario)) {
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

}
