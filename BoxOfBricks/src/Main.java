
import java.util.Scanner;

public class Main
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        int oszlopok = 0;
        int setNumber=0;
        while ((oszlopok=input.nextInt())!=0)
        {
            int[] magassag = new int[oszlopok];
            setNumber++;
            int max=0;
            for (int i = 0; i < oszlopok; i++)
            {
                magassag[i] = input.nextInt();
                max+=magassag[i];
            }
            max/=oszlopok;
            int lepesek=0;
            for(int i=0;i<oszlopok;i++)
            {
                if(magassag[i]>max)
                {
                    lepesek+=magassag[i]-max;
                    magassag[i]=max;

                }
            }
            System.out.println("Set #"+setNumber);
            System.out.println("The minimum number of moves is " + lepesek + ".");
            System.out.println();
        }
    }
}
