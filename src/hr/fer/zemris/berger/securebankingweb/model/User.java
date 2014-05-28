package hr.fer.zemris.berger.securebankingweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * User bean. Encapsulates all information about user needed for an authorized
 * session.
 * 
 * @author Viktor Berger
 * @version 1.0
 */
@Entity
public class User {

	@Id
	private String username;
	private String password;
	private String FirstName;
	private String LastName;
	
	/**
	 * Default constructor.
	 */
	public User(){}
	
	/**
	 * Constructor
	 * @param username username
	 * @param password password
	 * @param firstName first name 
	 * @param lastName last name
	 */
	public User(String username, String password, String firstName,
			String lastName) {
		this.username = username;
		this.password = password;
		FirstName = firstName;
		LastName = lastName;
	}

	/**
	 * Returns user's first name
	 * @return first name
	 */
	public String getFirstName() {
		return FirstName;
	}

	/**
	 * Sets users first name.
	 * @param firstName user's first name
	 */
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	/**
	 * Returns user's last name
	 * @return last name
	 */
	public String getLastName() {
		return LastName;
	}

	/**
	 * Sets user's last name.
	 * @param lastName user's last name
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
	}

	/**
	 * Returns username.
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets username.
	 * @param username username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Returns password.
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets password.
	 * @param password password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
