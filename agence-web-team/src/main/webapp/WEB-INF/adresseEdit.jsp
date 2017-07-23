<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<%@ page import="model.Adresse"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Edition de l'adresse</title>
<jsp:include page="../include/assets.jsp" />
</head>
<body>
  <jsp:include page="../include/menu.jsp" />
  <fieldset>
    <legend>
      <c:choose>
        <c:when test="${ adresse.idAdd == 0 }">Création</c:when>
        <c:otherwise>Edition</c:otherwise>
      </c:choose>
      de l'adresse
    </legend>
    <form action="adresse" method="post">
      <input type="hidden" name="action" value="update" /> <input
        type="hidden" name="id" value="${ adresse.idAdd }"
      />
      <table>
        <tr>
          <td><label>Adresse</label></td>
          <td><input type="text" name="adresse" maxlength="255"
            value="${ adresse.adresse }"
          /></td>
        </tr>
        <tr>
          <td><label>Code postal</label></td>
          <td><input type="text" name="codePostal" size="5" maxlength="5"
            value="${ adresse.codePostal }"
          /></td>
        </tr>
        <tr>
          <td><label>Ville</label></td>
          <td><input type="text" name="ville" maxlength="163"
            value="${ adresse.ville }"
          /></td>
        </tr>
        <tr>
          <td><label>Pays</label></td>
          <td><input type="text" name="pays" maxlength="31"
            value="${ adresse.pays }"
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