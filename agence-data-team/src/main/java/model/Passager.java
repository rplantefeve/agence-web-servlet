package model;

import java.util.HashMap;
import java.util.Map;

public class Passager implements BusinessObject
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
        parameterTypes.put("prenom", String.class);
    }

    private Adresse adresse;
    /**
     * Id du passager
     */
    private int     idPas;
    /**
     * Nom du passager
     */
    private String  nom;

    /**
     * Prenom du passager
     */
    private String  prenom;

    public Passager()
    {
    }

    public Passager(int idPas)
    {

        this.idPas = idPas;

    }

    public Adresse getAdresse()
    {
        return this.adresse;
    }

    public int getIdPas()
    {
        return this.idPas;
    }

    public String getNom()
    {
        return this.nom;
    }

    public String getPrenom()
    {
        return this.prenom;
    }

    public void setAdresse(Adresse adresse)
    {
        this.adresse = adresse;
    }

    public void setIdPas(int idPas)
    {
        this.idPas = idPas;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }

    @Override
    public String toString()
    {
        return "Passager [idPas=" + this.idPas + ", nom=" + this.nom + ", prenom=" + this.prenom
                + ", adresse=" + this.adresse + "]";
    }

}
