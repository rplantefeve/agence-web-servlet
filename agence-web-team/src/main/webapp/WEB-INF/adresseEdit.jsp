<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<%@ page import="model.Adresse"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Edition de l'adresse</title>
</head>
<body>
  <%
      Adresse adresse = (Adresse) request.getAttribute("adresse");
      /* Tests */
      Integer idAdd = adresse.getIdAdd();
      String idAddForm;
      if (idAdd == 0)
      {
          idAddForm = "";
      }
      else
      {
          idAddForm = idAdd.toString();
      }

      String adresseAdresse = adresse.getAdresse();
      String adresseAdresseForm;
      if (adresseAdresse == null)
      {
          adresseAdresseForm = "";
      }
      else
      {
          adresseAdresseForm = adresseAdresse;
      }

      String codePostalAdresse = adresse.getCodePostal();
      String codePostalAdresseForm;
      if (codePostalAdresse == null)
      {
          codePostalAdresseForm = "";
      }
      else
      {
          codePostalAdresseForm = codePostalAdresse;
      }
      String villeAdresse = adresse.getVille();
      String villeAdresseForm;
      if (villeAdresse == null)
      {
          villeAdresseForm = "";
      }
      else
      {
          villeAdresseForm = villeAdresse.toString();
      }

      String paysAdresse = adresse.getPays();
      String paysAdresseForm;
      if (paysAdresse == null)
      {
          paysAdresseForm = "";
      }
      else
      {
          paysAdresseForm = paysAdresse.toString();
      }
  %>
  <fieldset>
    <legend>
      <%
          if (idAddForm.equals(""))
          {
              out.print("Création");
          }
          else
          {
              out.print("Edition");
          }
      %>
      de l'adresse
    </legend>
    <form action="adresse" method="post">
      <input type="hidden" name="action" value="update" />
      <table>
        <tr>
          <td>Id</td>
          <td><input type="text" name="id" value="<%=idAddForm%>"
            readonly
            <%if (idAddForm.equals(""))
            {
                out.print("disabled");
            }%>
          /></td>
        </tr>
        <tr>
          <td>Adresse</td>
          <td><input type="text" name="adresse" maxlength="255"
            value="<%=adresseAdresseForm%>"
          /></td>
        </tr>
        <tr>
          <td>Code Postal</td>
          <td><input type="text" name="codePostal" maxlength="5"
            value="<%=codePostalAdresseForm%>"
          /></td>
        </tr>
        <tr>
          <td>Ville</td>
          <td><input type="text" name="ville" maxlength="163"
            value="<%=villeAdresseForm%>"
          /></td>
        </tr>
        <tr>
          <td>Pays</td>
          <td><input type="text" name="pays" maxlength="31"
            value="<%=paysAdresseForm%>"
          /></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" value="Valider" /></td>
        </tr>
      </table>
    </form>
  </fieldset>

</body>
</html>