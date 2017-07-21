<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Edition de l'aéroport</title>
</head>
<body>


  <%
      model.Aeroport aeroport = (model.Aeroport) request.getAttribute("aeroport");
      /* Tests */
      Integer idAero = aeroport.getIdAer();
      String idAeroForm;
      if (idAero == 0)
      {
          idAeroForm = "";
      }
      else
      {
          idAeroForm = idAero.toString();
      }

      String nomAero = aeroport.getNom();
      String nomAeroForm;
      if (nomAero == null)
      {
          nomAeroForm = "";
      }
      else
      {
          nomAeroForm = nomAero;
      }
  %>
  <fieldset>
    <legend>
      <%
          if (idAeroForm.equals(""))
          {
              out.print("Création");
          }
          else
          {
              out.print("Edition");
          }
      %>
      de l'aéroport
    </legend>
    <form action="aeroport" method="post">
      <input type="hidden" name="action" value="update" />
      <table>
        <tr>
          <td>Id</td>
          <td><input type="text" name="idAero" readonly
            value="<%=idAeroForm%>"
            <%if (idAeroForm.equals(""))
            {
                out.print("disabled");
            }%>
          /></td>
        </tr>
        <tr>
          <td>Nom</td>
          <td><input type="text" name="nom"
            value="<%=nomAeroForm%>"
          /></td>

          <td colspan="2"><input type="submit" value="Valider" /></td>
        </tr>
      </table>
    </form>
  </fieldset>

</body>
</html>