<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<%@ page import="java.util.List"%>
<%@ page import="model.Vol"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des vols</title>
</head>
<body>

  <table border="1">
    <tr>
      <td>IdVol</td>
      <td>dateDepart</td>
      <td>dateArrivee</td>
      <td>heureDepart</td>
      <td>heureArrivee</td>
      <td>aeroportDepart</td>
      <td>aeroportArrivee</td>
      <td>Edititer</td>
      <td>Supprimer</td>
    </tr>

    <%
			List<Vol> vols = (List<Vol>)request.getAttribute("vol");
			for(Vol vol : vols) {
		%>


    <tr>
      <td>
        <% out.print(vol.getIdVol()); %>
      </td>
      <td>
        <% out.print(vol.getDateDepart()); %>
      </td>
      <td>
        <% out.print(vol.getDateArrivee()); %>
      </td>
      <td>
        <% out.print(vol.getHeureDepart()); %>
      </td>
      <td>
        <% out.print(vol.getHeureArrivee()); %>
      </td>
      <td>
        <% if (vol.getAeroportDepart()!= null) {
					out.print(vol.getAeroportDepart().getNom());
				} else {
					out.print("Non renseignée");
				} %>
      </td>
      <td>
        <% if (vol.getAeroportArrivee()!= null) {
					out.print(vol.getAeroportArrivee().getNom());
				} else {
					out.print("Non renseignée");
				} %>
      </td>
      <td><a href="vol?action=edit&idVol=<%=vol.getIdVol() %>">Editer</a></td>
      <td><a href="vol?action=delete&idVol=<%=vol.getIdVol() %>">Supprimer</a></td>
    </tr>
    <% } %>

    <tr>
      <td colspan="9"><a href="vol?action=add">Ajouter un vol</a></td>
    </tr>
  </table>

</body>
</html>