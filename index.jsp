<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>first website</title>
</head>
<body>
      <center>
          <h1>ECODERS EMPLOYEES</h1>
          <h2>Admin login</h2>
          <form action= "AdminLoginServlet" method="get">
          username: <input type="text" name="username"/> <br> <br>
          password: <input type ="password" name="password"/> <br> <br>
          <input type="submit" value="login">   
          </form>
          <a href="forgotpassword.jsp">forgot password</a>
          <br><br>
          <a href="register.jsp"> new user registration</a>
          <footer>&copy;Ecoders.in hesargattha</footer>   
      </center>
</body>
</html>