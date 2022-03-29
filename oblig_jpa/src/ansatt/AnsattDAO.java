package ansatt;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import ansatt.Ansatt;
import avdeling.Avdeling;

public class AnsattDAO {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MinPersistenceUnit");

	public static Ansatt FinnAnsattID(int pk) {
		EntityManager em = emf.createEntityManager();

		try {
			return em.find(Ansatt.class, pk);
		} finally {
			em.close();
		}
	}

	public static List<Ansatt> finnAnsattMedBrukernavn(String brukernavn) {
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Ansatt> query = em.createQuery("SELECT a FROM Ansatt a WHERE a.brukernavn = :brukernavn",
					Ansatt.class);
			query.setParameter("brukernavn", brukernavn);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	public static List<Ansatt> finnAlleAnsatt() {
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Ansatt> query = em.createQuery("SELECT a FROM Ansatt a", Ansatt.class);
			return query.getResultList();
		} finally {
			em.close();
		}

	}

	public static String oppdaterStilling(int id, String nyStilling) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		String Stilling = "";
		
		try {
			tx.begin();

			Ansatt ansatt = em.find(Ansatt.class, id);
			ansatt.setStilling(nyStilling);
			tx.commit();
			Stilling = nyStilling;
			
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
		return Stilling;
		
	}
	
	
	public static Ansatt lageNyAnsatt(String nyttBrukernavn, String nyttFornavn, String nyttEtternavn, LocalDate nyDato,
			String nyStilling, int nyLonn, Avdeling avdeling) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Ansatt ansatt = null;
		try {
			tx.begin();

			ansatt = new Ansatt(nyttBrukernavn, nyttFornavn, nyttEtternavn, nyDato, nyStilling, nyLonn, avdeling);
			em.persist(ansatt);

			avdeling.leggTilAnsatt(ansatt);

			em.merge(avdeling);
			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
		return ansatt;
	}
	
	
	
	
	
	

}
