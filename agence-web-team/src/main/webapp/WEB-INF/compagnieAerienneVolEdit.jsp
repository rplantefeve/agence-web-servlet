<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<%@page import="model.CompagnieAerienne"%>
<%@page import="model.Vol"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Edition de la liaison</title>
</head>
<body>
  <%
      model.CompagnieAerienneVol compagnieAerienneVol = (model.CompagnieAerienneVol) request
              .getAttribute("compagnieAerienneVol");
      /* Tests */
      Integer idCompagnieVol = compagnieAerienneVol.getId();
      String idCompagnieAerienneVolForm;
      if (idCompagnieVol == 0)
      {
          idCompagnieAerienneVolForm = "";
      }
      else
      {
          idCompagnieAerienneVolForm = idCompagnieVol.toString();
      }

      String numero = compagnieAerienneVol.getNumero();
      String numeroForm;
      if (numero == null)
      {
          numeroForm = "";
      }
      else
      {
          numeroForm = numero;
      }

      CompagnieAerienne compagnieAerienne = compagnieAerienneVol.getCompagnieAerienne();
      String compagnieForm;
      if (compagnieAerienne == null)
      {
          compagnieForm = "";
      }
      else
      {
          compagnieForm = Integer.toString(compagnieAerienne.getId());
      }

      Vol vol = compagnieAerienneVol.getVol();
      String volForm;
      if (vol == null)
      {
          volForm = "";
      }
      else
      {
          volForm = Integer.toString(vol.getIdVol());
      }

      Short ouvertForm = compagnieAerienneVol.getOuvert();
      
  %>
  <fieldset>
    <legend>
      <%
          if (idCompagnieAerienneVolForm.equals(""))
          {
              out.print("Création");
          }
          else
          {
              out.print("Edition");
          }
      %>

    </legend>
    <form action="compagnieAerienneVol" method="post">
      <input type="hidden" name="action" value="update" />
      <table>
        <tr>
          <td>Id</td>
          <td><input type="text" name="id"
            value="<%=idCompagnieAerienneVolForm%>"
            <%if (idCompagnieAerienneVolForm.equals(""))
            {
                out.print("disabled");
            }%>
          /></td>
        </tr>
        <tr>
          <td>Numero</td>
          <td><input type="text" name="numero"
            value="<%=numeroForm%>"
          /></td>
        </tr>
        <tr>
          <td>Compagnie</td>
          <td><input type="text" name="idCompagnie"
            value="<%=compagnieForm%>"
          /></td>
        </tr>
        <tr>
          <td>Vol</td>
          <td><input type="text" name="idVol" value="<%=volForm%>" /></td>
        </tr>
        <tr>
          <td>Ouvert</td>
          <td><input type="text" name="ouvert"
            value="<%=ouvertForm%>"
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