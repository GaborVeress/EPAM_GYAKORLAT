import com.sun.javafx.image.impl.ByteIndexed;
import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Student on 6/26/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int akt = 0;
        akt = Register.Choose(akt, input);
        ArrayList<Register> users = new ArrayList<Register>();
        int sum = 1;
        while (akt != 0)
        {
            if (akt == 1)
            {
                System.out.println(sum + ". felhasználó hozzáadása.");
                String[] aktualis = new String[6];
                System.out.println("Add meg a nevet!");
                aktualis[0] = input.nextLine();
                System.out.println("Add meg a címet!(Pl: 4000 Randomtelepules, Random utca 2");
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
                if (newuser.getName().equals("") || newuser.getAge() == 0 || newuser.getEmail().equals("") || newuser.getPass().equals("") || !newuser.getCím().Validator(newuser.getCím()))
                {
                    error = true;
                }

                if (!error)
                {
                    users.add(newuser);
                    sum++;
                }
                akt = Register.Choose(akt, input);
            }
            else if (akt == 2)
            {
                if (users.size() > 1)
                {
                    System.out.println("Add meg a törlésre szánt felhasználói fiók nevét!");
                    String nev = input.nextLine();
                    System.out.println("Add meg a törlésre szánt felhasználói fiók jelszavát!");
                    String jelszo = input.nextLine();
                    boolean match = false;
                    for (int i = 0; i < users.size(); i++)
                    {
                        if (users.get(i).getName().equals(nev) && users.get(i).getPass().equals(jelszo))
                        {
                            users.remove(i);
                            match = true;
                        }
                    }
                    if (match)
                    {
                        System.out.println("Sikeres törlés.");
                        akt = Register.Choose(akt, input);
                    }
                    else
                    {
                        System.out.println("Nem találtam a megadott felhasználót!");
                        akt = Register.Choose(akt, input);
                    }
                }
                else if (users.size() == 1)
                {
                    System.out.println("Biztosan törlöd az egyetlen felhasználót?(" + users.get(0).getName() + ") (y/n)");
                    if ("y".equals(input.nextLine()))
                    {
                        users.remove(0);
                        System.out.println("Sikeres törlés.");
                        akt = Register.Choose(akt, input);
                    }
                    else
                    {
                        System.out.println("Nem történt módosítás.");
                        akt = Register.Choose(akt, input);
                    }
                }
                else
                {

                    System.out.println("Nincs regisztált felhasználó.");
                    akt = Register.Choose(akt, input);
                }
            }
            else if (akt == 3)
            {
                    System.out.println("Add meg a felhasználó nevét!");
                    String nev = input.nextLine();
                    System.out.println("Add meg a jelszavát!");
                    String jelszo = input.nextLine();
                    for (int i = 0; i < users.size(); i++)
                    {
                        if (users.get(i).getName().equals(nev) && users.get(i).getPass().equals(jelszo))
                        {
                            System.out.println("Add meg melyik értéket akarod felülírni!(név/lakcím/e-mail/jelszó/életkor) (több felülírása esetén add meg az összes felülírni kivánt tulajdonságot");
                            String s = input.nextLine();
                            if (s.contains("név"))
                            {
                                System.out.println("Add meg az új nevet!");
                                users.set(i, new Register(new String[]{input.nextLine(), Integer.toString(users.get(i).getCím().getIranyitoszam())+" "+users.get(i).getCím().getTelepules()+","+users.get(i).getCím().getUtca(), users.get(i).getEmail(), users.get(i).getPass(),users.get(i).getPass(), Integer.toString(users.get(i).getAge())}));
                            }
                            if (s.contains("lakcím"))
                            {
                                System.out.println("Add meg az új lakcímet!");
                                users.set(i, new Register(new String[]{users.get(i).getName(), input.nextLine(), users.get(i).getEmail(), users.get(i).getPass(), Integer.toString(users.get(i).getAge())}));
                            }
                            if (s.contains("e-mail"))
                            {
                                System.out.println("Add meg az új e-mailt!");
                                users.set(i, new Register(new String[]{users.get(i).getName(), Integer.toString(users.get(i).getCím().getIranyitoszam())+" "+users.get(i).getCím().getTelepules()+","+users.get(i).getCím().getUtca(), input.nextLine(), users.get(i).getPass(),users.get(i).getPass(), Integer.toString(users.get(i).getAge())}));
                            }
                            if (s.contains("jelszó"))
                            {
                                System.out.println("Add meg az új jelszót!");
                                users.set(i, new Register(new String[]{users.get(i).getName(),Integer.toString(users.get(i).getCím().getIranyitoszam())+" "+users.get(i).getCím().getTelepules()+","+users.get(i).getCím().getUtca(), users.get(i).getEmail(), input.nextLine(),input.nextLine(), Integer.toString(users.get(i).getAge())}));
                            }
                            if (s.contains("életkor"))
                            {
                                System.out.println("Add meg az új életkort!");
                                users.set(i, new Register(new String[]{users.get(i).getName(),Integer.toString(users.get(i).getCím().getIranyitoszam())+" "+users.get(i).getCím().getTelepules()+","+users.get(i).getCím().getUtca(), users.get(i).getEmail(), users.get(i).getPass(),users.get(i).getPass(), input.nextLine()}));
                            }
                            System.out.println("Sikeres felülírás!");
                            akt = Register.Choose(akt, input);
                        }
                        else
                        {
                            System.out.println("Nincs ilyen felhasználó.");
                            akt = Register.Choose(akt, input);
                        }
                    }
                }
                else
                {
                    System.out.println("Rosz utasítás, próbáld újra!");
                    akt = Register.Choose(akt, input);
                }
        }
    }
}


