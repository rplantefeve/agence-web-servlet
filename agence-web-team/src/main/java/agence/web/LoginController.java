package agence.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDao;
import dao.LoginDaoSql;
import model.Login;

@WebServlet("/login")
public class LoginController extends CrudController
{
    private final String attributeName;
    private final String jspEdit;
    private final String jspListBOs;
    private final String listAttributeName;
    private LoginDao     loginDao = new LoginDaoSql();

    /**
     * 
     */
    public LoginController()
    {
        this.jspListBOs = "logins.jsp";
        this.jspEdit = "loginEdit.jsp";
        this.attributeName = "login";
        this.listAttributeName = "logins";

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        // on test si le param action des présent dans l'url
        String action = request.getParameter("action") != null ? request.getParameter("action")
                : "list";
        // si l'action demandée par le user est la liste des login

        if (action.equals("list"))
        {
            this.listAction(request, response, this.jspListBOs, this.loginDao,
                    this.listAttributeName);

        }
        else
        {
            if (action.equals("add"))
            {
                this.addAction(request, response, new Login(), this.attributeName, this.jspEdit);
            }
            else if (action.equals("edit"))
            {
                this.editAction(request, response, this.jspEdit, this.loginDao, this.attributeName);

            }
            else if (action.equals("update"))
            {
                Map<String, String[]> params = request.getParameterMap();

                Map<String, Object> parameterValues = this.extractParameterValues(params,
                        Login.parameterTypes);

                Integer id = null;
                Login bo = new Login();

                id = this.getBoIdIfSet(params);
                // si l'id n'est pas null, récupération des infos
                if (id != null)
                {
                    bo = this.loginDao.findById(id);
                }

                // hydratation de l'objet métier avec les nouvelles valeurs
                // je récupère le type du champ
                bo.setLogin((String) parameterValues.get("login"));
                bo.setMotDePasse((String) parameterValues.get("motDePasse"));
                bo.setAdmin((Integer) parameterValues.get("admin"));

                if (id == null)
                {
                    this.loginDao.create(bo);
                }
                else
                {
                    this.loginDao.update(bo);
                }

                this.listAction(request, response, this.jspListBOs, this.loginDao,
                        this.listAttributeName);

            }
            else if (action.equals("delete"))
            {
                this.deleteAction(request, response, this.loginDao, this.jspListBOs,
                        this.listAttributeName);
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        this.doGet(request, response);
    }

}
