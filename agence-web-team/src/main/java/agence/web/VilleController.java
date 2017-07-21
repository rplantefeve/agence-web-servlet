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
        // on teste si le param�tre action est pr�sent dans l'url
        String action = request.getParameter("action") != null ? request.getParameter("action")
                : "list";
        // si l'action demand�e par le user est la liste des �l�ves,
        if (action.equals("list"))
        {
            // je r�cup�re la liste des �l�ves
            List<Ville> villes = this.villeDao.findAll();
            // je la charge dans l'objet request
            request.setAttribute("ville", villes);
            // je pr�pare le dispatche de la requ�te vers la page eleves.jsp
            RequestDispatcher rd = request.getRequestDispatcher("villes.jsp");
            // le controller fait suivre la requ�te et la r�ponse � la jsp
            rd.forward(request, response);
        }
        else if (action.equals("add"))
        {
            request.setAttribute("ville", new Ville());

            RequestDispatcher rd = request.getRequestDispatcher("villeEdit.jsp");

            rd.forward(request, response);
        }
        else if (action.equals("edit"))
        {
            Integer id = Integer.parseInt(request.getParameter("id"));

            Ville ville = this.villeDao.findById(id);

            request.setAttribute("ville", ville);

            RequestDispatcher rd = request.getRequestDispatcher("villeEdit.jsp");

            rd.forward(request, response);

        }
        else if (action.equals("update"))
        {
            // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String idForm = request.getParameter("id");

            // Date dtNais = null;
            Integer id = null;
            String nom = "";
            // String prenom = "";
            // float note = 0.0f;
            // Titre titre = null;

            // try
            // {
            // si l'id r�cup�r� est non null, on parse
            if (idForm != null)
            {
                id = Integer.parseInt(idForm);
            }
            nom = request.getParameter("nom");
            // prenom = request.getParameter("prenom");
            // note = Float.parseFloat(request.getParameter("note"));
            // dtNais = sdf.parse(request.getParameter("dtNais"));
            // titre= titre.permissiveValueOf(request.getParameter("titre"));
            // }

            // catch (ParseException e)
            // {
            // e.printStackTrace();
            // }

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
            // eleve.setPrenom(prenom);
            // eleve.setDtNais(dtNais);
            // eleve.setNote(note);
            // eleve.setTitre(titre);

            if (id == null)
            {
                this.villeDao.create(ville);
            }
            else
            {
                this.villeDao.update(ville);
            }

            request.setAttribute("ville", this.villeDao.findAll());

            RequestDispatcher rd = request.getRequestDispatcher("villes.jsp");

            rd.forward(request, response);

        }
        else if (action.equals("delete"))
        {
            Integer id = Integer.parseInt(request.getParameter("id"));

            Ville ville = this.villeDao.findById(id);

            this.villeDao.delete(ville);

            request.setAttribute("ville", this.villeDao.findAll());

            RequestDispatcher rd = request.getRequestDispatcher("villes.jsp");

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
