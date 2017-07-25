<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<%@ page import="java.util.List"%>
<%@ page import="model.Passager"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des passagers</title>
<jsp:include page="../include/assets.jsp" />
</head>
<body>
  <%@include file="../include/menu.jsp"%>
  <table class="std">
    <tr>
      <th>Id</th>
      <th>Nom</th>
      <th>Prénom</th>
      <th>Adresse</th>
      <th colspan="2">Actions</th>
    </tr>
    <%
        List<Passager> passagers = (List<Passager>) request.getAttribute("passagers");

        for (Passager passager : passagers)
        {
    %>
    <tr>
      <td><%=passager.getIdPas()%></td>
      <td><%=passager.getNom()%></td>
      <td><%=passager.getPrenom()%></td>
      <td><%=passager.getAdresse()%></td>
      <td><a
        href="passager?action=edit&id=<%=passager.getIdPas()%>"
      >Editer</a></td>
      <td><a
        href="passager?action=delete&id=<%=passager.getIdPas()%>"
      >Supprimer</a></td>
    </tr>
    <%
        }
    %>
    <tr class="new">
      <td colspan="6"><a href="passager?action=add">
          <button class="add">Ajouter un passager</button>
      </a></td>
    </tr>
  </table>








</body>
</html>