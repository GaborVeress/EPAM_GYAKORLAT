package menza;

/**
 * Created by Student on 6/28/2017.
 */
public interface Etlap
{
    // új ételt vagy italt vesz fel az étlapra;
    // ha már létezett a termék, nem csinál semmit
    void felvesz(Termek termék);
    // törli az étlapról a megadott ételt vagy italt;
    // ha ilyen nem létezik, kivételt dob
    void töröl(Termek termék) throws NincsIlyenTermékException;

    // visszaadja az étlapon szereplő, megadott fajtájú termékek számát;
    // a fajta lehet: 1 – leves, 2 – főétel, 3 – alkoholos ital, 4 – alkoholmentes
    // ital, minden más esetben IllegalArgumentException kivételt dob
    int termékekSzáma(int fajta);

    // kiírja a megadott állományba soronként az étlapon szereplő termékeket:
    // először az ételeket, majd az italokat, mindkét listát a természetes
    // rendezettségnek megfelelő sorrendben, a két lista között egy üres sorral
    void kiír(String fájlnév);
}
