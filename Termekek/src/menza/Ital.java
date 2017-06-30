package menza;

/**
 * Created by Student on 6/28/2017.
 */
public class Ital extends Termek
{
    private boolean alcoholic;

    public Ital(String a, String b, int c,String s)
    {
        super(a, b, c);
        if("alkoholos".equals(s))
        {
            alcoholic=true;
        }
        else if("mentes".equals(s))
        {
            alcoholic=false;
        }
    }

    public boolean isAlcoholic()
    {
        return alcoholic;
    }
}

