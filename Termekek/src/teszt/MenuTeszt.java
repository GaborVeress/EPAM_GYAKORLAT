package teszt;
import etterem.Menu;
import menza.Etel;
import menza.Ital;
import menza.NincsIlyenTermékException;
import menza.Termek;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Student on 6/29/2017.
 */
public class MenuTeszt
{
    private static void consoleKiÍr(Menu[] tomb)
    {
     for(Menu item:tomb)
     {
         if(item.termékekSzáma(1)>0 &&item.termékekSzáma(2)>0 && item.termékekSzáma(4)>0)
         {
             System.out.println(item.getDatum());
         }
     }
    }
    private static void outPrice(ArrayList<Termek> termeklista)

    {
        int összeg = 0;

        Scanner scanner = new Scanner(System.in);

        for (Termek item : termeklista)

        {

            System.out.println("Add meg a kért mennyiséget! " + item.toString());

            int db = Integer.parseInt(scanner.nextLine());

            összeg += (item.getEgysegar() * db);


        }
    }
    public static void main(String [] args)
    {
        Scanner input=new Scanner(System.in);
        String eleresiut=null;
        ArrayList<Termek> termekek=new ArrayList<Termek>();
        try
        {

            input = new Scanner(new File(args[0]));

            while (input.hasNext())
            {
                String [] array = input.nextLine().split("[;/]");
                if("étel".equals(array[0]))
                {
                    termekek.add(new Etel(array[1],array[2],Integer.parseInt(array[3]),array[4]));
                }
                else
                {
                    termekek.add(new Ital(array[1],array[2],Integer.parseInt(array[3]),array[4]));
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Nincs ilyen fájl!");
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Date date = new Date();
        Menu menu=new Menu(dateFormat.format(date),termekek);
        System.out.println("Adj meg egy állománynevet!");
        input=new Scanner(System.in);
        menu.kiír(input.nextLine());
        ArrayList<Termek> needToRemove= new ArrayList<>();
        for (Termek t:termekek)
        {
            if("adag".equals(t.getMennyisegiegyseg()))
            {
                needToRemove.add(t);
            }
        }
        for (Termek item : needToRemove)
        {
            try
            {
                menu.töröl(item);
            } catch (NincsIlyenTermékException e)
            {
                System.out.println("Úgysem lesz ilyen Exception.");
            }
        }

        outPrice(termekek);

        Menu [] menus= {menu};
        consoleKiÍr(menus);
    }
}

