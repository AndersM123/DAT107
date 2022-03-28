package avdeling;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import ansatt.Ansatt;
import avdeling.Avdeling;

public class AvdelingDAO {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("MinPersistenceUnit");

	public Avdeling finnAvdeling(int id) {
		EntityManager em = emf.createEntityManager();
		Avdeling avdeling = null;
		try {
			avdeling = em.find(Avdeling.class, id);
		} finally {
			em.close();
		}
		return avdeling;
	}

	public List<Avdeling> utListning(String navn) {
		EntityManager em = emf.createEntityManager();
		List<Avdeling> resultatListe = null;

		try {
			String queryString = "SELECT a FROM Avdeling a WHERE a.navn = :navn";
			TypedQuery<Avdeling> query = em.createQuery(queryString, Avdeling.class);
			query.setParameter("navn", navn);
			resultatListe = query.getResultList();

		} finally {
			em.close();
		}
		return resultatListe;
	}

	public void oppdaterAvdeling(Avdeling nyAvdeling, int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			Ansatt ansatt = em.find(Ansatt.class, id);
			ansatt.setAvdeling(nyAvdeling);
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}

	}

	public Avdeling opprettAvdeling(String navn, Ansatt sjef) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		Avdeling nyAvd = null;

		try {
			tx.begin();
			Avdeling gamlAvd = sjef.getAvdeling();
			gamlAvd.fjernAnsatt(sjef);
			em.merge(gamlAvd);

			nyAvd = new Avdeling();
			nyAvd.setNavn(navn);
			nyAvd.setSjef(sjef);
			nyAvd.leggTilAnsatt(sjef);

			sjef.setAvdeling(nyAvd);
			em.merge(sjef);

			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return nyAvd;

	}

}
