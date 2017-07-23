/**
 * 
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ajc
 */
public class Adresse implements BusinessObject
{

    public static Map<String, Object> parameterTypes;
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
        parameterTypes.put("adresse", String.class);
        parameterTypes.put("codePostal", String.class);
        parameterTypes.put("pays", String.class);
        parameterTypes.put("ville", String.class);
    }
    private String adresse;
    private String codePostal;
    private int    idAdd;
    private String pays;
    private String ville;

    public Adresse()
    {
        // TODO Auto-generated constructor stub
    }

    public Adresse(int idAdd)
    {
        this();
        this.idAdd = idAdd;
    }

    public String getAdresse()
    {
        return this.adresse;
    }

    public String getCodePostal()
    {
        return this.codePostal;
    }

    public int getIdAdd()
    {
        return this.idAdd;
    }

    public String getPays()
    {
        return this.pays;
    }

    public String getVille()
    {
        return this.ville;
    }

    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }

    public void setCodePostal(String codePostal)
    {
        this.codePostal = codePostal;
    }

    public void setIdAdd(int idAdd)
    {
        this.idAdd = idAdd;
    }

    public void setPays(String pays)
    {
        this.pays = pays;
    }

    public void setVille(String ville)
    {
        this.ville = ville;
    }

    @Override
    public String toString()
    {
        return "Adresse [adresse=" + this.adresse + ", codePostal=" + this.codePostal + ", ville="
                + this.ville + ", pays=" + this.pays + "]";
    }

}
