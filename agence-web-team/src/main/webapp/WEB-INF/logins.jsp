<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<%@ page import="java.util.List"%>
<%@ page import="model.Login"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des Logins</title>
<jsp:include page="../include/assets.jsp" />
</head>
<body>
  <%@include file="../include/menu.jsp"%>
  <!-- Création d'un tableau de bordure 1 -->
  <table class="std">
    <!-- première ligne nom des en-têtes -->
    <tr>
      <th>Id</th>
      <th>Login</th>
      <th>Mot de Passe</th>
      <th>Admin</th>
      <th colspan="2">Actions</th>
    </tr>

    <%
        List<Login> logins = (List<Login>) request.getAttribute("logins");

        for (Login login : logins)
        {
    %>


    <tr>
      <td><%=login.getId()%></td>
      <td><%=login.getLogin()%></td>
      <td><%=login.getMotDePasse()%></td>
      <td><%=(login.getAdmin() == 1) ? "Oui" : "Non"%></td>
      <td><a href="login?action=edit&id=<%=login.getId()%>">Editer</a></td>
      <td><a href="login?action=delete&id=<%=login.getId()%>">Supprimer</a></td>
    </tr>
    <%
        }
    %>

    <tr class="new">
      <!-- la colonne s'étale sur 8 colonnes -->
      <td colspan="6"><a href="login?action=add"><button
            class="add"
          >Ajouter un Login</button></a></td>
    </tr>
  </table>

</body>
</html>