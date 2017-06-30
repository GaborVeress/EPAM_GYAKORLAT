package teszt;

import menza.Termek;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Student on 6/29/2017.
 */
public class MenuTeszt
{
    public static void main(String [] args)
    {
        Scanner input=new Scanner(System.in);
        String eleresiut=input.nextLine();
        ArrayList<Termek> termekek=new ArrayList<Termek>();
        try
        {
            input = new Scanner(new File(eleresiut));
            input.useDelimiter("[;/]");
            while (input.hasNext())
            {
                System.out.println();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Nincs ilyen fájl!");
        }
    }
}

