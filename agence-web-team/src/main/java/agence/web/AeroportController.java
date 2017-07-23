package agence.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AeroportDaoSQL;
import model.Aeroport;

@WebServlet("/aeroport")
public class AeroportController extends CrudController<Aeroport>
{
    /**
     * Constructeur par défaut qui initialise le chaîne clef à "aéroport", puis
     * initialise le DAO utile pour toutes les opérations CRUD
     */
    public AeroportController()
    {
        super("aeroport");
        this.dao = new AeroportDaoSQL();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        this.doGetCrud(request, response, new Aeroport(), Aeroport.parameterTypes);
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
    protected Aeroport hydrateBO(Map<String, Object> parameterValues, Aeroport bo)
    {
        Aeroport newBo;
        if (bo != null)
        {
            newBo = bo;
        }
        else
        {
            newBo = new Aeroport();
        }
        newBo.setNom((String) parameterValues.get("nom"));
        return newBo;
    }

}
