package hr.fer.zemris.berger.securebankingweb.actions;

import java.io.IOException;

import hr.fer.zemris.berger.securebankingweb.Action;
import hr.fer.zemris.berger.securebankingweb.dao.VersionDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Implementation of remove action. Removes a version of application with given
 * ID.
 * 
 * @author Viktor Berger
 * @version 1.0
 */
public class RemoveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("id"));
		VersionDao.remove(id);
		request.setAttribute("versions", VersionDao.getAll());

		try {
			response.sendRedirect("/versions/show");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
