package model;

import java.util.HashMap;
import java.util.Map;

public class Ville implements BusinessObject
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
        parameterTypes.put("nom", String.class);
    }

    /**
     * Id de la ville
     */
    private int    idVil;

    /**
     * Nom de la ville
     */
    private String nom;

    public Ville()
    {

    }

    public Ville(int idVil, String nom)
    {
        this.idVil = idVil;
        this.nom = nom;
    }

    public int getIdVil()
    {
        return this.idVil;
    }

    public String getNom()
    {
        return this.nom;
    }

    public void setIdVil(int idVil)
    {
        this.idVil = idVil;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    @Override
    public String toString()
    {
        String reponse = "La Ville : " + this.nom;

        return reponse;
    }

}
