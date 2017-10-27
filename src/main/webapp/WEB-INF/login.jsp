<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
        <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Login</h1>

      <form action="login" method="post">
		<input type="text" name="email" value="email">
		<input type="text" name="mdp" >
		<input type="submit" value="Login">
      </form>
<c:if test = "${erreur}">
         <h1 ><font color="red">Nom d'utilisateur ou mot de passe incorrect</font></h1>
      </c:if>
<c:choose>
  <c:when test="${userconnecte.email eq null}">
    <h1>Vous n'etes pas connecté..</h1>
  </c:when>
  
  <c:otherwise>
    <h1>Connecté : ${userconnecte.email}</h1>
    
  </c:otherwise>
</c:choose>
</body>
</html>