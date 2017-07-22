package model;

public class VilleAeroport implements BO
{

    private Aeroport aeroport;
    private int      id;
    private Ville    ville;

    public VilleAeroport()
    {

    }

    public VilleAeroport(int id)
    {
        this();
        this.id = id;
    }

    public Aeroport getAeroport()
    {
        return this.aeroport;
    }

    public int getId()
    {
        return this.id;
    }

    public Ville getVille()
    {
        return this.ville;
    }

    public void setAeroport(Aeroport aeroport)
    {
        this.aeroport = aeroport;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setVille(Ville ville)
    {
        this.ville = ville;
    }

    @Override
    public String toString()
    {
        String reponse = "La Ville : " + this.ville.getNom() + " est desservie par l'aéroport : "
                + this.aeroport.getNom() + ".";

        return reponse;
    }

}
