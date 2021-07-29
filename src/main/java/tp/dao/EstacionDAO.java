package tp.dao;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import tp.dominio.EstacionMultimodal;
import tp.dominio.HistorialDeMantenimiento;
import tp.dominio.Transporte;

public class EstacionDAO {

	public EstacionDAO() {
		
	}
	public List<EstacionMultimodal> getEstaciones() {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		List<EstacionMultimodal> estaciones = (List<EstacionMultimodal>) man.createQuery("FROM EstacionMultimodal").getResultList();
		man.close();
		return estaciones;
	}
	String tr;
	public String getById(HistorialDeMantenimiento historial) {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		List<HistorialDeMantenimiento> his = (List<HistorialDeMantenimiento>) man.createQuery("FROM HistorialDeMantenimiento").getResultList();
		
		
		for(HistorialDeMantenimiento h1: his) {
//			getFechaInicioMantenimiento en este caso seria la fecha de fin, tengo que corregir cuando setee el valor 
			if(h1.getId_estacion().equals(historial.getId_estacion()) && historial.getFechaInicioMantenimiento()==null) {
				tr = h1.getId_estacion();
			}
		}
		man.close();
		return tr;

	}
	
	public Boolean existeId(String id) {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		List<EstacionMultimodal> estacion = (List<EstacionMultimodal>) man.createQuery("FROM EstacionMultimodal").getResultList();
		
		if(estacion.isEmpty()) {
			return false;
		} else {
			for(EstacionMultimodal e : estacion) {
				if(e.getId().equals(id)) {
					return true;
				}
			}	
		}
		man.close();
		
		return false;
	}
	public void guardar(EstacionMultimodal e) {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		man.getTransaction().begin();
		man.persist(e);
		man.getTransaction().commit();
		man.close();
	}
	
	public void guardarHistorial(HistorialDeMantenimiento historial) {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		man.getTransaction().begin();
		man.persist(historial);
		man.getTransaction().commit();
		man.close();
	}
	
	public void eliminar(String id) {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		man.getTransaction().begin();
		Query q2 = man.createQuery("DELETE FROM EstacionMultimodal WHERE id = :idf");
		q2.setParameter("idf", id);
		int ro= q2.executeUpdate();
		man.getTransaction().commit();;
		man.close();
	}
	public Boolean existeNombre(String nombre) {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		List<EstacionMultimodal> estaciones = (List<EstacionMultimodal>) man.createQuery("FROM EstacionMultimodal").getResultList();
		
		if(estaciones.isEmpty()) {
			return false;
		} else {
			for(EstacionMultimodal t : estaciones) {
				if(t.getNombre().equals(nombre)) {
					return true;
				}
			}	
		}
		man.close();
		return false;
	}

	public void actualizarHistorial(String id, LocalDate fin) {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		man.getTransaction().begin();
		Query sql = man.createQuery("UPDATE HistorialDeMantenimiento SET fechafin = '"+fin+"' WHERE id_estacion = '"+id+"'");
		int r= sql.executeUpdate();
		man.getTransaction().commit();
		man.close();
	}
	public void actualizarEstacion(EstacionMultimodal estac) {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		man.getTransaction().begin();
		Query sql = man.createQuery("UPDATE EstacionMultimodal SET nombre = '"+estac.getNombre()+"', horarioapertura = '"+estac.getHorarioApertura()+"', horariocierre = '"+estac.getHorarioCierre()+"', estado = '"+estac.getEstado()+"' WHERE id = '"+estac.getId()+"'");
		int r= sql.executeUpdate();
		man.getTransaction().commit();
		man.close();
	}

}
