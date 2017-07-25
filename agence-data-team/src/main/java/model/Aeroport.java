package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aeroport implements BusinessObject
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
     * id de l'aéroport
     */
    private int         idAer;
    /**
     * Nom de l'aéroport
     */
    private String      nom;

    /**
     * Liste des villes désservies par l'aéroport
     */
    private List<Ville> villes = new ArrayList<>();

    /**
     * Constructeur de aeroport
     */
    public Aeroport()
    {

    }

    public Aeroport(int idAer)
    {
        this.idAer = idAer;
    }

    public Aeroport(int idAer, String nom)
    {
        this.nom = nom;
        this.idAer = idAer;
    }

    /**
     * Ajout d'une ville existante à la liste des villes desservies par
     * l'aéroport
     * 
     * @param ville
     *            Ville à ajouter
     */
    public void ajouterVille(Ville ville)
    {
        this.villes.add(ville); // ajout d'une ville déjà existante
    }

    public int getIdAer()
    {
        return this.idAer;
    }

    public String getNom()
    {
        return this.nom;
    }

    public List<Ville> getVilles()
    {
        return this.villes;
    }

    public void setIdAer(int idAer)
    {
        this.idAer = idAer;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public void setVilles(List<Ville> villes)
    {
        this.villes = villes;
    }

    @Override
    public String toString()
    {
        return "Aeroport [idAer=" + this.idAer + ", nom=" + this.nom + ", villes=" + this.villes
                + "]";
    }

}
