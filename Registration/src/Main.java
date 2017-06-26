import com.sun.javafx.image.impl.ByteIndexed;
import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Student on 6/26/2017.
 */
public class Main
{
    public static void main(String [] args)
    {
        int sum=1;
        boolean quit=false;
        while(!quit)
        {
            System.out.println(sum+". felhasználó hozzáadása.");
            Scanner input = new Scanner(System.in);
            ArrayList<Register> users = new ArrayList<Register>();
            String[] aktualis = new String[6];
            System.out.println("Add meg a nevet!");
            aktualis[0] = input.nextLine();
            System.out.println("Add meg a címet!");
            aktualis[1] = input.nextLine();
            System.out.println("Add meg az e-mail címet!");
            aktualis[2] = input.nextLine();
            System.out.println("Add meg a jelszót!");
            aktualis[3] = input.nextLine();
            System.out.println("Add meg a jelszót!(megerősítés)");
            aktualis[4] = input.nextLine();
            System.out.println("Add meg az életkort!");
            aktualis[5] = input.nextLine();
            Register newuser = new Register(aktualis);
            boolean error = false;
            if (newuser.getName().equals("") || newuser.getAge() == 0 || newuser.getEmail().equals("") || newuser.getPass().equals("")|| newuser.getCím().equals(""))
            {
                error = true;
            }
            if (!error)
            {
                users.add(newuser);
                sum++;
            }
            System.out.println("Kilépés(y/n)?");
            String kilepes = input.nextLine();
            if ("y".equals(kilepes))
            {
             quit=true;
            }
        }
    }
}
