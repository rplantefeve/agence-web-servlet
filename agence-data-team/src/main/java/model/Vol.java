package model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ajc
 */
public class Vol implements BO
{

    private Aeroport     aeroportArrivee;
    private Aeroport     aeroportDepart;
    /**
     * date d'arrivé du vol
     */
    private Date         dateArrivee;
    /**
     * date de départ du vol
     */
    private Date         dateDepart;
    /**
     * liste d'escales par lesquelles on peut passer
     */
    private List<Escale> escales;
    /**
     * heure d'arrivée du vol
     */
    private Time         heureArrivee;
    /**
     * heure départ du vol
     */
    private Time         heureDepart;
    /**
     * id du vol
     */
    private int          idVol;

    /**
     * Constructeur de vol
     */
    public Vol()
    {
        this.escales = new ArrayList<>();
    }

    /**
     * constructeur de vol
     * 
     * @param idVol
     *            l'ID du vol
     */
    public Vol(int idVol)
    {
        this.idVol = idVol;
        this.escales = new ArrayList<>();
    }

    public Aeroport getAeroportArrivee()
    {
        return this.aeroportArrivee;
    }

    public Aeroport getAeroportDepart()
    {
        return this.aeroportDepart;
    }

    public Date getDateArrivee()
    {
        return this.dateArrivee;
    }

    public Date getDateDepart()
    {
        return this.dateDepart;
    }

    public List<Escale> getEscales()
    {
        return this.escales;
    }

    public Time getHeureArrivee()
    {
        return this.heureArrivee;
    }

    public Time getHeureDepart()
    {
        return this.heureDepart;
    }

    public int getIdVol()
    {
        return this.idVol;
    }

    public void setAeroportArrivee(Aeroport aeroportArrivee)
    {
        this.aeroportArrivee = aeroportArrivee;
    }

    public void setAeroportDepart(Aeroport aeroportDepart)
    {
        this.aeroportDepart = aeroportDepart;
    }

    public void setDateArrivee(Date dateArrivee)
    {
        this.dateArrivee = dateArrivee;
    }

    public void setDateDepart(Date dateDepart)
    {
        this.dateDepart = dateDepart;
    }

    public void setEscales(List<Escale> escales)
    {
        this.escales = escales;
    }

    public void setHeureArrivee(Time heureArrivee)
    {
        this.heureArrivee = heureArrivee;
    }

    public void setHeureDepart(Time heureDepart)
    {
        this.heureDepart = heureDepart;
    }

    public void setIdVol(int idVol)
    {
        this.idVol = idVol;
    }

    @Override
    public String toString()
    {
        String reponse = "Le vol  de : " + this.aeroportDepart.getNom() + " qui part le "
                + this.dateDepart + " à " + this.heureDepart + "\n Arrivera à "
                + this.aeroportArrivee.getNom() + " à " + this.heureArrivee
                + "\nIl fera des escales à : ";
        for (int i = 0; i < this.escales.size(); i++)
        {
            reponse += "\n" + this.escales.get(i).getAeoroport().getNom() + " le "
                    + this.escales.get(i).getDateArrivee() + " à "
                    + this.escales.get(i).getHeureArrivee() + "jusqu'au"
                    + this.escales.get(i).getDateDepart() + " à "
                    + this.escales.get(i).getHeureDepart();
        }

        return reponse;
    }
}
