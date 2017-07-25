<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<%@ page import="java.util.List"%>
<%@ page import="model.Vol"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des vols</title>
<jsp:include page="../include/assets.jsp" />
</head>
<body>
  <%@include file="../include/menu.jsp"%>
  <table class="std">
    <tr>
      <th>IdVol</th>
      <th>Date de départ</th>
      <th>Date d'arrivée</th>
      <th>Heure de départ</th>
      <th>Heure d'arrivée</th>
      <th>Aéroport de départ</th>
      <th>Aéroport d'arrivée</th>
      <th colspan="2">Actions</th>
    </tr>
    <%
        List<Vol> vols = (List<Vol>) request.getAttribute("vol");
        for (Vol vol : vols)
        {
    %>
    <tr>
      <td>
        <%
            out.print(vol.getIdVol());
        %>
      </td>
      <td>
        <%
            out.print(vol.getDateDepart());
        %>
      </td>
      <td>
        <%
            out.print(vol.getDateArrivee());
        %>
      </td>
      <td>
        <%
            out.print(vol.getHeureDepart());
        %>
      </td>
      <td>
        <%
            out.print(vol.getHeureArrivee());
        %>
      </td>
      <td>
        <%
            if (vol.getAeroportDepart() != null)
                {
                    out.print(vol.getAeroportDepart().getNom());
                }
                else
                {
                    out.print("Non renseignée");
                }
        %>
      </td>
      <td>
        <%
            if (vol.getAeroportArrivee() != null)
                {
                    out.print(vol.getAeroportArrivee().getNom());
                }
                else
                {
                    out.print("Non renseignée");
                }
        %>
      </td>
      <td>
        <form name="modify" action="vol" method="GET">
          <input name="action" value="edit" type="hidden" /> <input
            name="idVol" value="<%=vol.getIdVol()%>" type="hidden"
          /> <input type="submit" id="modify" value="" />
        </form>
      </td>
      <td>
        <form name="delete" action="vol" method="get">
          <input name="action" value="delete" type="hidden" /> <input
            name="idVol" value="<%=vol.getIdVol()%>" type="hidden"
          /> <input type="image" src="./images/deleteIcon.png"
            alt="Delete"
          />
        </form>
      </td>
    </tr>
    <%
        }
    %>
    <tr class="new">
      <td colspan="9"><a href="vol?action=add"><button
            class="add"
          >Ajouter un vol</button></a></td>
    </tr>
  </table>

</body>
</html>