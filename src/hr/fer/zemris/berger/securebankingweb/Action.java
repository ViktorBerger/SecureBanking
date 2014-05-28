package hr.fer.zemris.berger.securebankingweb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface which all actions have to implement. Used for CRUD operations.
 * Design pattern: strategy.
 * 
 * @author Viktor Berger
 * @version 1.0
 */
public interface Action {
	/**
	 * Executes action. Handling at least one of the CRUD operations and/or
	 * invokes the proper view.
	 * 
	 * @param request HTTP request
	 * @param response HTTP response
	 */
	void execute(HttpServletRequest request, HttpServletResponse response);
}
