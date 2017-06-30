/**
 * Created by Student on 6/22/2017.
 */
public class ZarojelvizsgaloClass
{
    public String zarojelek;
    public boolean helyesség=true;
    public ZarojelvizsgaloClass(String a)
    {
        zarojelek=a;
        int [] zarojelszam=new int [2];
        for (int i=0;i<a.length();i++)
        {
            if(a.toCharArray()[0]==')' || a.toCharArray()[a.length()-1]=='(')
            {
                helyesség=false;
            }
            else if(a.toCharArray()[i]=='(')
            {
                zarojelszam[0]++;
            }
            else
            {
                zarojelszam[1]++;
            }
        }
        if(zarojelszam[0]-zarojelszam[1]==0 &&helyesség==true)
        {
            helyesség=true;
        }
        else
        {
            helyesség=false;
        }
    }

}
