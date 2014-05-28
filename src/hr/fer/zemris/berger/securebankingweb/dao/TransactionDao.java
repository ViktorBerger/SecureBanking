package hr.fer.zemris.berger.securebankingweb.dao;

import hr.fer.zemris.berger.securebankingweb.model.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Data access object for handling {@link Transaction} persistence.
 * 
 * @author Viktor Berger
 * @version 1.0
 */
public class TransactionDao {

	/**
	 * Persists data of the given transaction.
	 * @param sender senders account
	 * @param recipient recipients account
	 * @param amount amount
	 * @param timestamp time and date of this transaction
	 */
	public static void add(String sender, String recipient, String amount, Date timestamp) {
		EntityManager em = EMFService.get().createEntityManager();
		Transaction transaction = new Transaction(sender, recipient, amount, timestamp);
		em.persist(transaction);
		em.close();
	}

	/**
	 * Retrieves all the transactions from database.
	 * @return list of transactions
	 */
	@SuppressWarnings("unchecked")
	public static List<Transaction> getAll() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select t from Transaction t");
		return new ArrayList<>(q.getResultList());
	}

}
