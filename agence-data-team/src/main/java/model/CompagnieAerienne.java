package model;

public class CompagnieAerienne implements BusinessObject
{

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
