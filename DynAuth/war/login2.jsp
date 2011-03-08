<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="javax.jdo.PersistenceManager" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Random" %>

<%@ page import="com.outlandr.dynauth.PMF" %>
<%@ page import="com.outlandr.dynauth.user.Info" %>
<%@ page import="com.outlandr.dynauth.user.UserInfos" %>
<%@ page import="com.outlandr.dynauth.challenge.ChallengeManager" %>
<%@ page import="com.outlandr.dynauth.challenge.ChallengeProvider" %>
<%@ page import="com.outlandr.dynauth.challenge.providers.TextChallengeProvider" %>
<%@ page import="com.outlandr.dynauth.challenge.providers.OTPChallengeProvider" %>


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
   
   String challengeText = null;
  
   ChallengeProvider[] providers = ChallengeManager.getChallengeProviders(); 
  
   List usedProviders = new ArrayList();
   for (int i = 0; i < 3 ; i++) {
   	 int index;
   	 do {
   	   
   	   // Get random provider
   	   index = java.lang.Math.abs(rn.nextInt()) % (providers.length);
   	 
   	 } while (usedProviders.contains(index));
   	 
   	 ChallengeProvider provider = providers[index];
   	 usedProviders.add(index);
   	 
   	 if (provider instanceof TextChallengeProvider) {
   	   index = java.lang.Math.abs(rn.nextInt()) % (infos.size());
   	   challengeText = ((TextChallengeProvider)provider).getChallenge(infos.get(index));
   	 } else if (provider instanceof OTPChallengeProvider) {
   	   challengeText = provider.getChallenge();
   	 }
   	 
     session.setAttribute(provider.getID(), provider);
     
%>
<form action="/dynauth" method="post">
<div><%= challengeText %> </div>
<div><input type="text" name="<%= provider.getID() %>" /></div><p>


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