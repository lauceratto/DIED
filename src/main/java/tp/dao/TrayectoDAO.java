package tp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import tp.dominio.EstacionMultimodal;
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

}
