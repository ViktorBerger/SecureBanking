package hr.fer.zemris.berger.securebankingweb.actions;

import hr.fer.zemris.berger.securebankingweb.Action;
import hr.fer.zemris.berger.securebankingweb.dao.VersionDao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Implementation of show action. Shows all versions of application.
 * 
 * @author Viktor Berger
 * @version 1.0
 */
public class ShowAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("versions", VersionDao.getAll());

		try {
			request.getRequestDispatcher("/WEB-INF/versions.jsp").forward(
					request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
