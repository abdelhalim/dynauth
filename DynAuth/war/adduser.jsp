<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.lang.String" %>
<%@ page import="com.outlandr.dynauth.InfosProvider" %>
<%@ page import="com.outlandr.dynauth.InfosManager" %>

<html>
  <body>
	<form action="/signup" method="post">
    <div>User Name: <input type="text" name="username" /></div>
    <div>Password : <input type="password" name="password" /></div>
    <div>Retype password: <input type="password" name="password2" /></div>


<%
  List<InfosProvider> infosProviders = InfosManager.getInfosProviders();
  for (int i = 0; i < infosProviders.size(); i++) {
   InfosProvider provider = infosProviders.get(i);
%>
  <div><%= provider.getQuestion() %></dev>
  <div><input type="text" name="<%= provider.getId() %>" /></div>
  
<%  
  }  
%>
    
    <div><input type="submit" value="Post" /></div>
  </form>
	
  </body>
</html>