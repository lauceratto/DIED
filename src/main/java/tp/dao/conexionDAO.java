package tp.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class conexionDAO {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

	private conexionDAO() {
		
	}
	
	public static EntityManagerFactory getInstance() {
		return emf;
	}
}
