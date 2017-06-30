import java.util.Scanner;

/**
 * Created by Student on 6/22/2017.
 */
public class Main
{
    public static void main(String [] args)
    {
        //1. feladat:
        System.out.println("1.feladat:");
        System.out.println("Add meg a zárójeleket!");
        Scanner input=new Scanner (System.in);
        ZarojelvizsgaloClass elem=new ZarojelvizsgaloClass(input.nextLine());
        if(elem.zarojelek.length()==0)
        {
            System.out.println("Nincs megadott string.");
        }
        else if (elem.helyesség==true)
        {
            System.out.println("A zárójelezés helyes.");
        }
        else
        {
            System.out.println("A zárójelezés helytelen.");
        }
        //2. feladat
        System.out.println("2.feladat:");
        System.out.println("Adj meg egy muveletet:");
        String muvelet=input.nextLine();
        SzamoloClass.Szamologep(muvelet);
        //3.feladat
        System.out.println("3.feladat:");
        System.out.println("Adj meg 3 stringet:");
        String [] új=new String [3];
        for (int i=0;i<3;i++)
        {
            switch(i)
            {
                case 0:
                {
                    System.out.println("Első string:");
                    új[i]=input.nextLine();
                    break;

                }
                case 1:
                {
                    System.out.println("Masodik string:");
                    új[i]=input.nextLine();
                    break;
                }
                case 2:
                {
                    System.out.println("Harmadik string:");
                    új[i]=input.nextLine();
                    break;
                }
            }
        }
        StringVizsgaloClass újelem=new StringVizsgaloClass(új);
        StringVizsgaloClass.vizsgalat(újelem);
    }
}
