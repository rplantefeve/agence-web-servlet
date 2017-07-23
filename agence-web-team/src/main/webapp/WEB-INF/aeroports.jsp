<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<%@ page import="java.util.List"%>
<%@ page import="model.Aeroport"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des aéroports</title>
<jsp:include page="../include/assets.jsp" />
</head>
<body>
  <%@include file="../include/menu.jsp"%>
  <table class="std">
    <tr>
      <th>Id</th>
      <th>Nom</th>
      <th colspan="2">Actions</th>
    </tr>
    <%
        List<Aeroport> aeroports = (List<Aeroport>) request.getAttribute("aeroports");

        for (Aeroport aeroport : aeroports)
        {
    %>
    <tr>
      <td><%=aeroport.getIdAer()%></td>
      <td><%=aeroport.getNom()%></td>
      <td><a
        href="aeroport?action=edit&id=<%=aeroport.getIdAer()%>"
      >Editer</a></td>
      <td><a
        href="aeroport?action=delete&id=<%=aeroport.getIdAer()%>"
      >Supprimer</a></td>
    </tr>
    <%
        }
    %>
    <tr class="new">
      <td colspan="7">
        <a href="aeroport?action=add">
          <button class="add">Ajouter un aéroport</button>
        </a>
      </td>
    </tr>
  </table>
</body>
</html>