package hr.fer.zemris.berger.securebankingweb.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Contains data which describes mobile application.
 * 
 * @author Viktor Berger
 * @version 1.0
 */
@Entity
public class Footprint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/** Unique device ID. */
	private String deviceID;
	/** Moment in time when this footprint was taken. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	/** Digest of application bytecode. */
	private String hash;
	/** Signature of application developer. */
	private String signature;
	/**
	 * Flag indicates if the footprint is valid. This field is not persistent.
	 * It's used just as inicator variable for view.
	 */
	@Transient
	private boolean valid;

	public Footprint(String deviceID, Date timestamp, String hash,
			String signature) {
		super();
		this.deviceID = deviceID;
		this.timestamp = timestamp;
		this.hash = hash;
		this.signature = signature;
	}

	public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
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

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date date) {
		this.timestamp = date;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
