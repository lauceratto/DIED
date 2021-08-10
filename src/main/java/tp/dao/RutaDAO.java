package tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import tp.dominio.EstacionMultimodal;
import tp.dominio.Ruta;

public class RutaDAO {

	public void guardar(Ruta ruta) {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		man.getTransaction().begin();
		man.persist(ruta);
		man.getTransaction().commit();
		man.close();
	}

	public List<Ruta> getRutas(String origen,String destino) {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		List<Ruta> rutas = (List<Ruta>) man.createQuery("FROM Ruta WHERE origen = '"+origen+"' AND destino = '"+destino+"'").getResultList();
		man.close();
		return rutas;
	}
	public List<Ruta> getRutas() {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		List<Ruta> rutas = (List<Ruta>) man.createQuery("FROM Ruta").getResultList();
		man.close();
		return rutas;
	}
}
