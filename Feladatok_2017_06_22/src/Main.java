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

    }
}
