package hr.fer.zemris.berger.securebankingweb;

import hr.fer.zemris.berger.securebankingweb.dao.TransactionDao;
import hr.fer.zemris.berger.securebankingweb.model.Transaction;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Displays data about transactions.
 * 
 * @author Viktor Berger
 * @version 1.0
 */
@SuppressWarnings("serial")
public class TransactionsServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		// fetch data
		List<Transaction> transactions = TransactionDao.getAll();

		// forward data to the view
		req.setAttribute("transactions", transactions);
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("./WEB-INF/transactions.jsp");
		try {
			dispatcher.forward(req, resp);
		} catch (ServletException ex) {
			Logger.getLogger(TransactionsServlet.class.getName()).log(
					Level.SEVERE, "Can't dispatch", ex);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
