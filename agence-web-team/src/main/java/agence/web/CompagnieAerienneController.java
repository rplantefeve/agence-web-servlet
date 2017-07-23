/**
 * 
 */
package agence.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CompagnieAerienneDao;
import dao.CompagnieAerienneDaoSQL;
import model.CompagnieAerienne;

/**
 * @author Thibault
 *
 */

@WebServlet("/compagnieAerienne")
public class CompagnieAerienneController extends HttpServlet
{
    private CompagnieAerienneDao compagnieAerienneDao = new CompagnieAerienneDaoSQL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // Test si le paramètre action est présent dans l'url
        String action = request.getParameter("action") != null ? request.getParameter("action")
                : "list";
        // Si l'action demandée par le user est la liste des BO
        if (action.equals("list"))
        {
            // je récupère la liste des BO
            List<CompagnieAerienne> listCompagnieAerienne = this.compagnieAerienneDao.findAll();
            // je la charge dans l'objet request
            request.setAttribute("CompagnieAerienne", listCompagnieAerienne);
            // je prépare le dispatche la requete vers la page BOs.jsp
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/compagnieAeriennes.jsp");
            // le ctrl fait suivre la requete et la réponse à la jsp
            rd.forward(request, response);
        }
        else if (action.equals("add"))
        {
            request.setAttribute("CompagnieAerienne", new CompagnieAerienne());

            RequestDispatcher rd = request
                    .getRequestDispatcher("WEB-INF/compagnieAerienneEdit.jsp");

            rd.forward(request, response);
        }
        else if (action.equals("edit"))
        {
            Integer id = Integer.parseInt(request.getParameter("id"));

            CompagnieAerienne objCompagnieAerienne = this.compagnieAerienneDao.findById(id);

            request.setAttribute("CompagnieAerienne", objCompagnieAerienne);

            RequestDispatcher rd = request
                    .getRequestDispatcher("WEB-INF/compagnieAerienneEdit.jsp");

            rd.forward(request, response);

        }
        else if (action.equals("update"))
        {

            String idForm = request.getParameter("id");

            Integer id = null;
            String nom = "";

            // try {
            // si l'id r�cup�r� est non null, on parse
            if (idForm != null)
            {
                id = Integer.parseInt(idForm);
            }
            nom = request.getParameter("nom");

            // } catch (ParseException e) {
            // e.printStackTrace();
            // }

            CompagnieAerienne objCompagnieAerienne = null;

            if (id == null)
            {
                objCompagnieAerienne = new CompagnieAerienne();
            }
            else
            {
                objCompagnieAerienne = this.compagnieAerienneDao.findById(id);
            }

            objCompagnieAerienne.setNom(nom);

            if (id == null)
            {
                this.compagnieAerienneDao.create(objCompagnieAerienne);
            }
            else
            {
                this.compagnieAerienneDao.update(objCompagnieAerienne);
            }

            request.setAttribute("CompagnieAerienne", this.compagnieAerienneDao.findAll());

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/compagnieAeriennes.jsp");

            rd.forward(request, response);

        }
        else if (action.equals("delete"))
        {
            Integer id = Integer.parseInt(request.getParameter("id"));

            CompagnieAerienne eleve = this.compagnieAerienneDao.findById(id);

            this.compagnieAerienneDao.delete(eleve);

            request.setAttribute("CompagnieAerienne", this.compagnieAerienneDao.findAll());

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/compagnieAeriennes.jsp");

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
