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

	public List<Ruta> getRutas(String nombreTransporte) {
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager();
		List<Ruta> rutas = (List<Ruta>) man.createQuery("FROM Ruta WHERE transporte='"+nombreTransporte+"'").getResultList();
		man.close();
		return rutas;
	}

}
