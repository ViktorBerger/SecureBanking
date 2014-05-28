package hr.fer.zemris.berger.securebankingweb.dao;

import hr.fer.zemris.berger.securebankingweb.model.Footprint;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Data access object for handling {@link Footprint} persistence.
 * 
 * @author Viktor Berger
 * @version 1.0
 */
public class FootprintDao {

	/**
	 * Persists provided footprint data.
	 * @param deviceID unique device ID
	 * @param hash application message digest 
	 * @param signature developers signature
	 * @param timestamp date and time of taking this footprint
	 */
	public static void add(String deviceID, String hash, String signature, Date timestamp) {
		EntityManager em = EMFService.get().createEntityManager();
		Footprint footprint = new Footprint(deviceID, timestamp, hash, signature);
		em.persist(footprint);
		em.close();
	}

	/**
	 * Retrieves all the footprints from database.
	 * @return list of footprints
	 */
	@SuppressWarnings("unchecked")
	public static List<Footprint> getAll() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select f from Footprint f ORDER BY f.timestamp asc");
		return new ArrayList<>(q.getResultList());
	}

}
