<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<%@ page import="java.util.List"%>
<%@ page import="model.Adresse"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des adresses</title>
<jsp:include page="../include/assets.jsp" />
</head>
<body>
  <%@include file="../include/menu.jsp"%>
  <table class="std">
    <tr>
      <th>Id</th>
      <th>Adresse</th>
      <th>Code Postal</th>
      <th>Ville</th>
      <th>Pays</th>
      <th colspan="2">Actions</th>
    </tr>
    <%
        List<Adresse> adresses = (List<Adresse>) request.getAttribute("adresses");

        for (Adresse bo : adresses)
        {
    %>
    <tr>
      <td><%=bo.getIdAdd()%></td>
      <td><%=bo.getAdresse()%></td>
      <td><%=bo.getCodePostal()%></td>
      <td><%=bo.getVille()%></td>
      <td><%=bo.getPays()%></td>
      <td>
        <form name="modify" action="adresse" method="GET">
          <input name="action" value="edit" type="hidden" /> <input
            name="id" value="<%=bo.getIdAdd()%>" type="hidden"
          /> <input type="submit" id="modify" value="" />
        </form>
      </td>
      <td>
        <form name="delete" action="adresse" method="get">
          <input name="action" value="delete" type="hidden" /> <input
            name="id" value="<%=bo.getIdAdd()%>" type="hidden"
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
      <td colspan="7">
        <a href="adresse?action=add">
          <button class="add">Ajouter une adresse</button>
        </a>
      </td>
    </tr>
  </table>
</body>
</html>