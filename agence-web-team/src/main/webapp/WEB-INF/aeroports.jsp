<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des aéroports</title>
<jsp:include page="../include/assets.jsp" />
</head>
<body>
  <jsp:include page="../include/menu.jsp" />
  <table class="std">
    <tr>
      <th>ID</th>
      <th>Nom</th>
      <th colspan="2">Actions</th>
    </tr>
    <c:forEach items="${ aeroports }" var="aeroport">
      <tr>
        <td><c:out value="${ aeroport.idAer }" /></td>
        <td><c:out value="${ aeroport.nom }" /></td>
        <td>
          <form name="modify" action="aeroport" method="get">
            <input name="action" value="edit" type="hidden" /> <input
              name="id" value="${ aeroport.idAer }" type="hidden"
            /> <input type="submit" id="modify" value="" />
          </form>
        </td>
        <td>
          <form name="delete" action="aeroport" method="get">
            <input name="action" value="delete" type="hidden" /> <input
              name="id" value="${ aeroport.idAer }" type="hidden"
            /> <input type="image" src="./images/deleteIcon.png"
              alt="Delete"
            />
          </form>
        </td>
      </tr>
    </c:forEach>
    <tr class="new">
      <td colspan="7"><a href="aeroport?action=add">
          <button class="add">Ajouter un aéroport</button>
      </a></td>
    </tr>
  </table>
</body>
</html>