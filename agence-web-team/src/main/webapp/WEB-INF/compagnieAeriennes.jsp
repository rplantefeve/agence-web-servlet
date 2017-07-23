<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<%@ page import="java.util.List"%>
<%@ page import="model.CompagnieAerienne"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Compagnie Aerienne</title>
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
        List<CompagnieAerienne> listCompagnieAerienne = (List<CompagnieAerienne>) request
                .getAttribute("CompagnieAerienne");

        for (CompagnieAerienne objCompagnieAerienne : listCompagnieAerienne)
        {
    %>
    <tr>
      <td><%=objCompagnieAerienne.getId()%></td>

      <td><%=objCompagnieAerienne.getNom()%></td>

      <td><a
        href="compagnieAerienne?action=edit&id=<%=objCompagnieAerienne.getId()%>"
      >Editer</a></td>
      <td><a
        href="compagnieAerienne?action=delete&id=<%=objCompagnieAerienne.getId()%>"
      >Supprimer</a></td>
    </tr>
    <%
        }
    %>

    <tr class="new">
      <td colspan="8"><a href="compagnieAerienne?action=add"><button
            class="add"
          >Ajouter une compagnie</button></a></td>
    </tr>
  </table>
</body>
</html>