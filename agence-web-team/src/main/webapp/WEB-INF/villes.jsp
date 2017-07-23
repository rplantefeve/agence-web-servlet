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
</head>
<body>
  <table border="1">
    <tr>
      <td>Id</td>
      <td>Nom</td>
    </tr>

    <%
			List<Ville> villes = (List<Ville>) request.getAttribute("ville");

			for (Ville ville : villes) {
		%>


    <tr>
      <td><%=ville.getIdVil()%></td>
      <td><%=ville.getNom()%></td>
      <td><a href="ville?action=edit&id=<%=ville.getIdVil()%>">Editer</a></td>
      <td><a href="ville?action=delete&id=<%=ville.getIdVil()%>">Supprimer</a></td>
    </tr>
    <%
			}
		%>

    <tr>
      <td colspan="7"><a href="ville?action=add">Ajouter une
          ville</a></td>
    </tr>
  </table>
</body>
</html>