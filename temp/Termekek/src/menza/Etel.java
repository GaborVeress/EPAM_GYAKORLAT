package menza;

/**
 * Created by Student on 6/28/2017.
 */
public class Etel extends Termek
{
    private  boolean soup;
    public static int leves,foetel;

    public Etel(String a, String b, int c, String s)
    {
        super(a, b, c);
        if("főétel".equals(s))
        {
            soup=false;
            foetel++;
        }
        else if("leves".equals(s))
        {
            soup=true;
            leves++;
        }
        else
        {
            System.out.println("WTF is this???");
        }
    }
}
