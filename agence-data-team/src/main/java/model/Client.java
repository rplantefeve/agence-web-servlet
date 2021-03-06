/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ajc
 */
public class Client implements BusinessObject
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
        parameterTypes.put("email", String.class);
        parameterTypes.put("nom", String.class);
        parameterTypes.put("numeroFax", String.class);
        parameterTypes.put("numeroTel", String.class);
        parameterTypes.put("prenom", String.class);
        parameterTypes.put("siret", String.class);
        parameterTypes.put("idAdd", Integer.class);
        // parameterTypes.put("idLog", Integer.class);
    }

    private Adresse           adresse;
    private String            email;
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
