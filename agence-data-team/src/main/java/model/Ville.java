package model;

public class Ville implements BusinessObject
{

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
