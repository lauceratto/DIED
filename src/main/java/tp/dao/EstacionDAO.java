package tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import tp.dominio.EstacionMultimodal;
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

}
