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

/*
 * Dynamic Authentication Servlet
 * Responsible for the dynamic authtecation mechanism
 * Verifies user responses to the challenges provided by 
 * the Challenge Providers that was picked randomly in login2.jsp
 * 
 */
public class DynAuthServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(DynAuthServlet.class.getName());

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		log.info("Session ID = " + session.getId());
		
		/* Get the request parameters */
		Set<String> keySet = req.getParameterMap().keySet();
		for (String key : keySet) {
			log.info("Parameter key " +key);
			/* login2.jsp stores the challenge providers objects as the 
			 * session object attributes
			 * Retrieve them, and start validating the responses
			 * If any of the responses was not valid, redirect back
			 * to the basic login page login.jsp
			 */
			
			Object object = session.getAttribute(key);
			if (object instanceof ChallengeProvider) {
				ChallengeProvider provider = (ChallengeProvider) object;
				boolean isValid = provider.validateResponse(req.getParameter(key));
				if (!isValid) {
					// return error
					// redirect back to login
					resp.sendRedirect("/login.jsp");
					return;
				} 
			}
			
		}
		
		// all challenges are passed with VALID responses.
		// continue
		resp.setContentType("text/plain");
		resp.getWriter().println("Congratulations!! Authenticated correctly");
		
	}
}
