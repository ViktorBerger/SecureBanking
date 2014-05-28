package hr.fer.zemris.berger.securebankingweb.dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import hr.fer.zemris.berger.securebankingweb.model.User;

/**
 * Data access object for handling {@link User} persistence.
 * 
 * @author Viktor Berger
 * @version 1.0
 */
public class UserDao {

	/**
	 * Returns an instance of {@link User} class if credentials are valid. If
	 * credentials are invalid, returns null.
	 * 
	 * @param username
	 *            username
	 * @param password
	 *            password
	 * @return user if credentials are valid, <code>null</code> otherwise
	 */
	public static User login(String username, String password) {
		User user = get(username);

		// check encrypted password
		try {
			password = new String(MessageDigest.getInstance("SHA-1")
					.digest(password.trim().getBytes(StandardCharsets.UTF_8)));
		} catch (NoSuchAlgorithmException e) {
			user = null;
		}

		if (user != null) {
			if (!user.getPassword().equals(password)) {
				user = null;
			}
		}
		return user;
	}

	/**
	 * Adds a new {@link User} to database.
	 * 
	 * @param username
	 *            username
	 * @param password
	 *            password
	 * @param firstName
	 *            first name
	 * @param lastName
	 *            last name
	 */
	public static void add(String username, String password, String firstName,
			String lastName) {
		EntityManager em = EMFService.get().createEntityManager();
		
		// encrypt password
		try {
			password = new String(MessageDigest.getInstance("SHA-1")
					.digest(password.trim().getBytes(StandardCharsets.UTF_8)));
		} catch (NoSuchAlgorithmException e) {
		}
		User user = new User(username, password, firstName, lastName);
		em.persist(user);
		em.close();
	}

	/**
	 * Returns an instance of {@link User} based on provided username.
	 * 
	 * @param username
	 *            username.
	 * @return user
	 */
	public static User get(String username) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select u from User u where u.username = :username");
		q.setParameter("username", username);
		User user;
		try {
			user = (User) q.getSingleResult();
		} catch (Exception e) {
			user = null;
		}
		return user;
	}

	/**
	 * Removes {@link User} with corresponding username.
	 * 
	 * @param username
	 *            user's username
	 */
	public static void remove(String username) {
		EntityManager em = EMFService.get().createEntityManager();
		try {
			User user = em.find(User.class, username);
			em.remove(user);
		} finally {
			em.close();
		}
	}
}
