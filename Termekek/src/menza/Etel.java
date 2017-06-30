package menza;

/**
 * Created by Student on 6/28/2017.
 */
public class Etel extends Termek
{
    private  boolean soup;
    public Etel(String a, String b, int c, String s)
    {
        super( a,b,c);
        if("főétel".equals(s))
        {
            soup=false;
        }
        else if("leves".equals(s))
        {
            soup=true;
        }
    }

    public boolean isSoup()
    {
        return soup;
    }
}
