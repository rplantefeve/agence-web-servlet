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
<jsp:include page="../include/assets.jsp" />
</head>
<body>
  <%@include file="../include/menu.jsp"%>
  <table class="std">
    <tr>
      <th>Id</th>
      <th>Numero</th>
      <th>Compagnie</th>
      <th>Vol</th>
      <th>Ouvert</th>
      <th colspan="2">Actions</th>
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

    <tr class="new">
      <td colspan="7"><a href="compagnieAerienneVol?action=add"><button
            class="add"
          >Ajouter une liaison Compagnie / Vol</button></a></td>
    </tr>
  </table>
</body>
</html>