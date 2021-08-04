package tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import tp.dominio.EstacionMultimodal;
import tp.dominio.Transporte;
import tp.dominio.Trayecto;

public class TrayectoDAO {

	public void guardar(Trayecto t) {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		man.getTransaction().begin();
		man.persist(t);
		man.getTransaction().commit();
		man.close();
	}
	public List<Trayecto> getTrayecto() {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		List<Trayecto> trayectos = (List<Trayecto>) man.createQuery("FROM Trayecto").getResultList();
		man.close();
		return trayectos;
	}

}
