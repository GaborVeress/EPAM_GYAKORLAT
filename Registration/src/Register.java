import java.util.Scanner;

/**
 * Created by Student on 6/26/2017.
 */
public class Register
{
    private String name,email,pass;
    private Address cím;
    private int age;

    public Register(String [] a)
    {
        boolean error=false;
        if (a[0].contains(" "))
        {
            name = a[0];
        }
        else
        {
            System.out.println("A megadott név nem megfelelő! Próbáld újra.");
            error=true;
            name="";
        }
        cím=new Address(a[1]);
        if(a[2].contains("@") && a[2].contains("."))
        {
            email=a[2];
        }
        else
        {
            email="";
            System.out.println("A megadott e-mail nem megfelelő! Próbáld újra.");
        }
        if(a[3].equals(a[4])&& a[3]!="" && a[3].split("[a-zA-Z0-9 ]").length>1 && a[3].matches(".*\\d+.*"))
        {
            pass=a[3];
        }
        else
        {
            pass="";
            System.out.println("A megadott jelszó nem megfelelő! Próbáld újra.");
        }
        try
        {
            age=Integer.parseInt(a[5]);
        }
        catch (Exception e)
        {
            System.out.println("A megadott kor nem megfelelő! Próbáld újra.");
            age=0;
        }
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPass()
    {
        return pass;
    }

    public void setPass(String pass)
    {
        this.pass = pass;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public Address getCím()
    {
        return cím;
    }

    public void setCím(Address cím)
    {
        this.cím = cím;
    }
    public static int Choose(int aktualis, Scanner input)
    {
        System.out.println("Funkciók: 1-hozzáadás");
        System.out.println("          2-törlés");
        System.out.println("          3-adat felülírása");
        System.out.println("          0-kilépés");
        aktualis=Integer.parseInt(input.nextLine());
        return aktualis;
    }
}
