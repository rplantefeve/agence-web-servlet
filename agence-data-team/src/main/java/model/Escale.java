/**
 * 
 */
package model;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ajc
 */
public class Escale implements BusinessObject
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
        parameterTypes.put("dateArrivee", Date.class);
        parameterTypes.put("dateDepart", Date.class);
        parameterTypes.put("heureArrivee", Time.class);
        parameterTypes.put("heureDepart", Time.class);
    }

    private Aeroport aeoroport;
    private Date     dateArrivee;
    private Date     dateDepart;
    private Time     heureArrivee;
    private Time     heureDepart;
    private int      idEscale;
    private Vol      vol;

    public Escale()
    {

        this.dateDepart = null;
        this.dateArrivee = null;
        this.heureDepart = null;
        this.heureArrivee = null;

    }

    public Escale(int idEscale)
    {
        this.idEscale = idEscale;
    }

    public Aeroport getAeoroport()
    {
        return this.aeoroport;
    }

    public Date getDateArrivee()
    {
        return this.dateArrivee;
    }

    public Date getDateDepart()
    {
        return this.dateDepart;
    }

    public Time getHeureArrivee()
    {
        return this.heureArrivee;
    }

    public Time getHeureDepart()
    {
        return this.heureDepart;
    }

    public int getIdEscale()
    {
        return this.idEscale;
    }

    public Vol getVol()
    {
        return this.vol;
    }

    public void setAeoroport(Aeroport aeoroport)
    {
        this.aeoroport = aeoroport;
    }

    public void setDateArrivee(Date dateArrivee)
    {
        this.dateArrivee = dateArrivee;
    }

    public void setDateDepart(Date dateDepart)
    {
        this.dateDepart = dateDepart;
    }

    public void setHeureArrivee(Time heureArrivee)
    {
        this.heureArrivee = heureArrivee;
    }

    public void setHeureDepart(Time heureDepart)
    {
        this.heureDepart = heureDepart;
    }

    public void setIdEscale(int idEscale)
    {
        this.idEscale = idEscale;
    }

    public void setVol(Vol vol)
    {
        this.vol = vol;
    }

    @Override
    public String toString()
    {
        return "Escale [dateDepart=" + this.dateDepart + ", dateArrivee=" + this.dateArrivee
                + ", heureDepart=" + this.heureDepart + ", heureArrivee=" + this.heureArrivee
                + ", idEscale=" + this.idEscale + ", vol=" + this.vol + ", aeoroport="
                + this.aeoroport + "]";
    }

}
