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
import model.BusinessObject;

/**
 * @author Seme
 * @param <T>
 *
 */
public abstract class CrudController<BO> extends HttpServlet
{
    public static final String editJspSuffix = "Edit.jsp";
    public static final String listJspSuffix = "s.jsp";
    protected String           attributeName;
    protected Dao<BO>          dao;
    protected String           jspEdit;
    protected String           jspListBOs;

    protected String           listAttributeName;
    protected String           nameOfBO;

    /**
     * @param nameOfBO
     */
    public CrudController(String nameOfBO)
    {
        this(nameOfBO, nameOfBO + editJspSuffix, nameOfBO + listJspSuffix, nameOfBO + "s");
        this.nameOfBO = nameOfBO;
    }

    /**
     * @param attributeName
     * @param jspEdit
     * @param jspListBOs
     * @param listAttributeName
     */
    public CrudController(String attributeName, String jspEdit, String jspListBOs,
            String listAttributeName)
    {
        this.attributeName = attributeName;
        this.jspEdit = jspEdit;
        this.jspListBOs = jspListBOs;
        this.listAttributeName = listAttributeName;
    }

    protected void addAction(HttpServletRequest request, HttpServletResponse response,
                             BusinessObject bo)
            throws ServletException, IOException
    {
        request.setAttribute(this.attributeName, bo);

        this.forwardRequest(request, response, this.jspEdit);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // Parsing de l'id dans la requête
        Integer id = Integer.parseInt(request.getParameter("id"));
        // Récupération de l'objet métier
        BO bo = this.dao.findById(id);
        // suppression de l'objet métier
        this.dao.delete(bo);
        // affichage de la liste
        this.listAction(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @param bo
     * @param parameterTypes
     * @throws ServletException
     * @throws IOException
     */
    protected void doGetCrud(HttpServletRequest request, HttpServletResponse response,
                             BusinessObject bo, Map<String, Object> parameterTypes)
            throws ServletException, IOException
    {
        // on teste si le paramètre action est présent dans l'URL
        String action = request.getParameter("action") != null ? request.getParameter("action")
                : "list";
        switch (action)
        {
            case "list":
                // si l'action demandée par le user est la liste des BO
                this.listAction(request, response);
                break;
            case "add":
                this.addAction(request, response, bo);
                break;
            case "edit":
                this.editAction(request, response);
                break;
            case "update":
                this.updateAction(request, response, parameterTypes);
                break;
            case "delete":
                this.deleteAction(request, response);
                break;

            default:
                break;
        }
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void editAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // Parsing de l'id dans la requête
        Integer id = Integer.parseInt(request.getParameter("id"));
        // Récupération de l'objet métier
        BO login = this.dao.findById(id);
        // le BO est injecté dans la requête
        request.setAttribute(this.attributeName, login);
        // Transmission vers la JSP
        this.forwardRequest(request, response, this.jspEdit);
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
        String[] values = params.get(parameterName);
        if (values != null)
        {
            return params.get(parameterName)[0];
        }
        else
        {
            return null;
        }
    }

    /**
     * 
     * @param parameterValues
     * @param bo
     */
    protected abstract BO hydrateBO(Map<String, Object> parameterValues, BO bo);

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void listAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // je récupère la liste des BO
        List<BO> bos = this.dao.findAll();
        // je la charge dans l'obj request
        request.setAttribute(this.listAttributeName, bos);
        // Transmission
        this.forwardRequest(request, response, this.jspListBOs);
    }

    /**
     * 
     * @param request
     * @param response
     * @param parameterTypes
     * @param bo
     * @throws ServletException
     * @throws IOException
     */
    protected void updateAction(HttpServletRequest request, HttpServletResponse response,
                                Map<String, Object> parameterTypes)
            throws ServletException, IOException
    {
        Map<String, String[]> params = request.getParameterMap();

        Map<String, Object> parameterValues = this.extractParameterValues(params, parameterTypes);

        BO bo = null;
        Integer id = null;

        id = this.getBoIdIfSet(params);
        // si l'id n'est pas null, récupération des infos
        if (id != null)
        {
            bo = this.dao.findById(id);
        }

        bo = this.hydrateBO(parameterValues, bo);

        if (id == null)
        {
            this.dao.create(bo);
        }
        else
        {
            this.dao.update(bo);
        }

        this.listAction(request, response);
    }

}
