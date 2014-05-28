package hr.fer.zemris.berger.securebankingweb;

import hr.fer.zemris.berger.securebankingweb.dao.FootprintDao;
import hr.fer.zemris.berger.securebankingweb.dao.TransactionDao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

/**
 * Communicates with clients and persist received data.
 * 
 * @author Viktor Berger
 * @version 1.0
 */
@SuppressWarnings("serial")
public class CommunicationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Logger.getLogger(ApplicationFootprintsServlet.class.getName()).log(
				Level.ALL, req.getHeader("User-Agent"));
		
		
		// create a response message to be sent to client
		String response = "Success!";
		
		// fetch json from post request
		JSONObject json = null;
		try {
			json = new JSONObject(req.getParameter("info"));
		} catch (JSONException e) {
		}

		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

		// extract footprint data from json and persist it
		try {
			FootprintDao.add(
					json.getString("deviceID"),
					json.getString("hash"), 
					json.getString("signature"),
					sdf.parse(json.getString("timestamp"))
				);
		} catch (JSONException | ParseException e) {
			Logger.getLogger(ApplicationFootprintsServlet.class.getName()).log(
					Level.SEVERE, "Problems with footprint persistence.", e);
			response = "Transaction failed!";
		}

		// extract transaction data from json and persist it
		try {
			TransactionDao.add(
					json.getString("sender"),
					json.getString("recipient"), 
					json.getString("amount"),
					sdf.parse(json.getString("timestamp"))
				);
		} catch (JSONException | ParseException e) {
			Logger.getLogger(ApplicationFootprintsServlet.class.getName()).log(
					Level.SEVERE, "Problems with transaction persistence.", e);
			response = "Transaction failed!";
		}

		// send response to the client
		resp.getWriter().write(response);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// in case of get method, go to login page
		System.out.println(req.getHeader("User-Agent"));
	}

}
