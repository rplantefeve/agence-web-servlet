<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des adresses</title>
<jsp:include page="../include/assets.jsp" />
</head>
<body>
  <jsp:include page="../include/menu.jsp" />
  <table class="std">
    <tr>
      <th>ID</th>
      <th>Adresse</th>
      <th>Code Postal</th>
      <th>Ville</th>
      <th>Pays</th>
      <th colspan="2">Actions</th>
    </tr>
    <c:forEach items="${ adresses }" var="bo">
      <tr>
        <td>${ bo.idAdd }</td>
        <td>${ bo.adresse }</td>
        <td>${ bo.codePostal }</td>
        <td>${ bo.ville }</td>
        <td>${ bo.pays }</td>
        <td>
          <form name="modify" action="adresse" method="GET">
            <input name="action" value="edit" type="hidden" /> <input
              name="id" value="${ bo.idAdd }" type="hidden"
            /> <input type="submit" id="modify" value="" />
          </form>
        </td>
        <td>
          <form name="delete" action="adresse" method="">
            <input name="action" value="delete" type="hidden" /> <input
              name="id" value="${ bo.idAdd }" type="hidden"
            /> <input type="image" src="./images/deleteIcon.png"
              alt="Delete"
            />
          </form>
        </td>
      </tr>
    </c:forEach>
    <tr class="new">
      <td colspan="7"><a href="adresse?action=add">
          <button class="add">Ajouter une adresse</button>
      </a></td>
    </tr>
  </table>
</body>
</html>