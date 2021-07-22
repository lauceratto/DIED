package tp.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

import tp.dominio.Transporte;


public class TransporteDAO {

	public TransporteDAO() {
		
	}
	public List<Transporte> getTransportes() {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		List<Transporte> transportes = (List<Transporte>) man.createQuery("FROM Transporte").getResultList();
		man.close();
		return transportes;
	}
	public Boolean existeNombre(String nombre) {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		List<Transporte> transportes = (List<Transporte>) man.createQuery("FROM Transporte").getResultList();
		
		if(transportes.isEmpty()) {
			return false;
		} else {
			for(Transporte t : transportes) {
				if(t.getNombre().equals(nombre)) {
					return true;
				}
			}	
		}
		man.close();
		
		return false;
	}
	
	public void guardar(Transporte transporte) {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		man.getTransaction().begin();
		man.persist(transporte);
		man.getTransaction().commit();
		man.close();
	}

	public void actualizar(String nombre, String color, Boolean estado, Integer id) {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		man.getTransaction().begin();
		Query sql = man.createQuery("UPDATE Transporte SET nombre = '"+nombre+"', color = '"+color+"', estado = '"+estado+"' WHERE id = '"+id+"'");
		int r= sql.executeUpdate();
		man.getTransaction().commit();
		man.close();

//		
	}
	Integer tr;
	public Integer getByName(String nombre) {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		List<Transporte> transportes = (List<Transporte>) man.createQuery("FROM Transporte").getResultList();

		for(Transporte t1: transportes) {
			if(t1.getNombre().equals(nombre)) {
				tr = t1.getId();
			}
		}
		man.close();
		return tr;

	}
	public void eliminar(Integer id) {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		man.getTransaction().begin();
		Query q2 = man.createQuery("DELETE FROM Transporte WHERE id = :idf");
		q2.setParameter("idf", id);
		int ro= q2.executeUpdate();
		man.getTransaction().commit();;
		man.close();
	}

}
