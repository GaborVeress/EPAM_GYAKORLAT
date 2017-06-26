import jdk.jfr.events.ExceptionThrownEvent;

/**
 * Created by Student on 6/26/2017.
 */
public class Register
{
    private String name,email,pass,cím;
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
        int counter = 0;
        for( int i=0; i<a[1].length(); i++ ) {
            if( a[1].charAt(i) == ',' ) {
                counter++;
            }
        }
        if(counter==4)
        {
            cím=a[1];
        }
        else
        {
            cím="";
            System.out.println("A megadott cím nem megfelelő! Próbáld újra!");
        }
        if(a[2].contains("@") && a[1].contains(".") && !error)
        {
            email=a[2];
        }
        else
        {
            email="";
            System.out.println("A megadott e-mail nem megfelelő! Próbáld újra.");
        }
        if(a[3].equals(a[4])&& a[3]!="")
        {
            pass=a[3];
        }
        else
        {
            pass="";
            System.out.println("A megadott jelszók nem egyeznek meg! Próbáld újra.");
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

    public String getCím()
    {
        return cím;
    }

    public void setCím(String cím)
    {
        this.cím = cím;
    }
}
