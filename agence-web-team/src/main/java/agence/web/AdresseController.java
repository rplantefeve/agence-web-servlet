package agence.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdresseDaoSql;
import model.Adresse;

@WebServlet("/adresse")
public class AdresseController extends CrudController<Adresse>
{

    public AdresseController()
    {
        super("adresse");
        this.dao = new AdresseDaoSql();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        this.doGetCrud(request, response, new Adresse(), Adresse.parameterTypes);
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
    protected Adresse hydrateBO(Map<String, Object> parameterValues, Adresse bo)
    {
        Adresse newBo;
        if (bo != null)
        {
            newBo = bo;
        }
        else
        {
            newBo = new Adresse();
        }
        newBo.setAdresse((String) parameterValues.get("adresse"));
        newBo.setCodePostal((String) parameterValues.get("codePostal"));
        newBo.setVille((String) parameterValues.get("ville"));
        newBo.setPays((String) parameterValues.get("pays"));
        return newBo;

    }

}
