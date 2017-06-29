package menza;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Student on 6/28/2017.
 */
public abstract class Termek  implements Comparable<Termek>
{
    protected String nev, mennyisegiegyseg;
    protected int egysegar;
    public Termek(String a,String b,int c)
    {
        nev=a;
        mennyisegiegyseg=b;
        egysegar=c;
    }

    public String getNev()
    {
        return nev;
    }

    public void setNev(String nev)
    {
        this.nev = nev;
    }

    public String getMennyisegiegyseg()
    {
        return mennyisegiegyseg;
    }

    public void setMennyisegiegyseg(String mennyisegiegyseg)
    {
        this.mennyisegiegyseg = mennyisegiegyseg;
    }

    public int getEgysegar()
    {
        return egysegar;
    }

    public void setEgysegar(int egysegar)
    {
        this.egysegar = egysegar;
    }
    @Override
    public boolean equals(Object obj)
    {
        boolean visszateres=false;
        if(obj instanceof Termek)
        {
            visszateres=this.nev.equals(((Termek) obj).nev) && this.mennyisegiegyseg.equals(((Termek) obj).mennyisegiegyseg);
        }
        else
        {
            System.out.println("What do you want me to do???");
        }
        return  visszateres;
    }
   @Override
   public String toString()
    {
        return nev+", "+mennyisegiegyseg+", "+egysegar+" Ft";
    }
    @Override
    public int compareTo(@NotNull Termek o)
    {
        int eredmeny = 0;
        if (this.nev.compareTo(o.nev) < 0)
        {
            eredmeny = this.nev.compareTo(o.nev);
        }
        else if (this.nev.compareTo(o.nev) == 0)
        {
            if (this.mennyisegiegyseg.compareTo(o.mennyisegiegyseg) < 0)
            {
                eredmeny = this.mennyisegiegyseg.compareTo(o.mennyisegiegyseg);
            }
            else if (this.mennyisegiegyseg.compareTo(o.mennyisegiegyseg) == 0)
            {
                eredmeny = 0;
            }
            else
            {
                eredmeny = this.mennyisegiegyseg.compareTo(o.mennyisegiegyseg);
            }
        }
        else
        {
            eredmeny = this.nev.compareTo(o.nev);
        }
        return eredmeny;
    }
}
