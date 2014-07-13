package hr.fer.zemris.berger.securebankingweb.dao;

import hr.fer.zemris.berger.securebankingweb.model.Version;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Data access object for handling {@link Version} persistence.
 * 
 * @author Viktor Berger
 * @version 1.0
 */
public class VersionDao {

	/**
	 * Adds a new {@link Version} to database.
	 * 
	 * @param version
	 *            version id
	 * @param hash
	 *            message digest of the current version application
	 */
	public static void add(String version, String hash, String signature) {
		EntityManager em = EMFService.get().createEntityManager();
		Version ver = new Version(version, hash, signature);
		em.persist(ver);
		em.close();
	}

	/**
	 * Removes {@link Version} with corresponding version id.
	 * 
	 * @param id
	 *            version id
	 */
	public static void remove(Long id) {
		EntityManager em = EMFService.get().createEntityManager();
		try {
			Version ver = em.find(Version.class, id);
			em.remove(ver);
		} finally {
			em.close();
		}
	}

	/**
	 * Returns an instance of {@link Version} based on provided version id.
	 * 
	 * @return an instance of Version
	 */
	public static Version get(String version) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select v from Version v where v.ver = :ver");
		q.setParameter("ver", version);
		Version ver;
		try {
			ver = (Version) q.getSingleResult();
		} catch (Exception e) {
			ver = null;
		}
		return ver;
	}

	/**
	 * Retrieves all the versions from database.
	 * 
	 * @return list of version objects
	 */
	@SuppressWarnings("unchecked")
	public static List<Version> getAll() {
		EntityManager em = EMFService.get().createEntityManager();
		Query query = em.createQuery("select v from Version v");
		return query.getResultList();
	}

}
