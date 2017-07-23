package agence.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agence.web.exception.UnknownBusinessObject;
import dao.AdresseDao;
import dao.AdresseDaoSql;
import dao.ClientDaoSql;
import model.Adresse;
import model.Client;

@WebServlet("/client")
public class ClientController extends CrudController<Client>
{

    private AdresseDao adresseDao = new AdresseDaoSql();

    /**
     * 
     */
    public ClientController()
    {
        super("client");
        this.dao = new ClientDaoSql();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        this.doGetCrud(request, response, new Client(), Client.parameterTypes);
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
    protected Client hydrateBO(Map<String, Object> parameterValues, Client bo)
            throws UnknownBusinessObject
    {
        Client newBo;
        if (bo != null)
        {
            newBo = bo;
        }
        else
        {
            newBo = new Client();
        }
        newBo.setNom((String) parameterValues.get("nom"));
        newBo.setPrenom((String) parameterValues.get("prenom"));
        newBo.setNumeroTel((String) parameterValues.get("numeroTel"));
        newBo.setNumeroFax((String) parameterValues.get("numeroFax"));
        newBo.setEmail((String) parameterValues.get("email"));
        newBo.setSiret((String) parameterValues.get("siret"));
        // Recherche de l'adresse
        Adresse adresse = this.adresseDao.findById((Integer) parameterValues.get("idAdd"));
        if (adresse != null)
        {
            newBo.setAdresse(adresse);
            return newBo;
        }
        else
        {
            this.errorMessages.add("Impossible de trouver cette adresse.");
            throw new UnknownBusinessObject("Adresse");
        }
    }

}
