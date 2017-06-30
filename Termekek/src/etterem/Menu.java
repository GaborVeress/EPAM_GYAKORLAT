package etterem;

import menza.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Student on 6/28/2017.
 */
public class Menu implements Etlap
{
    private String datum;
    private int termekszam;
    ArrayList<Termek> termekek= new ArrayList<Termek>();
    public Menu (String datum, ArrayList<Termek> termekek)
    {
        this.datum =datum;
        this.termekek=termekek;
    }
    public String getDatum()
    {
        return datum;
    }
    public int getTermekszam()
    {
        return termekszam;
    }
    @Override
    public void felvesz(Termek termék)
    {
        termekek.add(termekszam,termék);
        termekszam++;
    }
    @Override
    public void töröl(Termek termék) throws NincsIlyenTermékException
    {
        int torolt=0;
        for (int i=0;i<termekek.size();i++)
        {
            if (termekek.get(i).compareTo(termék)==0)
            {
                termekek.remove(i);
                torolt++;
            }
        }
        if (torolt==0)
        {
            throw new NincsIlyenTermékException();
        }

    }
    @Override
    public String toString()
    {
        return datum;
    }
    @Override
    public int termékekSzáma(int fajta)
    {
        int db = 0;
        switch (fajta) {
            case 1: {
                for (Termek item: termekek)
                {
                    if (item instanceof Etel) {
                        Etel e= (Etel) item;
                        if(e.isSoup())
                        {
                            db++;
                        }
                    }
                }
                break;
            }
            case 2: {
                for (Termek item: termekek)
                {
                    if (item instanceof Etel) {
                        Etel e= (Etel) item;
                        if(!e.isSoup())
                        {
                            db++;
                        }
                    }
                }
                break;
            }
            case 3: {
                for (Termek item: termekek)
                {
                    if (item instanceof Ital) {
                        Ital e= (Ital) item;
                        if(e.isAlcoholic())
                        {
                            db++;
                        }
                    }
                }
                break;
            }
            case 4:
            {
                for (Termek item: termekek)
                {
                    if (item instanceof Ital) {
                        Ital e= (Ital) item;
                        if(!e.isAlcoholic())
                        {
                            db++;
                        }
                    }
                }
                break;
            }

            default: {
                throw new IllegalArgumentException();
            }
        }
        return db;
    }
    @Override
    public void kiír(String fájlnév)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter((new FileWriter(fájlnév)));
            writer.write(this.toString());
            writer.newLine();
            for (Termek item : termekek)
            {
                writer.write(item.toString());
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public Termek[] backAmount(String amount)
    {
        ArrayList<Termek> mennyiség = new ArrayList<Termek>();
        for (Termek item : termekek)
        {
            if (item.getMennyisegiegyseg().equals(amount))
            {
                mennyiség.add(item);
            }
        }
        Termek[] mennyiseg = new Termek[mennyiség.size()];
        return mennyiseg = mennyiség.toArray(mennyiseg);
    }
}
