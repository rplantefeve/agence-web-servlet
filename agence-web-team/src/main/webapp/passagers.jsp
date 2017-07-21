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
</head>
<body>

  <table border="1">
    <tr>
      <td>Id</td>
      <td>Nom</td>
      <td>Prénom</td>
      <td>Adresse</td>
      <td>Edition</td>
      <td>Suppression</td>

    </tr>

    <%
			List<Passager> passagers = (List<Passager>) request.getAttribute("passagers");
		
			for(Passager passager : passagers) {
		%>


    <tr>
      <td><%=passager.getIdPas() %></td>
      <td><%=passager.getNom() %></td>
      <td><%=passager.getPrenom() %></td>
      <td><%=passager.getAdresse() %></td>
      <td><a
        href="passager?action=edit&id=<%=passager.getIdPas() %>"
      >Editer</a></td>
      <td><a
        href="passager?action=delete&id=<%=passager.getIdPas() %>"
      >Supprimer</a></td>
    </tr>
    <% } %>

    <tr>
      <td colspan="6"><a href="passager?action=add">Ajouter un
          passager</a></td>
    </tr>
  </table>








</body>
</html>