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
      Integer idLog = login.getId();
      String idLogForm;
      if (idLog == 0)
      {
          idLogForm = "";
      }
      else
      {
          idLogForm = idLog.toString();
      }

      String loginLog = login.getLogin();
      String loginLogForm;
      if (loginLog == null)
      {
          loginLogForm = "";
      }
      else
      {
          loginLogForm = loginLog;
      }

      String mdpLog = login.getMotDePasse();
      String mdpLogForm;
      if (mdpLog == null)
      {
          mdpLogForm = "";
      }
      else
      {
          mdpLogForm = mdpLog;
      }
      Integer adminLog = login.getAdmin();
      String adminLogForm = adminLog.toString();
  %>
  <fieldset>
    <legend>
      <%
          if (idLogForm.equals(""))
          {
              out.print("Création");
          }
          else
          {
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
          <td><input type="text" name="login" maxlength="50"
            value="<%=loginLogForm%>"
          /></td>
        </tr>
        <tr>
          <td>Mot de Passe</td>
          <td><input type="text" name="motDePasse" maxlength="100"
            value="<%=mdpLogForm%>"
          /></td>
        </tr>
        <tr>
          <td>Admin?</td>
          <td><select name="admin">
              <option value="0"
                <%if (adminLogForm.equals("0"))
                out.print("selected");%>
              >Non</option>
              <option value="1"
                <%if (adminLogForm.equals("1"))
                out.print("selected");%>
              >Oui</option>
          </select></td>
        </tr>

        <tr>
          <td colspan="2"><input type="submit" value="Valider" /></td>
        </tr>
      </table>
    </form>
  </fieldset>
</body>
</html>