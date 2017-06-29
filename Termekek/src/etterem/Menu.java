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
        for (int i=0;i<termekek.size();i++)
        {
            if (termekek.get(i).compareTo(termék)==0)
            {
                termekek.remove(i);
            }
        }
    }
    @Override
    public String toString()
    {
        return "Menu{" +
                "datum=\'" + datum + '\'' +
                ", termekszam=" + termekszam +
                ", termekek=" + termekek +
                '}';
    }
    @Override
    public int termékekSzáma(int fajta)
    {
        int vissza=0;
        switch (fajta)
        {
            case 1:
            {
                vissza= Etel.leves;
                break;
            }
            case 2:
            {
                vissza=Etel.foetel;
                break;
            }
            case 3:
            {
                vissza=Ital.alcoholicd;
                break;
            }
            case 4:
            {
                vissza=Ital.nonalcoholic;
                break;
            }
            default:
            {
                throw  new IllegalArgumentException();
            }
        }
        return vissza;
    }
    @Override
    public void kiír(String fájlnév)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter((new FileWriter(fájlnév)));
            writer.write(termekek.toString());
            writer.newLine();
            for (Termek item : termekek)
            {
                writer.write(item.getNev() + ", " + item.getMennyisegiegyseg() + ", " + item.getEgysegar() + " Ft");
                writer.newLine();
            }
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
