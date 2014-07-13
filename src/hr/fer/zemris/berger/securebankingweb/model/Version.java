package hr.fer.zemris.berger.securebankingweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Contains version number and corresponding application digest.
 * 
 * @author Viktor Berger
 * @version 1.0
 */
@Entity
public class Version {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/** version of the application. */
	private String version;
	/** message digest of the current version of application. */
	private String hash;
	/** application signature. */
	private String signature;

	/**
	 * Creates new version record of the application.
	 * 
	 * @param version
	 *            current version
	 * @param hash
	 *            application message digest
	 * @param signature
	 *            application signature
	 */
	public Version(String version, String hash, String signature) {
		this.version = version;
		this.hash = hash;
		this.signature = signature;
	}

	public Long getId() {
		return this.id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hash == null) ? 0 : hash.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Version other = (Version) obj;
		if (hash == null) {
			if (other.hash != null)
				return false;
		} else if (!hash.equals(other.hash))
			return false;
		return true;
	}

}
