/**
 * 
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ajc
 */
public class Login implements BusinessObject
{

    public static final Map<String, Object> parameterTypes;
    /**
     * Initialisation de la HashMap (elle doit se faire en static, une seule
     * fois)
     */
    static
    {
        /*
         * Ce genre de chose pourrait être amélioré avec l'API Reflection
         * http://docs.oracle.com/javase/6/docs/technotes/guides/reflection/
         * index.html
         */
        parameterTypes = new HashMap<>();
        parameterTypes.put("login", String.class);
        parameterTypes.put("motDePasse", String.class);
        parameterTypes.put("admin", Integer.class);
    }
    private int    admin;
    private int    id;
    private String login;
    private String motDePasse;

    public Login()
    {

    }

    public Login(int idLog)
    {
        this();
        this.id = idLog;
    }

    /**
     * @return the admin
     */
    public int getAdmin()
    {
        return this.admin;
    }

    /**
     * @return the id
     */
    public int getId()
    {
        return this.id;
    }

    /**
     * @return the login
     */
    public String getLogin()
    {
        return this.login;
    }

    /**
     * @return the motDePasse
     */
    public String getMotDePasse()
    {
        return this.motDePasse;
    }

    /**
     * @param admin
     *            the admin to set
     */
    public void setAdmin(int admin)
    {
        this.admin = admin;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @param login
     *            the login to set
     */
    public void setLogin(String login)
    {
        this.login = login;
    }

    /**
     * @param motDePasse
     *            the motDePasse to set
     */
    public void setMotDePasse(String motDePasse)
    {
        this.motDePasse = motDePasse;
    }

}
