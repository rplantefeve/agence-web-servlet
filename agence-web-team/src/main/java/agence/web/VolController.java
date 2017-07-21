package agence.web;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AeroportDao;
import dao.AeroportDaoSQL;
import dao.VolDao;
import dao.VolDaoSql;
import model.Aeroport;
import model.Vol;

@WebServlet("/vol")
public class VolController extends HttpServlet
{
    private AeroportDao aeroportDao = new AeroportDaoSQL();
    private VolDao      volDao      = new VolDaoSql();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // si on a pas d'action, on demande la liste
        String action = request.getParameter("action") != null ? request.getParameter("action")
                : "list";
        // si l'action demandée est la liste :
        if (action.equals("list"))
        {
            // je demande la liste des BO
            List<Vol> vols = this.volDao.findAll();
            // je la charge dans l'objet request
            request.setAttribute("vol", vols);
            // je dispatche la requête vers ma page elève.jsp
            RequestDispatcher rd = request.getRequestDispatcher("vol.jsp");
            // le ctrl fait suivre la requête et la réponse à la jsp
            rd.forward(request, response);
        }
        else if (action.equals("add"))
        {
            request.setAttribute("vol", new Vol());

            RequestDispatcher rd = request.getRequestDispatcher("volEdit.jsp");

            rd.forward(request, response);
        }
        else if (action.equals("edit"))
        {
            Integer id = Integer.parseInt(request.getParameter("idVol"));

            Vol vol = this.volDao.findById(id);

            request.setAttribute("vol", vol);

            RequestDispatcher rd = request.getRequestDispatcher("volEdit.jsp");

            rd.forward(request, response);

        }
        else if (action.equals("update"))
        {
            // permet de convertir la récupération des données qui se font en
            // String en date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            // permet de convertir la récupération des données qui se font en
            // String en heure
            SimpleDateFormat heure = new SimpleDateFormat("HH:mm:ss");
            String idForm = request.getParameter("idVol");

            Date dateDepart = null;
            Date dateArrivee = null;
            Time heureDepart = null;
            Time heureArrivee = null;
            Integer idVol = null;
            Aeroport aeroportDepart = null;
            Aeroport aeroportArrivee = null;

            try
            {
                // si l'id récupéré est non null, on parse
                if ((idForm != null) && !idForm.equals(""))
                {
                    idVol = Integer.parseInt(idForm);
                }
                dateDepart = sdf.parse(request.getParameter("dateDepart"));
                dateArrivee = sdf.parse(request.getParameter("dateArrivee"));
                // cherche pas, ça marche (normalement, j'ai pas encore testé)
                heureDepart = new java.sql.Time(
                        heure.parse(request.getParameter("heureDepart")).getTime());
                heureArrivee = new java.sql.Time(
                        heure.parse(request.getParameter("heureArrivee")).getTime());
                // On a l'id de l'aeroport, mais on veut stocker dans la classe
                // un aeroport, pas un id
                if (request.getParameter("idAeroportDepart") != null)
                {
                    aeroportDepart = this.aeroportDao
                            .findById(Integer.parseInt(request.getParameter("idAeroportDepart")));
                }
                if (request.getParameter("idAeroportArrivee") != null)
                {
                    aeroportArrivee = this.aeroportDao
                            .findById(Integer.parseInt(request.getParameter("idAeroportArrivee")));
                }
            }
            catch (NumberFormatException e)
            {
                e.printStackTrace();
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }

            Vol vol = null;

            if (idVol == null)
            {
                vol = new Vol();
            }
            else
            {
                vol = this.volDao.findById(idVol);
            }

            vol.setDateArrivee(dateArrivee);
            vol.setDateDepart(dateDepart);
            vol.setHeureArrivee(heureArrivee);
            vol.setHeureDepart(heureDepart);
            vol.setAeroportArrivee(aeroportArrivee);
            vol.setAeroportDepart(aeroportDepart);

            if (idVol == null)
            {
                this.volDao.create(vol);
            }
            else
            {
                this.volDao.update(vol);
            }

            request.setAttribute("vol", this.volDao.findAll());

            RequestDispatcher rd = request.getRequestDispatcher("vol.jsp");

            rd.forward(request, response);

        }
        else if (action.equals("delete"))
        {
            Integer idVol = Integer.parseInt(request.getParameter("idVol"));

            Vol vol = this.volDao.findById(idVol);

            this.volDao.delete(vol);

            request.setAttribute("vol", this.volDao.findAll());

            RequestDispatcher rd = request.getRequestDispatcher("vol.jsp");

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
