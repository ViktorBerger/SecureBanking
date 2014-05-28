package hr.fer.zemris.berger.securebankingweb;

import hr.fer.zemris.berger.securebankingweb.actions.AddAction;
import hr.fer.zemris.berger.securebankingweb.actions.RemoveAction;
import hr.fer.zemris.berger.securebankingweb.actions.ShowAction;
import hr.fer.zemris.berger.securebankingweb.dao.VersionDao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class VersionsServlet extends HttpServlet {

	Map<String, Action> actions;

	@Override
	public void init() throws ServletException {
		super.init();
		actions = new HashMap<>();
		actions.put("add", new AddAction());
		actions.put("remove", new RemoveAction());
		actions.put("show", new ShowAction());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String version = req.getParameter("version");
		String hash = req.getParameter("hash");

		VersionDao.add(version, hash);

		resp.sendRedirect("/versions/show");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getPathInfo().substring(1);
		if (actions.containsKey(action)) {
			actions.get(action).execute(req, resp);
		} else {
			resp.sendRedirect("/versions/show");
		}

	}
}
