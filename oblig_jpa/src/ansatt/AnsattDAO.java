package ansatt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AnsattDAO {

	private EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("MinPersistenceUnit");
	
	
	public Ansatt FinnAnsattID(int pk) {
		EntityManager em = emf.createEntityManager();
		
		try {
			return em.find(Ansatt.class, pk);
		} finally {
			em.close();
		}
		
		
	}
	
	
	
}
