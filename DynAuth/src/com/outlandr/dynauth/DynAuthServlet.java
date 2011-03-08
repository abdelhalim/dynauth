package com.outlandr.dynauth;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.outlandr.dynauth.challenge.ChallengeProvider;

public class DynAuthServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(DynAuthServlet.class.getName());

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		log.info("Session ID = " + session.getId());
		
		Set<String> keySet = req.getParameterMap().keySet();
		for (String key : keySet) {
			log.info("Parameter key " +key);
			Object object = session.getAttribute(key);
			if (object instanceof ChallengeProvider) {
				ChallengeProvider provider = (ChallengeProvider) object;
				boolean isValid = provider.validateResponse(req.getParameter(key));
				if (!isValid) {
					// return error
					// redirect back to login
					
					return;
				} 
			}
			
		}
		
		// all challenges are passed with VALID responses.
		// continue
		
	}
}
