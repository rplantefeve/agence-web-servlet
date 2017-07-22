<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<%@page import="model.Ville"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Edition de la ville</title>
</head>
<body>
  <%
	    model.Ville ville = (model.Ville) request.getAttribute("ville");
	    /* Tests */
	    Integer idVille = ville.getIdVil();
	    String idVilleForm;
	    if (idVille == 0)
	    {
	        idVilleForm = "";
	    }
	    else
	    {
	        idVilleForm = idVille.toString();
	    }

	    String nomVille = ville.getNom();
	    String nomVilleForm;
	    if (nomVille == null)
	    {
	        nomVilleForm = "";
	    }
	    else
	    {
	        nomVilleForm = nomVille;
	    }

	    
	%>
  <fieldset>
    <legend>
      <%
			    if (idVilleForm.equals(""))
			    {
			        out.print("Création");
			    }
			    else
			    {
			        out.print("Edition");
			    }
			%>

    </legend>
    <form action="ville" method="post">
      <input type="hidden" name="action" value="update" />
      <table>
        <tr>
          <td>Id</td>
          <td><input type="text" name="id" readonly
            value="<%=idVilleForm%>"
            <%if (idVilleForm.equals(""))
            {
                out.print("disabled");
            }%>
          /></td>
        </tr>
        <tr>
          <td>Nom</td>
          <td><input type="text" name="nom"
            value="<%=nomVilleForm%>"
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