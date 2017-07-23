<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Edition de l'aéroport</title>
<jsp:include page="../include/assets.jsp" />
</head>
<body>
  <jsp:include page="../include/menu.jsp" />
  <fieldset>
    <legend>
      <c:choose>
        <c:when test="${ aeroport.idAer == 0 }">Création</c:when>
        <c:otherwise>Edition</c:otherwise>
      </c:choose>
      de l'aéroport
    </legend>
    <form action="aeroport" method="post">
      <input type="hidden" name="action" value="update" /> <input
        id="id" type="hidden" name="id" value="${ aeroport.idAer }"
      />
      <table>
        <tr>
          <td><label for="nom">Nom :</label></td>
          <td><input id="nom" type="text" name="nom"
            value="${ aeroport.nom }"
          /></td>
        </tr>
        <tr>
          <td colspan="2"><button class="valider" type="submit">Valider</button></td>
        </tr>
      </table>
    </form>
  </fieldset>
</body>
</html>