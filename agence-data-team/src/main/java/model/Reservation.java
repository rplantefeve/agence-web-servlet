package model;

import java.util.Date;

public class Reservation
{

    /**
     * Id de la r�servation
     */
    private int idRes;
    /**
     * Date de la r�servation
     */
    private Date date;
    /**
     * Num�ro de la r�servation
     */
    private int numero;
    /**
     * Etat de la r�servation (ouvert ou ferm�)
     */
    private EtatReservation etat;
    /**
     * id du vol
     */
    private int idVol;
    /**
     * id du passager
     */
    private int idPas;
    /**
     * id du client
     */
    private int idCli;

    /**
     * Vol associ� � la r�servation
     */
    private Vol vol;
    private Passager passager;
    private Client client;

    public Reservation(int idRes)
    {
        this.idRes = idRes;
    }

    public Client getClient()
    {
        return client;
    }

    public Date getDate()
    {
        return date;
    }

    public EtatReservation getEtat()
    {
        return etat;
    }

    public int getIdCli()
    {
        return idCli;
    }

    public int getIdPas()
    {
        return idPas;
    }

    public int getIdRes()
    {
        return idRes;
    }

    public int getIdVol()
    {
        return idVol;
    }

    public int getNumero()
    {
        return numero;
    }

    public Passager getPassager()
    {
        return passager;
    }

    public Vol getVol()
    {
        return vol;
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

    public String toString()
    {
        String reponse = "La Reservation : " + this.numero
                + " a �t� effectu�e par le Client : \n" + client.getNom() + " "
                + client.getPrenom() + "\nElle porte sur le vol de "
                + vol.getAeroportDepart().getNom() + " � "
                + vol.getAeroportArrivee().getNom()
                + ".\nElle concerne le passager :\n" + passager.getNom() + " "
                + passager.getPrenom();

        return reponse;
    }

}
