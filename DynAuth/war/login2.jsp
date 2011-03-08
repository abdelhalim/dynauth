<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="javax.jdo.PersistenceManager" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Random" %>

<%@ page import="com.outlandr.dynauth.PMF" %>
<%@ page import="com.outlandr.dynauth.user.Info" %>
<%@ page import="com.outlandr.dynauth.user.UserInfos" %>
<%@ page import="com.outlandr.dynauth.challenge.ChallengeManager" %>
<%@ page import="com.outlandr.dynauth.challenge.ChallengeProvider" %>


<html>
  <body>
 
<% 
 String username = request.getParameter("user"); 

 Random rn = new Random();
 List<Info> infos;
 PersistenceManager pm = PMF.get().getPersistenceManager();
 String query = "select from " + UserInfos.class.getName() + 
        			" where userName == " + username;
 List<UserInfos> userInfos = (List<UserInfos>) pm.newQuery(query).execute();
 if (!userInfos.isEmpty()) {
   UserInfos userInfo = userInfos.get(0);
   infos = userInfo.getInfos();
   
   for (int i = 0; i < infos.size() ; i++) {
   	 if (i > 3)
   	   break;
   	 
   	 ChallengeProvider[] providers = ChallengeManager.getChallengeProviders();
   	 int index = java.lang.Math.abs(rn.nextInt()) % (providers.length);
   	 ChallengeProvider provider = providers[index];
   	 
     String id = session.getId();
     Info info = infos.get(i);
     session.setAttribute(info.getId(), provider);
     
%>
<form action="/dynauth" method="post">
<div><%= provider.getChallenge(info) %> </div>
<div><input type="text" name="<%= info.getId() %>" /></div><p>


<%   	
   
   }
%>
<div><input type="submit" value="Post" /></div>
</form>

<% 
 }
%>
  
  </body>
</html>