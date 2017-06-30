/**
 * Created by Student on 6/23/2017.
 */
public class StringVizsgaloClass
{
    public String [] szovegek;
    public StringVizsgaloClass(String []a)
    {
        szovegek = a;
    }
    public static void vizsgalat(StringVizsgaloClass a)
    {
        String keresett=a.szovegek[0];
        int counter=a.szovegek.length;
        for (int i=0;i<a.szovegek.length;i++)
        {

            for(int j=0;j<keresett.length();j++)
            {
                if(a.szovegek[i].charAt(j) !=keresett.charAt(j))
                {
                    keresett=keresett.substring(0,j);
                }
            }
        }
        System.out.println("A keresett leghosszabb kezdőrész:"+keresett);
    }
}
