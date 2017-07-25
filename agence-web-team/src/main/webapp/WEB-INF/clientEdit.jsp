<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="model.Adresse"%>
<%@page import="model.Client"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification des informations du client</title>
<jsp:include page="../include/assets.jsp" />
</head>
<body>
  <%@include file="../include/menu.jsp"%>
  <%
      // récup. de l'objet Client
      Client client = (Client) request.getAttribute("client");
      /* Init. des chaînes du formulaire */
      String idClientForm = "";
      String nomClientForm = "";
      String prenomClientForm = "";
      String numTelForm = "";
      String numFaxForm = "";
      String eMailForm = "";
      String siretForm = "";
      String idAddForm = "";
      /* Tests */
      // si le client n'est pas null
      if (client != null)
      {
          Integer idClient = client.getIdCli();
          if (idClient != 0)
          {
              idClientForm = idClient.toString();
          }

          String nomClient = client.getNom();
          if (nomClient != null)
          {
              nomClientForm = nomClient;
          }

          String prenomClient = client.getPrenom();
          if (nomClient != null)
          {
              prenomClientForm = prenomClient;
          }

          String numTel = client.getNumeroTel();
          if (numTel != null)
          {
              numTelForm = numTel.toString();
          }

          String numFax = client.getNumeroFax();
          if (numFax != null)
          {
              numFaxForm = numFax.toString();
          }

          String eMail = client.getEmail();

          if (eMail != null)
          {
              eMailForm = eMail.toString();
          }

          String siret = client.getSiret();

          if (siret != null)
          {
              siretForm = siret.toString();
          }

          Adresse adresse = client.getAdresse();
          // si l'adresse n'est pas null
          if (adresse != null)
          {
              idAddForm = Integer.toString(client.getAdresse().getIdAdd());
          }
      }
  %>
  <fieldset>
    <legend>
      <%
          if (idClientForm.equals(""))
          {
              out.print("Création");
          }
          else
          {
              out.print("Edition");
          }
      %>
      du client
    </legend>
    <%
        Object errors = request.getAttribute("errors");
        if (errors != null)
        {
            List<String> errorMessages = (List<String>) errors;
            // s'il y a des messages d'erreurs
            if (errorMessages.size() > 0)
            {
                out.print("<p>");
                // boucle d'affichage des erreurs
                for (String message : errorMessages)
                {
                    out.print(message);
                    out.print("<br/>");
                }
                out.print("</p>");
            }
        }
    %>
    <form action="client" method="post">
      <input type="hidden" name="action" value="update" />
      <table>
        <tr>
          <td>Id</td>
          <td><input type="text" readonly name="id"
            value="<%=idClientForm%>"
            <%if (idClientForm.equals(""))
            {
                out.print("disabled");
            }%>
          /></td>
        </tr>
        <tr>
          <td>Nom</td>
          <td><input type="text" name="nom"
            value="<%=nomClientForm%>"
          /></td>
        </tr>
        <tr>
          <td>Prénom</td>
          <td><input type="text" name="prenom"
            value="<%=prenomClientForm%>"
          /></td>
        </tr>
        <tr>
          <td>Numéro de téléphone</td>
          <td><input type="text" name="numeroTel"
            value="<%=numTelForm%>"
          /></td>
        </tr>
        <tr>
          <td>Numéro de fax</td>
          <td><input type="text" name="numeroFax"
            value="<%=numFaxForm%>"
          /></td>
        </tr>
        <tr>
          <td>Courriel</td>
          <td><input type="text" name="email"
            value="<%=eMailForm%>"
          /></td>
        </tr>
        <tr>
          <td>Siret</td>
          <td><input type="text" name="siret"
            value="<%=siretForm%>"
          /></td>
        </tr>
        <tr>
          <td>Id de l'adresse</td>
          <td><input type="text" name="idAdd"
            value="<%=idAddForm%>"
          />
        </tr>
        <tr>
          <td colspan="2"><input type="submit" value="Valider" /></td>
        </tr>
      </table>
    </form>
  </fieldset>

</body>
</html>