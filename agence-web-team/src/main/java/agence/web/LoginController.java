package agence.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDaoSql;
import model.Login;

@WebServlet("/login")
public class LoginController extends CrudController<Login>
{
    /**
     * 
     */
    public LoginController()
    {
        super("login");
        this.dao = new LoginDaoSql();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        this.doGetCrud(request, response, new Login(), Login.parameterTypes);
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

    /*
     * (non-Javadoc)
     * 
     * @see agence.web.CrudController#hydrateBO(java.util.Map, java.lang.Object)
     */
    @Override
    protected Login hydrateBO(Map<String, Object> parameterValues, Login bo)
    {
        Login newLogin;
        if (bo != null)
        {
            newLogin = bo;
        }
        else
        {
            newLogin = new Login();
        }

        // hydratation de l'objet métier avec les nouvelles valeurs
        // je récupère le type du champ
        newLogin.setLogin((String) parameterValues.get("login"));
        newLogin.setMotDePasse((String) parameterValues.get("motDePasse"));
        newLogin.setAdmin((Integer) parameterValues.get("admin"));
        // retourne l'objet
        return newLogin;
    }

}
