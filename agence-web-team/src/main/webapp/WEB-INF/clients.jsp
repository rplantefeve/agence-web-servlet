<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<%@ page import="java.util.List"%>
<%@ page import="model.Client"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des clients</title>
<jsp:include page="../include/assets.jsp" />
</head>
<body>
  <%@include file="../include/menu.jsp"%>
  <table class="std">
    <tr>
      <th>Id</th>
      <th>Nom</th>
      <th>Prénom</th>
      <th>Téléphone</th>
      <th>Fax</th>
      <th>Mail</th>
      <th>Siret</th>
      <th>Id Adresse</th>
      <th colspan="2">Actions</th>
    </tr>
    <%
        List<Client> clients = (List<Client>) request.getAttribute("clients");

        for (Client client : clients)
        {
    %>
    <tr>
      <td><%=client.getIdCli()%></td>
      <td><%=client.getNom()%></td>
      <td>
        <%
            if (client.getPrenom() != null)
                {
                    out.print(client.getPrenom());
                }
                else
                {
                    out.print("N/A");
                }
        %>
      </td>
      <td><%=client.getNumeroTel()%></td>
      <td><%=client.getNumeroFax()%></td>
      <td><%=client.getEmail()%></td>
      <td>
        <%
            if (client.getSiret() != null)
                {
                    out.print(client.getSiret());
                }
                else
                {
                    out.print("N/A");
                }
        %>
      </td>
      <td><%=client.getAdresse().getIdAdd()%></td>
      <td><a href="client?action=edit&id=<%=client.getIdCli()%>">Editer</a></td>
      <td><a href="client?action=delete&id=<%=client.getIdCli()%>">Supprimer</a></td>
    </tr>
    <%
        }
    %>

    <tr class="new">
      <td colspan="10"><a href="client?action=add">
          <button class="add">Ajouter un client</button>
      </a></td>
    </tr>
  </table>
</body>
</html>