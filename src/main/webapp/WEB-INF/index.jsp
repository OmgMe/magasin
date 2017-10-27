<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
        <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
</head>
<body>
<h1>Accueil</h1>

<c:choose>
  <c:when test="${userconnecte.email eq null}">
    <h1>Vous n'etes pas connecté..</h1>
  </c:when>
  
  <c:otherwise>
    <h1>Bienvenue : ${userconnecte.role.typeRole}
    <c:if test="${userconnecte.role.typeRole eq 'Membre'}">
			<h1>Bonjour : ${userconnecte.role.typeRole}</h1>
		</c:if>
    </h1>
    
  </c:otherwise>
</c:choose>
</body>
</html>