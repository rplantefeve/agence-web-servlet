package model;

import java.util.HashMap;
import java.util.Map;

public class CompagnieAerienne implements BusinessObject
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
        parameterTypes.put("nom", String.class);
    }

    /**
     * Id de la compagnie aérienne
     */
    private int    id;

    /**
     * Nom de la compagnie aérienne
     */
    private String nom;

    public CompagnieAerienne()
    {

    }

    public CompagnieAerienne(int id, String nom)
    {
        this.id = id;
        this.nom = nom;
    }

    public int getId()
    {
        return this.id;
    }

    public String getNom()
    {
        return this.nom;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    @Override
    public String toString()
    {
        return "CompagnieAerienne [id=" + this.id + ", nom=" + this.nom + "]";
    }

}
