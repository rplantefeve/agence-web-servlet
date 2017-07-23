<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<%@ page import="java.util.List"%>
<%@ page import="model.CompagnieAerienneVol"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des liaisons CompagnieAerienne/Vol</title>
</head>
<body>
  <table border="1">
    <tr>
      <td>Id</td>
      <td>Numero</td>
      <td>Compagnie</td>
      <td>Vol</td>
      <td>Ouvert</td>
    </tr>

    <%
        List<CompagnieAerienneVol> ListeCompagnieAerienneVol = (List<CompagnieAerienneVol>) request
                .getAttribute("compagnieAerienneVol");

        for (CompagnieAerienneVol CompagnieAerienneVol : ListeCompagnieAerienneVol)
        {
    %>


    <tr>
      <td>
        <%
            out.print(CompagnieAerienneVol.getId());
        %>
      </td>
      <td>
        <%
            out.print(CompagnieAerienneVol.getNumero());
        %>
      </td>
      <td>
        <%
            out.print(CompagnieAerienneVol.getCompagnieAerienne().getNom());
        %>
      </td>
      <td>
        <%
            out.print(CompagnieAerienneVol.getVol().getIdVol());
        %>
      </td>
      <td>
        <%
            out.print(CompagnieAerienneVol.getOuvert());
        %>
      </td>
      <td><a
        href="compagnieAerienneVol?action=edit&id=<%=CompagnieAerienneVol.getId()%>"
      >Editer</a></td>
      <td><a
        href="compagnieAerienneVol?action=delete&id=<%=CompagnieAerienneVol.getId()%>"
      >Supprimer</a></td>
    </tr>
    <%
        }
    %>

    <tr>
      <td colspan="7"><a href="compagnieAerienneVol?action=add">Ajouter
          une liaison Compagnie / Vol</a></td>
    </tr>
  </table>
</body>
</html>