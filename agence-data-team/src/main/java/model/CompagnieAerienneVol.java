package model;

import java.util.HashMap;
import java.util.Map;

public class CompagnieAerienneVol implements BusinessObject
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
        parameterTypes.put("numero", String.class);
        parameterTypes.put("ouvert", Short.class);
    }

    private CompagnieAerienne compagnieAerienne;
    private int               id;
    private String            numero;
    private short             ouvert;

    private Vol               vol;

    public CompagnieAerienneVol()
    {

    }

    public CompagnieAerienneVol(String numero, short ouvert)
    {
        this.numero = numero;
        this.ouvert = ouvert;
    }

    public CompagnieAerienne getCompagnieAerienne()
    {
        return this.compagnieAerienne;
    }

    public int getId()
    {
        return this.id;
    }

    public String getNumero()
    {
        return this.numero;
    }

    public short getOuvert()
    {
        return this.ouvert;
    }

    public Vol getVol()
    {
        return this.vol;
    }

    public short isOuvert()
    {
        return this.ouvert;
    }

    public void setCompagnieAerienne(CompagnieAerienne compagnieAerienne)
    {
        this.compagnieAerienne = compagnieAerienne;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setNumero(String numero)
    {
        this.numero = numero;
    }

    public void setOuvert(short ouvert)
    {
        this.ouvert = ouvert;
    }

    public void setVol(Vol vol)
    {
        this.vol = vol;
    }

    @Override
    public String toString()
    {
        return "CompagnieAerienneVol [id=" + this.id + " compagnieAerienne="
                + this.compagnieAerienne + ", vol=" + this.vol + ", numero=" + this.numero
                + ", ouvert=" + this.ouvert + "]";
    }

}
