package hr.fer.zemris.berger.securebankingweb.actions;

import hr.fer.zemris.berger.securebankingweb.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Implementation of add action. Adds a new version of application with
 * corresponding hash of it's source code.
 * 
 * @author Viktor Berger
 * @version 1.0
 */
public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/WEB-INF/addVersion.jsp").forward(
					request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
