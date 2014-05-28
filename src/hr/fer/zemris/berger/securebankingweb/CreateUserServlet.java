package hr.fer.zemris.berger.securebankingweb;

import hr.fer.zemris.berger.securebankingweb.dao.UserDao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CreateUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		UserDao.add(req.getParameter("u"), req.getParameter("p"),
				req.getParameter("f"), req.getParameter("l"));

		
	}
}
