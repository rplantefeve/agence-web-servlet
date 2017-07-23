<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>

<%@ page import="java.util.List"%>
<%@ page import="model.CompagnieAerienne"%>
<!--  agence-data-Dreamteam.-->


<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Compagnie Aerienne</title>
</head>
<body>
  <table border="1">
    <tr>
      <td>Id</td>
      <td>Nom</td>
      <td>Edition</td>
      <td>Suppression</td>
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

    <tr>
      <td colspan="8"><a href="compagnieAerienne?action=add">Ajouter
          une compagnie</a></td>
    </tr>
  </table>
</body>
</html>