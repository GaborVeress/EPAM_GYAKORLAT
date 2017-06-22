import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 6/22/2017.
 */
public class SzamoloClass
{
    public String muvelet;
    public SzamoloClass (String a)
    {
        muvelet=a;
    }
    public static void Szamologep(String a)
    {
        ArrayList<Integer> szamok=new ArrayList<Integer>();
        ArrayList<String> muveletijelek=new ArrayList<String>();
        int counter = 0;
        for( int i=0; i<a.length(); i++ )
        {
            if( a.charAt(i) == '/'||a.charAt(i) == '*' || a.charAt(i) == '-' || a.charAt(i) == '+' )
            {
                counter++;
                muveletijelek.add(Character.toString(a.charAt(i)));
            }
        }
        for (int i=0;i<counter+1;i++)
        {
            if (!Character.isDigit(a.toCharArray()[0]))
            {
                System.out.println("Nem müvelet!");
            }
            else
            {
                szamok.add(Integer.parseInt(a.split("[/*+-]")[i]));
            }
        }
        for(int i=0;i<muveletijelek.size();i++)
        {
            if(muveletijelek.get(i)=="/")
            {
                szamok.set(i,szamok.get(i)/szamok.get(i+1));
                szamok.remove(i+1);
            }
            else if(muveletijelek.get(i)=="*")
            {
                szamok.set(i,szamok.get(i)*szamok.get(i+1));
                szamok.remove(i+1);
            }
        }
        for(int i=0;i<muveletijelek.size();i++)
        {
            if(muveletijelek.get(i)=="-")
            {
                szamok.set(i,szamok.get(i)-szamok.get(i+1));
                szamok.remove(i+1);
            }
            else if(muveletijelek.get(i)=="+")
            {
                szamok.set(i,szamok.get(i)+szamok.get(i+1));
                szamok.remove(i+1);
            }
        }
        if (Character.isDigit(a.toCharArray()[0]))
        {
            System.out.println(szamok.get(0));
        }
    }
}
