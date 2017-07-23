<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="model.Vol"%>
<%@page import="model.Aeroport"%>
<%@page import="java.sql.Time"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Edition des vols</title>
</head>
<body>
  <%
	    Vol vol = (Vol) request.getAttribute("vol");
	    /* Tests */
	    Integer idVol = vol.getIdVol();
	    String idVolForm;
	    if (idVol == 0)
	    {
	        idVolForm = "";
	    }
	    else
	    {
	        idVolForm = idVol.toString();
	    }

	    Date dateDepart = vol.getDateDepart();
	    String dateDepartForm;
	    if (dateDepart == null)
	    {
	        dateDepartForm = "jj/mm/aaaa";
	    }
	    else
	    {
	        dateDepartForm = dateDepart.toString();
	    }
	    
	    Date dateArrivee = vol.getDateArrivee();
	    String dateArriveeForm;
	    if (dateArrivee == null)
	    {
	        dateArriveeForm = "jj/mm/aaaa";
	    }
	    else
	    {
	        dateArriveeForm = dateArrivee.toString();
	    }
	    
	    Time heureDepart = vol.getHeureDepart();
	    String heureDepartForm;
	    if (heureDepart == null){
	    	heureDepartForm = "";
	    } else {
	    	heureDepartForm = heureDepart.toString();
	    }
	    
	    Time heureArrivee = vol.getHeureArrivee();
	    String heureArriveeForm;
	    if (heureArrivee == null){
	    	heureArriveeForm = "";
	    } else {
	    	heureArriveeForm = heureArrivee.toString();
	    }

	    Aeroport aeroportDepart = vol.getAeroportDepart();
	    String aeroportDepartForm;
	    if (aeroportDepart == null){
	    	aeroportDepartForm = "";
	    } else{
	    	aeroportDepartForm = Integer.toString(aeroportDepart.getIdAer());
	    }
	    
	    Aeroport aeroportArrivee = vol.getAeroportArrivee();
	    String aeroportArriveeForm;
	    if (aeroportArrivee == null){
	    	aeroportArriveeForm = "";
	    } else{
	    	aeroportArriveeForm = Integer.toString(aeroportArrivee.getIdAer());
	    }
	    
	%>
  <fieldset>
    <legend>
      <%
			    if (idVolForm.equals(""))
			    {
			        out.print("Création");
			    }
			    else
			    {
			        out.print("Edition");
			    }
			%>
      du vol
    </legend>
    <form action="vol" method="post">
      <input type="hidden" name="action" value="update" /> <input
        type="hidden" name="idVol" value="<%=idVolForm%>"
      />
      <table>
        <tr>
          <td>Date de départ</td>
          <td><input type="date" name="dateDepart"
            value="<%=dateDepartForm%>"
          /></td>
        </tr>
        <tr>
          <td>Date d'arrivée</td>
          <td><input type="date" name="dateArrivee"
            value="<%=dateArriveeForm%>"
          /></td>
        </tr>
        <tr>
          <td>Heure de départ</td>
          <td><input type="text" name="heureDepart"
            value="<%=heureDepartForm%>" placeholder="hh:mm:ss"
          /></td>
        </tr>
        <tr>
          <td>Heure d'arrivée</td>
          <td><input type="text" name="heureArrivee"
            value="<%=heureArriveeForm%>" placeholder="hh:mm:ss"
          /></td>
        </tr>
        <tr>
          <td>id Aeroport Depart</td>
          <td><input type="text" name="idAeroportDepart"
            value="<%=aeroportDepartForm%>"
          /></td>
        </tr>
        <tr>
          <td>id Aeroport Arrivée</td>
          <td><input type="text" name="idAeroportArrivee"
            value="<%=aeroportArriveeForm%>"
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