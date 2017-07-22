/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ajc
 */
public class Client implements BO
{

    private Adresse           adresse;
    private String            email;
    /**
     * 
     */
    private int               idCli;
    private List<Reservation> ListReservations;
    private Login             Log;
    private String            nom;
    private String            numeroFax;

    private String            numeroTel;
    private String            prenom;
    private String            siret;

    public Client()
    {
        this.ListReservations = new ArrayList<>();
    }

    public Client(int idCli)
    {

        this();
        this.idCli = idCli;
    }

    public Adresse getAdresse()
    {
        return this.adresse;
    }

    public String getEmail()
    {
        return this.email;
    }

    public int getIdCli()
    {
        return this.idCli;
    }

    public List<Reservation> getListReservations()
    {
        return this.ListReservations;
    }

    public Login getLog()
    {
        return this.Log;
    }

    public String getNom()
    {
        return this.nom;
    }

    public String getNumeroFax()
    {
        return this.numeroFax;
    }

    public String getNumeroTel()
    {
        return this.numeroTel;
    }

    public String getPrenom()
    {
        return this.prenom;
    }

    public String getSiret()
    {
        return this.siret;
    }

    public void setAdresse(Adresse adresse)
    {
        this.adresse = adresse;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setIdCli(int idCli)
    {
        this.idCli = idCli;
    }

    public void setListReservations(List<Reservation> listReservations)
    {
        this.ListReservations = listReservations;
    }

    public void setLog(Login log)
    {
        this.Log = log;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public void setNumeroFax(String numeroFax)
    {
        this.numeroFax = numeroFax;
    }

    public void setNumeroTel(String numeroTel)
    {
        this.numeroTel = numeroTel;
    }

    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }

    public void setSiret(String siret)
    {
        this.siret = siret;
    }

    @Override
    public String toString()
    {
        String reponse = "Le Client : " + this.nom + " " + this.prenom + " " + this.getNumeroTel()
                + " a effectué la/les reservation(s) : \n";
        for (int i = 0; i < this.ListReservations.size(); i++)
        {
            reponse += "\n" + this.ListReservations.get(i).getNumero();
        }

        return reponse;
    }

}
