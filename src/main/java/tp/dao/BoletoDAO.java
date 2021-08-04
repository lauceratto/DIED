package tp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import tp.dominio.Boleto;

public class BoletoDAO {
	
	public BoletoDAO() {
		
	}
	
	public void guardar(Boleto b) {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		man.getTransaction().begin();
		man.persist(b);
		man.getTransaction().commit();
		man.close();
	}

}
