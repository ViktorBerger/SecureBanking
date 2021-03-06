package hr.fer.zemris.berger.securebankingweb;

import hr.fer.zemris.berger.securebankingweb.dao.FootprintDao;
import hr.fer.zemris.berger.securebankingweb.dao.VersionDao;
import hr.fer.zemris.berger.securebankingweb.model.Footprint;
import hr.fer.zemris.berger.securebankingweb.model.Version;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Displays data about application used in the certain transaction.
 * 
 * @author Viktor Berger
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ApplicationFootprintsServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		// fetch footprints
		List<Footprint> footprints = FootprintDao.getAll();

		// fetch versions with corresponding hashes
		List<Version> versions = VersionDao.getAll();

		// maps signatures to corresponding hashes
		Map<String, String> sigHashMap = new HashMap<>();

		for (Version version : versions) {
			sigHashMap.put(version.getSignature(), version.getHash());
		}

		for (Footprint footprint : footprints) {
			String hash = sigHashMap.get(footprint.getSignature());
			if (hash == null || !hash.equals(footprint.getHash())) {
				footprint.setValid(false);
			} else {
				footprint.setValid(true);
			}
		}

		// forward data to the view
		req.setAttribute("footprints", footprints);
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("./WEB-INF/application_footprints.jsp");
		try {
			dispatcher.forward(req, resp);
		} catch (ServletException ex) {
			Logger.getLogger(ApplicationFootprintsServlet.class.getName()).log(
					Level.SEVERE, "Can't dispatch", ex);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
