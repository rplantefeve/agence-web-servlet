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
    <tr>
      <td colspan="7"><a href="aeroport?action=add">Ajouter un
          aéroport</a></td>
    </tr>
  </table>
</body>
</html>