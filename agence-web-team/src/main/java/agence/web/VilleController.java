package agence.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VilleDao;
import dao.VilleDaoSQL;
import model.Ville;

@WebServlet("/ville")
public class VilleController extends HttpServlet
{
    private VilleDao villeDao = new VilleDaoSQL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // on teste si le paramètre action est présent dans l'url
        String action = request.getParameter("action") != null ? request.getParameter("action")
                : "list";
        // si l'action demandée par le user est la liste des BO,
        if (action.equals("list"))
        {
            // je récupère la liste des BO
            List<Ville> villes = this.villeDao.findAll();
            // je la charge dans l'objet request
            request.setAttribute("ville", villes);
            // je prépare le dispatche de la requête vers la page BOs.jsp
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/villes.jsp");
            // le controller fait suivre la requête et la réponse à la jsp
            rd.forward(request, response);
        }
        else if (action.equals("add"))
        {
            request.setAttribute("ville", new Ville());

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/villeEdit.jsp");

            rd.forward(request, response);
        }
        else if (action.equals("edit"))
        {
            Integer id = Integer.parseInt(request.getParameter("id"));

            Ville ville = this.villeDao.findById(id);

            request.setAttribute("ville", ville);

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/villeEdit.jsp");

            rd.forward(request, response);

        }
        else if (action.equals("update"))
        {
            String idForm = request.getParameter("id");

            Integer id = null;
            String nom = "";
            if (idForm != null)
            {
                id = Integer.parseInt(idForm);
            }
            nom = request.getParameter("nom");

            Ville ville = null;

            if (id == null)
            {
                ville = new Ville();
            }
            else
            {
                ville = this.villeDao.findById(id);
            }

            ville.setNom(nom);

            if (id == null)
            {
                this.villeDao.create(ville);
            }
            else
            {
                this.villeDao.update(ville);
            }

            request.setAttribute("ville", this.villeDao.findAll());

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/villes.jsp");

            rd.forward(request, response);

        }
        else if (action.equals("delete"))
        {
            Integer id = Integer.parseInt(request.getParameter("id"));

            Ville ville = this.villeDao.findById(id);

            this.villeDao.delete(ville);

            request.setAttribute("ville", this.villeDao.findAll());

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/villes.jsp");

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
