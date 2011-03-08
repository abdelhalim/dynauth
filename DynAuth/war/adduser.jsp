<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.lang.String" %>
<%@ page import="com.outlandr.dynauth.InfosProvider" %>
<%@ page import="com.outlandr.dynauth.InfosManager" %>

<html>
  <body>
	<form action="/signup" method="post">
	 <table border="0" cellpadding="0" cellspacing="0"> 
      <tbody> 
        <tr> 
          <td style="vertical-align: top;">Username <br> 
          </td> 
	      <td style="vertical-align: top; text-align: center;"><input type="text" name="username" /><br> 
	      </td> 
	    </tr>
	    <tr> 
          <td style="vertical-align: top;">Password <br> 
          </td> 
	      <td style="vertical-align: top; text-align: center;"><input type="password" name="password" /><br> 
	      </td> 
	    </tr>
	    <tr> 
          <td style="vertical-align: top;">Retype password <br> 
          </td> 
	      <td style="vertical-align: top; text-align: center;"><input type="password" name="password2" /><br> 
	      </td> 
	    </tr>    
	  </tbody>
	</table>

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