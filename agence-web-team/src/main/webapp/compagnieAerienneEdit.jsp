
<%@ page import="model.CompagnieAerienne"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>


<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Edition Compagnie Aerienne</title>
</head>
<body>

  <%
      model.CompagnieAerienne objCompagnieAerienne = (model.CompagnieAerienne) request
              .getAttribute("CompagnieAerienne");
      /* Tests */
      Integer idCompagnieAerienne = objCompagnieAerienne.getId();
      String idCompagnieAerienneForm;
      if (idCompagnieAerienne == 0)
      {
          idCompagnieAerienneForm = "";
      }
      else
      {
          idCompagnieAerienneForm = idCompagnieAerienne.toString();
      }

      String nomCompagnieAerienne = objCompagnieAerienne.getNom();
      String nomCompagnieAerienneForm;
      if (nomCompagnieAerienne == null)
      {
          nomCompagnieAerienneForm = "";
      }
      else
      {
          nomCompagnieAerienneForm = nomCompagnieAerienne;
      }
  %>

  <fieldset>
    <legend>
      <%
          if (idCompagnieAerienneForm.equals(""))
          {
              out.print("Création");
          }
          else
          {
              out.print("Edition");
          }
      %>
      de la compagnie aérienne
    </legend>
    <form action="compagnieAerienne" method="post">
      <input type="hidden" name="action" value="update" />
      <table>
        <tr>
          <td>Id</td>
          <td><input type="text" name="id" readonly
            value="<%=idCompagnieAerienneForm%>"
            <%if (idCompagnieAerienneForm.equals(""))
            {
                out.print("disabled");
            }%>
          /></td>
        </tr>
        <tr>
          <td>Nom</td>
          <td><input type="text" name="nom"
            value="<%=nomCompagnieAerienneForm%>"
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