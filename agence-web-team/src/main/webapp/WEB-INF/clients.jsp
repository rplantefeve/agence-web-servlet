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
</head>
<body>
  <table border="1">
    <tr>
      <td>Id</td>
      <td>Nom</td>
      <td>Prénom</td>
      <td>Téléphone</td>
      <td>Fax</td>
      <td>Mail</td>
      <td>Siret</td>
      <td>Id Adresse</td>
      <td>Edition</td>
      <td>Suppression</td>
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

    <tr>
      <td colspan="10"><a href="client?action=add">Ajouter un
          client</a></td>
    </tr>
  </table>
</body>
</html>