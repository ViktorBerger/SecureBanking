package hr.fer.zemris.berger.securebankingweb;

import hr.fer.zemris.berger.securebankingweb.dao.UserDao;
import hr.fer.zemris.berger.securebankingweb.model.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet for login handling.
 * 
 * @author Viktor Berger
 * @version 1.0
 */
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// fetch request parameters
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		// fetch the user with extracted parameters
		User user = UserDao.login(username, password);

		// if user exists, redirect to admin panel, otherwise, redirect to login
		// page
		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("user", user.getFirstName());
			resp.sendRedirect("/admin"); // logged-in page
		} else {
			req.setAttribute("show", true);
			req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// in case of get method, juset redirect back to login page
		req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);

	}
}
