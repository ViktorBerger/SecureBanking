package hr.fer.zemris.berger.securebankingweb.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Encapsulates data about a single transaction.
 * 
 * @author Viktor Berger
 * @version 1.0
 */
@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/** sender account. */
	private String senderAccount;
	/** recipient account. */
	private String recipientAccount;
	/** Transfered amount of money. */
	private String amount;
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	public Transaction(String senderAccount, String recipientAccount,
			String amount, Date timestamp) {
		this.senderAccount = senderAccount;
		this.recipientAccount = recipientAccount;
		this.amount = amount;
		this.timestamp = timestamp;
	}

	public String getSenderAccount() {
		return senderAccount;
	}

	public void setSenderAccount(String senderAccount) {
		this.senderAccount = senderAccount;
	}

	public String getRecipientAccount() {
		return recipientAccount;
	}

	public void setRecipientAccount(String recipientAccount) {
		this.recipientAccount = recipientAccount;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
