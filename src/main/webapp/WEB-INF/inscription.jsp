<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
        <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inscription</title>
</head>
<body>
<h1>Inscription</h1>


      <form action="create" method="post">
       <input type="text" name="nom" value="nom">
		<input type="text" name="prenom">
		<input type="text" name="email" value="email">
		<c:if test="${ contraintes.containsKey('email')}">
			${contraintes.get('email')}
		</c:if>
		<input type="text" name="mdp">
		<c:if test="${ contraintes.containsKey('mdp')}">
			${contraintes.get('mdp')}
		</c:if>
		<input type="submit" value="Login">
      </form>

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