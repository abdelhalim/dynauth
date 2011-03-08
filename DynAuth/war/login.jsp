<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<html>
  <body>
  <img src="/DynAuth.png" style="width: 640px; height: 100px;">


  <form action="/sign" method="post">
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
	  </tbody>
	</table>
    <div><input type="submit" value="Post" /></div>
  </form>


  </body>
</html>