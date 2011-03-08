package com.outlandr.dynauth;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.outlandr.dynauth.user.Info;
import com.outlandr.dynauth.user.UserInfos;

public class BasicAuthServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(BasicAuthServlet.class.getName());

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws IOException {
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        
        // if No username or password supplied, simply return
        if (username == null || username.isEmpty() 
        		|| password == null || password.isEmpty()) {
            log.warning("Username or Password is incorrect");
            resp.sendRedirect("/login.jsp");
            return;
        }
        
        
        // Start checking for password
        PersistenceManager pm = PMF.get().getPersistenceManager();
        String query = "select from " + UserInfos.class.getName() + 
        			" where userName == " + username;
        List<UserInfos> userInfos = (List<UserInfos>) pm.newQuery(query).execute();
        if (userInfos.isEmpty()) {
        	log.warning("No user with username " + username);
        	// Start over
        	resp.sendRedirect("/login.jsp");
        } else {
        	UserInfos userInfo = userInfos.get(0);
        	if (userInfo.isValidPassword(password)) {
        		log.info("User entered correct password");
        		
        		
        		// User challenge
                resp.sendRedirect("/login2.jsp?user="+userInfo.getUserName());
        		
        	} else {
        		log.info("Incorrect password");
        	}
        	
        }        
    }

}
