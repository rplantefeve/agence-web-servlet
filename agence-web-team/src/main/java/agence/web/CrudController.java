/**
 * 
 */
package agence.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import model.BO;

/**
 * @author Seme
 *
 */
public abstract class CrudController extends HttpServlet
{
    /**
     * @param request
     * @param response
     * @param bo
     * @param attributeName
     * @param jspEdit
     * @throws ServletException
     * @throws IOException
     */
    protected void addAction(HttpServletRequest request, HttpServletResponse response, BO bo,
                             String attributeName, String jspEdit)
            throws ServletException, IOException
    {
        request.setAttribute(attributeName, bo);

        this.forwardRequest(request, response, jspEdit);
    }

    /**
     * 
     * @param request
     * @param response
     * @param dao
     * @param listJsp
     * @param attributeName
     * @throws ServletException
     * @throws IOException
     */
    protected <BO> void deleteAction(HttpServletRequest request, HttpServletResponse response,
                                     Dao<BO> dao, String listJsp, String attributeName)
            throws ServletException, IOException
    {
        // Parsing de l'id dans la requête
        Integer id = Integer.parseInt(request.getParameter("id"));
        // Récupération de l'objet métier
        BO bo = dao.findById(id);
        // suppression de l'objet métier
        dao.delete(bo);
        // affichage de la liste
        this.listAction(request, response, listJsp, dao, attributeName);
    }

    /**
     * 
     * @param request
     * @param response
     * @param jspEdit
     * @param dao
     * @param attributeName
     * @throws ServletException
     * @throws IOException
     */
    protected <BO> void editAction(HttpServletRequest request, HttpServletResponse response,
                                   String jspEdit, Dao<BO> dao, String attributeName)
            throws ServletException, IOException
    {
        // Parsing de l'id dans la requête
        Integer id = Integer.parseInt(request.getParameter("id"));
        // Récupération de l'objet métier
        BO login = dao.findById(id);
        // le BO est injecté dans la requête
        request.setAttribute(attributeName, login);
        // Transmission vers la JSP
        this.forwardRequest(request, response, jspEdit);
    }

    /**
     * @param params
     * @param parameterTypes
     * @return
     */
    protected Map<String, Object> extractParameterValues(Map<String, String[]> params,
                                                         Map<String, Object> parameterTypes)
    {
        Map<String, Object> parameterValues = new HashMap<>();

        // Parcours de tous les types de paramètres attendus
        for (Entry<String, Object> entry : parameterTypes.entrySet())
        {
            String key = entry.getKey();
            Object value = entry.getValue();
            Object newValue = null;

            /*
             * Gérer les différents cas
             */
            // si le paramètre est un entier
            if (value == Integer.class)
            {
                // il faut parser
                newValue = Integer.parseInt(this.getParameterValue(params, key));

            }
            else if (value == Short.class)
            {
                // il faut parser
                newValue = Short.parseShort(this.getParameterValue(params, key));
            }
            else
            {
                newValue = this.getParameterValue(params, key);
            }
            // ajout à la liste des nouvelles valeurs
            parameterValues.put(key, newValue);

        }

        return parameterValues;
    }

    /**
     * @param request
     * @param response
     * @param jsp
     *            La JSP vers où la redirection redirige
     * @throws ServletException
     * @throws IOException
     */
    private void forwardRequest(HttpServletRequest request, HttpServletResponse response,
                                String jsp)
            throws ServletException, IOException
    {
        // je dispache la requête vers la page jsp
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/" + jsp);
        // le ctrl fait suivre la requête et la réponse à la jsp
        rd.forward(request, response);
    }

    /**
     * Retourne la valeur de l'identifiant de l'objet métier s'il existe
     * 
     * @param params
     * @return
     */
    protected Integer getBoIdIfSet(Map<String, String[]> params)
    {
        Integer id = null;
        String idForm = this.getParameterValue(params, "id");

        // si l'id récupéré est non null, on parse
        if ((idForm != null) && !idForm.equals(""))
        {
            id = Integer.parseInt(idForm);
        }
        return id;
    }

    /**
     * 
     * @param params
     * @param parameterName
     * @return
     */
    private String getParameterValue(Map<String, String[]> params, String parameterName)
    {
        return params.get(parameterName)[0];
    }

    /**
     * 
     * @param request
     *            La requête d'origine
     * @param response
     *            La réponse à renvoyer
     * @param jspListBOs
     *            Le nom de la page JSP d'affichage de la liste
     * @param dao
     *            Le DAO qui servira à récupérer la liste d'objets métiers
     * @param attributeName
     *            Le nom de l'attribut de la requête qui sera injecté dans la
     *            JSP
     * @throws ServletException
     * @throws IOException
     */
    protected <BO> void listAction(HttpServletRequest request, HttpServletResponse response,
                                   String jspListBOs, Dao<BO> dao, String attributeName)
            throws ServletException, IOException
    {
        // je récupère la liste des BO
        List<BO> bos = dao.findAll();
        // je la charge dans l'obj request
        request.setAttribute(attributeName, bos);
        // Transmission
        this.forwardRequest(request, response, jspListBOs);
    }

}
