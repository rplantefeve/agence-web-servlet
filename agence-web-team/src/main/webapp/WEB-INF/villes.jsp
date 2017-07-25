<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<%@ page import="java.util.List"%>
<%@ page import="model.Ville"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des villes</title>
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
        List<Ville> villes = (List<Ville>) request.getAttribute("ville");
        for (Ville ville : villes)
        {
    %>
    <tr>
      <td><%=ville.getIdVil()%></td>
      <td><%=ville.getNom()%></td>
      <td>
        <form name="modify" action="ville" method="GET">
          <input name="action" value="edit" type="hidden" /> <input
            name="id" value="<%=ville.getIdVil()%>" type="hidden"
          /> <input type="submit" id="modify" value="" />
        </form>
      </td>
      <td>
        <form name="delete" action="ville" method="get">
          <input name="action" value="delete" type="hidden" /> <input
            name="id" value="<%=ville.getIdVil()%>" type="hidden"
          /> <input type="image" src="./images/deleteIcon.png"
            alt="Delete"
          />
        </form>
      </td>
    </tr>
    <%
        }
    %>
    <tr class="new">
      <td colspan="7"><a href="ville?action=add"><button
            class="add"
          >Ajouter une ville</button></a></td>
    </tr>
  </table>
</body>
</html>