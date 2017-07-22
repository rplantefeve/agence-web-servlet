package agence.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AeroportDao;
import dao.AeroportDaoSQL;
import model.Aeroport;

@WebServlet("/aeroport")
public class AeroportController extends HttpServlet
{
    private AeroportDao aeroportDao = new AeroportDaoSQL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // on teste si le parametre action est present dans l'url
        String action = request.getParameter("action") != null ? request.getParameter("action")
                : "list";
        // si l'action demandé par le user est la liste des BOs
        if (action.equals("list"))
        {
            // je recupere la liste des aeroports
            List<Aeroport> aeroports = this.aeroportDao.findAll();
            // je charge dans l'objet request
            request.setAttribute("aeroport", aeroports);
            // je dispatche la requete vers ma page BOs.jsp
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/aeroport.jsp");
            // le ctrl fait suivre la requete et la reponse à la jsp
            rd.forward(request, response);
        }
        else if (action.equals("add"))
        {
            request.setAttribute("aeroport", new Aeroport());

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/aeroportEdit.jsp");

            rd.forward(request, response);
        }
        else if (action.equals("edit"))
        {
            Integer idAero = Integer.parseInt(request.getParameter("idAero"));

            Aeroport aeroport = this.aeroportDao.findById(idAero);

            request.setAttribute("aeroport", aeroport);

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/aeroportEdit.jsp");

            rd.forward(request, response);

        }
        else if (action.equals("update"))
        {
            String idForm = request.getParameter("idAero");

            Integer idAero = null;
            String nom = "";

            // try
            // {
            // si l'id r�cup�r� est non null, on parse
            if (idForm != null)
            {
                idAero = Integer.parseInt(idForm);
            }
            nom = request.getParameter("nom");

            Aeroport aeroport = null;

            if (idAero == null)
            {
                aeroport = new Aeroport();
            }
            else
            {
                aeroport = this.aeroportDao.findById(idAero);
            }

            aeroport.setNom(nom);

            if (idAero == null)
            {
                this.aeroportDao.create(aeroport);
            }
            else
            {
                this.aeroportDao.update(aeroport);
            }

            request.setAttribute("aeroport", this.aeroportDao.findAll());

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/aeroport.jsp");

            rd.forward(request, response);

        }
        else if (action.equals("delete"))
        {
            Integer idAero = Integer.parseInt(request.getParameter("idAero"));

            Aeroport aeroport = this.aeroportDao.findById(idAero);

            this.aeroportDao.delete(aeroport);

            request.setAttribute("aeroport", this.aeroportDao.findAll());

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/aeroport.jsp");

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
