package agence.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdresseDao;
import dao.AdresseDaoSql;
import dao.PassagerDao;
import dao.PassagerDaoSQL;
import model.Passager;

@WebServlet("/passager")
public class PassagerController extends HttpServlet
{

    private AdresseDao  adresseDao  = new AdresseDaoSql();
    private PassagerDao passagerDao = new PassagerDaoSQL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // on teste si le parametre action est present dasn l'URL
        String action = request.getParameter("action") != null ? request.getParameter("action")
                : "list";
        // si l'action demandé par le user est la liste des eleves
        if (action.equals("list"))
        { // je recupere la liste des eleves
            List<Passager> passagers = this.passagerDao.findAll();
            // je la charge dans l'objet request
            request.setAttribute("passagers", passagers);
            // je dispache la requete vers la page elevesjsp
            RequestDispatcher rd = request.getRequestDispatcher("passagers.jsp");
            // le ctrl fait suivre la requete et la reponse à la jsp
            rd.forward(request, response);
        }
        else if (action.equals("add"))
        {
            request.setAttribute("passager", new Passager());

            RequestDispatcher rd = request.getRequestDispatcher("passagerEdit.jsp");

            rd.forward(request, response);
        }
        else if (action.equals("edit"))
        {
            Integer id = Integer.parseInt(request.getParameter("id"));

            Passager passager = this.passagerDao.findById(id);

            request.setAttribute("passager", passager);

            RequestDispatcher rd = request.getRequestDispatcher("passagerEdit.jsp");

            rd.forward(request, response);

        }
        else if (action.equals("update"))
        {
            String idForm = request.getParameter("id");

            Integer id = null;
            Integer idAdd = null;
            String nom = "";
            String prenom = "";
            try
            {
                // si l'id récupéré est non null, on parse
                if ((idForm != null) && !idForm.equals(""))
                {
                    id = Integer.parseInt(idForm);
                }
                nom = request.getParameter("nom");
                prenom = request.getParameter("prenom");
                idAdd = Integer.parseInt(request.getParameter("adresse"));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            Passager passager = null;

            if (id == null)
            {
                passager = new Passager();
            }
            else
            {
                passager = this.passagerDao.findById(id);
            }

            passager.setNom(nom);
            passager.setPrenom(prenom);
            passager.setAdresse(this.adresseDao.findById(idAdd));

            if (id == null)
            {
                this.passagerDao.create(passager);
            }
            else
            {
                this.passagerDao.update(passager);
            }

            request.setAttribute("passagers", this.passagerDao.findAll());

            RequestDispatcher rd = request.getRequestDispatcher("passagers.jsp");

            rd.forward(request, response);

        }
        else if (action.equals("delete"))
        {
            Integer id = Integer.parseInt(request.getParameter("id"));

            Passager passager = this.passagerDao.findById(id);

            this.passagerDao.delete(passager);

            request.setAttribute("passagers", this.passagerDao.findAll());

            RequestDispatcher rd = request.getRequestDispatcher("passagers.jsp");

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
