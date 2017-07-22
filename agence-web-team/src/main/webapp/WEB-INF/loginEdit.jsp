<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
<%@ page import="model.Login"%>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Creation Logins</title>
</head>
<body>
  <%
		model.Login login = (model.Login) request.getAttribute("login");
		/* Tests */
		Integer idLog = login.getIdLog();
		String idLogForm;
		if (idLog == 0) {
			idLogForm = "";
		} else {
			idLogForm = idLog.toString();
		}

		String loginLog = login.getLogin();
		String loginLogForm;
		if (loginLog == null) {
			loginLogForm = "";
		} else {
			loginLogForm = loginLog;
		}

		String mdpLog = login.getMotDePasse();
		String mdpLogForm;
		if (mdpLog == null) {
			mdpLogForm = "";
		} else {
			mdpLogForm = mdpLog;
		}
		Integer adminLog = login.getAdmin();
		String adminLogForm = adminLog.toString();
	%>
  <fieldset>
    <legend>
      <%
				if (idLogForm.equals("")) {
					out.print("Création");
				} else {
					out.print("Edition");
				}
			%>
      Login
    </legend>
    <form action="login" method="post">
      <input type="hidden" name="action" value="update" /> <input
        type="hidden" name="id" value="<%=idLogForm%>"
      />
      <table>
        <tr>
          <td>Login</td>
          <td><input type="text" name="login"
            value="<%=loginLogForm%>"
          /></td>
        </tr>
        <tr>
          <td>Mot de Passe</td>
          <td><input type="text" name="mot de passe"
            value="<%=mdpLogForm%>"
          /></td>
        </tr>
        <tr>
          <td>Admin</td>
          <td><input type="text" name="admin"
            value="<%=adminLogForm%>"
            placeholder="0 pour non, 1 pour oui"
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