package agence.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDao;
import dao.LoginDaoSql;
import model.Login;

@WebServlet("/login")
public class LoginController extends HttpServlet
{
    private LoginDao loginDao = new LoginDaoSql();

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
            // je récupère la liste des BO
            List<Login> logins = this.loginDao.findAll();
            // je la charge dans l'obj request
            request.setAttribute("logins", logins);
            // je dispache la requête vers la page bos.jsp
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/logins.jsp");
            // le ctrl fait suivre la requête et la réponse à la jsp
            rd.forward(request, response);

        }
        else if (action.equals("add"))
        {
            request.setAttribute("login", new Login());

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/loginEdit.jsp");

            rd.forward(request, response);
        }
        else if (action.equals("edit"))
        {
            Integer id = Integer.parseInt(request.getParameter("id"));

            Login login = this.loginDao.findById(id);

            request.setAttribute("login", login);

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/loginEdit.jsp");

            rd.forward(request, response);

        }
        else if (action.equals("update"))
        {
            String idForm = request.getParameter("id");

            Integer id = null;
            String login = "";
            String mdp = "";
            Integer admin = null;

            try
            {
                // si l'id récupéré est non null, on parse
                if ((idForm != null) && !idForm.equals(""))
                {
                    id = Integer.parseInt(idForm);
                }
                login = request.getParameter("login");
                mdp = request.getParameter("mot de passe");
                admin = Integer.parseInt(request.getParameter("admin"));

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            Login log = null;

            if (id == null)
            {
                log = new Login();
            }
            else
            {
                log = this.loginDao.findById(id);
            }

            log.setLogin(login);
            log.setMotDePasse(mdp);
            log.setAdmin(admin);

            if (id == null)
            {
                this.loginDao.create(log);
            }
            else
            {
                this.loginDao.update(log);
            }

            request.setAttribute("logins", this.loginDao.findAll());

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/logins.jsp");

            rd.forward(request, response);

        }
        else if (action.equals("delete"))
        {
            Integer id = Integer.parseInt(request.getParameter("id"));

            Login login = this.loginDao.findById(id);

            this.loginDao.delete(login);

            request.setAttribute("logins", this.loginDao.findAll());

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/logins.jsp");

            rd.forward(request, response);
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
