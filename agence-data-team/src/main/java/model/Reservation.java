package model;

import java.util.Date;

public class Reservation implements BO
{

    private Client          client;
    /**
     * Date de la réservation
     */
    private Date            date;
    /**
     * Etat de la réservation (ouvert ou fermé)
     */
    private EtatReservation etat;
    /**
     * id du client
     */
    private int             idCli;
    /**
     * id du passager
     */
    private int             idPas;
    /**
     * Id de la réservation
     */
    private int             idRes;
    /**
     * id du vol
     */
    private int             idVol;

    /**
     * Numéro de la réservation
     */
    private int             numero;
    private Passager        passager;
    /**
     * Vol associé à la réservation
     */
    private Vol             vol;

    public Reservation(int idRes)
    {
        this.idRes = idRes;
    }

    public Client getClient()
    {
        return this.client;
    }

    public Date getDate()
    {
        return this.date;
    }

    public EtatReservation getEtat()
    {
        return this.etat;
    }

    public int getIdCli()
    {
        return this.idCli;
    }

    public int getIdPas()
    {
        return this.idPas;
    }

    public int getIdRes()
    {
        return this.idRes;
    }

    public int getIdVol()
    {
        return this.idVol;
    }

    public int getNumero()
    {
        return this.numero;
    }

    public Passager getPassager()
    {
        return this.passager;
    }

    public Vol getVol()
    {
        return this.vol;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public void setEtat(EtatReservation etat)
    {
        this.etat = etat;
    }

    public void setIdCli(int idCli)
    {
        this.idCli = idCli;
    }

    public void setIdPas(int idPas)
    {
        this.idPas = idPas;
    }

    public void setIdRes(int idRes)
    {
        this.idRes = idRes;
    }

    public void setIdVol(int idVol)
    {
        this.idVol = idVol;
    }

    public void setNumero(int numero)
    {
        this.numero = numero;
    }

    public void setPassager(Passager passager)
    {
        this.passager = passager;
    }

    public void setVol(Vol vol)
    {
        this.vol = vol;
    }

    @Override
    public String toString()
    {
        String reponse = "La Reservation : " + this.numero + " a été effectuée par le Client : \n"
                + this.client.getNom() + " " + this.client.getPrenom()
                + "\nElle porte sur le vol de " + this.vol.getAeroportDepart().getNom() + " à "
                + this.vol.getAeroportArrivee().getNom() + ".\nElle concerne le passager :\n"
                + this.passager.getNom() + " " + this.passager.getPrenom();

        return reponse;
    }

}
