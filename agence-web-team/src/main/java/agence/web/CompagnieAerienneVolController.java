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
import dao.CompagnieAerienneVolDao;
import dao.CompagnieAerienneVolDaoSQL;
import dao.VolDao;
import dao.VolDaoSql;
import model.CompagnieAerienne;
import model.CompagnieAerienneVol;
import model.Vol;

@WebServlet("/compagnieAerienneVol")
public class CompagnieAerienneVolController extends HttpServlet
{
    private CompagnieAerienneDao    compagnieAerienneDao    = new CompagnieAerienneDaoSQL();
    private CompagnieAerienneVolDao compagnieAerienneVolDao = new CompagnieAerienneVolDaoSQL();
    private VolDao                  volDao                  = new VolDaoSql();

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
            List<CompagnieAerienneVol> ListCompagnieAerienneVol = this.compagnieAerienneVolDao
                    .findAll();
            // je la charge dans l'objet request
            request.setAttribute("compagnieAerienneVol", ListCompagnieAerienneVol);
            // je prépare le dispatche de la requête vers la page BOs.jsp
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/compagnieAerienneVol.jsp");
            // le controller fait suivre la requête et la réponse à la jsp
            rd.forward(request, response);
        }
        else if (action.equals("add"))
        {
            request.setAttribute("compagnieAerienneVol", new CompagnieAerienneVol());

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/compagnieAerienneVolEdit.jsp");

            rd.forward(request, response);
        }
        else if (action.equals("edit"))
        {
            Integer id = Integer.parseInt(request.getParameter("id"));

            CompagnieAerienneVol compagnieAerienneVol = this.compagnieAerienneVolDao.findById(id);

            request.setAttribute("compagnieAerienneVol", compagnieAerienneVol);

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/compagnieAerienneVolEdit.jsp");

            rd.forward(request, response);

        }
        else if (action.equals("update"))
        {
            String idForm = request.getParameter("id");

            Integer id = null;
            String numero = "";
            Vol vol = null;
            CompagnieAerienne compagnieAerienne = null;
            Short ouvert = 0;

            // si l'id récupéré est non null, on parse
            if (idForm != null)
            {
                id = Integer.parseInt(idForm);
            }
            numero = request.getParameter("numero");
            ouvert = Short.parseShort(request.getParameter("ouvert"));

            if (request.getParameter("idVol") != null)
            {
                vol = this.volDao.findById(Integer.parseInt(request.getParameter("idVol")));
            }
            if (request.getParameter("idCompagnie") != null)
            {
                compagnieAerienne = this.compagnieAerienneDao
                        .findById(Integer.parseInt(request.getParameter("idCompagnie")));
            }

            CompagnieAerienneVol compagnieAerienneVol = null;

            if (id == null)
            {
                compagnieAerienneVol = new CompagnieAerienneVol();
            }
            else
            {
                compagnieAerienneVol = this.compagnieAerienneVolDao.findById(id);
            }

            compagnieAerienneVol.setNumero(numero);
            compagnieAerienneVol.setVol(vol);
            compagnieAerienneVol.setCompagnieAerienne(compagnieAerienne);
            compagnieAerienneVol.setOuvert(ouvert);

            if (id == null)
            {
                this.compagnieAerienneVolDao.create(compagnieAerienneVol);
            }
            else
            {
                this.compagnieAerienneVolDao.update(compagnieAerienneVol);
            }

            request.setAttribute("compagnieAerienneVol", this.compagnieAerienneVolDao.findAll());

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/compagnieAerienneVol.jsp");

            rd.forward(request, response);

        }
        else if (action.equals("delete"))
        {
            Integer id = Integer.parseInt(request.getParameter("id"));

            CompagnieAerienneVol compagnieAerienneVol = this.compagnieAerienneVolDao.findById(id);

            this.compagnieAerienneVolDao.delete(compagnieAerienneVol);

            request.setAttribute("compagnieAerienneVol", this.compagnieAerienneVolDao.findAll());

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/compagnieAerienneVol.jsp");

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
