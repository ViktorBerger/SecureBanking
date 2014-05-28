package hr.fer.zemris.berger.securebankingweb.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * {@link EntityManagerFactory} singleton class.
 * 
 * @author Viktor Berger
 * @version 1.0
 */
public class EMFService {

	/** private instance of the factory */
	private static final EntityManagerFactory emfInstance = Persistence
			.createEntityManagerFactory("transactions-optional");

	/** private constructor */
	private EMFService() {
	}

	/**
	 * Returns an instance of {@link EntityManagerFactory}.
	 * 
	 * @return {@link EntityManagerFactory}
	 */
	public static EntityManagerFactory get() {
		return emfInstance;
	}
}
