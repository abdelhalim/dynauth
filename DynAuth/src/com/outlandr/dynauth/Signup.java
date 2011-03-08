package com.outlandr.dynauth;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.outlandr.dynauth.user.Info;
import com.outlandr.dynauth.user.UserInfos;

/*
 * Signup and add new user
 */
public class Signup extends HttpServlet {
    private static final Logger log = Logger.getLogger(BasicAuthServlet.class.getName());

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		/*
		 * Get the parameters
		 *   username
		 *   password, and password-retype
		 */
		String username = req.getParameter("username");
        String password = req.getParameter("password");
        String passwordReType = req.getParameter("password2");
        
        /*
         * If password and passwordRetype doesn't match, issue
         * a warning to the user, and redirect again to adduser 
         * page
         */
        if (!password.equals(passwordReType)) {
        	log.info("Passwords doesn't match");
        	resp.sendRedirect("/adduser.jsp");
        	return;
        }
        
        /*
         * Create new user info object, and store the entered information
         * 
         */
        UserInfos userInfos = new UserInfos(username, password);
                
        Enumeration<String> parameterNames = req.getParameterNames();
        
        List<InfosProvider> infosProviders = InfosManager.getInfosProviders();
        
        while (parameterNames.hasMoreElements()) {
        	String nextElement = parameterNames.nextElement();
        	
        	if (!("username".equals(nextElement) 
        			|| "password".equals(nextElement))) {
        		
        		String param = req.getParameter(nextElement);
        		
        		for (InfosProvider provider : infosProviders) {
					if (provider.getId().equals(nextElement)) {
						String question = provider.getQuestion();
				        Info info = new Info(nextElement, question, param, userInfos);
				        userInfos.getInfos().add(info);

					}
				}
        	}
        }
        
        /*
         * If everything worked fine, persist the user information
         */
        PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            pm.makePersistent(userInfos);
        } finally {
            pm.close();
        }
		
        /*
         * Now redirect to the login page
         */
        resp.sendRedirect("/login.jsp");

	}

    

}
