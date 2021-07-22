package tp.gestores;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import tp.Exceptions.TransporteException;
import tp.dao.TransporteDAO;
import tp.dominio.Transporte;

public class GestorTransporte {
	
	private TransporteDAO dao = new TransporteDAO();
	
	public GestorTransporte() {
	}
	
	public List<Transporte> getTransportes() {
		List<Transporte> t =  new ArrayList<Transporte>();
		for(Transporte transporte: this.dao.getTransportes()) {
			Transporte tdto = new Transporte();
			tdto.setNombre(transporte.getNombre());
			tdto.setColor(transporte.getColor());
			tdto.setEstado(transporte.getEstado());
			t.add(tdto);
		}
		return t;
	}

	public Transporte crearTransporte(Transporte transporte) throws TransporteException{
		if(transporte.getNombre().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El nombre del transporte no puede ser nulo", "Advertencia", 0);
		}else {
		if(dao.existeNombre(transporte.getNombre()) == true) {
			JOptionPane.showMessageDialog(null, "El nombre del transporte ya existe, elija otro");
			throw new TransporteException("El nombre del transporte ya existe");
		}else {
			Transporte tr = new Transporte();
			tr.setNombre(transporte.getNombre());
			tr.setColor(transporte.getColor());
			tr.setEstado(transporte.getEstado());
			dao.guardar(tr);
			JOptionPane.showMessageDialog(null,"El transporte se ha creado con exito!");
			return tr;
		}
		}
		return transporte;
	}

	public void actulizarTransporte(Integer id,String nombre, String color, Boolean estado) throws TransporteException{
		//ESTA COMENTADO PORQUE DEBERIA PONER UNA CONDICION DE QUE EL ID SEA EL MISMO PARA PODER ACTUALIZARLO
//		if(dao.existeNombre(nombre)) {
//			JOptionPane.showMessageDialog(null, "El nombre del transporte ya existe, por favor elija otro");
//		}else {
			dao.actualizar(nombre,color, estado, id);
			JOptionPane.showMessageDialog(null, "El transporte se ha editado correctamente!");
//		}
	}

	public Integer obtenerIdPorNombre(String nombre) {

		return dao.getByName(nombre);		
	}

	public void eliminarTransporte(Integer id) {
		dao.eliminar(id);
		
	}
}
