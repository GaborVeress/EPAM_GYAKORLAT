import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by Student on 6/23/2017.
 */
class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        //Bábel-hal
        ArrayList<String> english=new ArrayList<String>();
        ArrayList<String> foreign=new ArrayList<String>();
        int index=0;
        boolean input=true;
        System.out.print("Add azokat a szavakat!");
        while(input)
        {
            String s=scanner.nextLine();
            english.add(index, s.split("[ ]")[0]);
            foreign.add(index, s.split("[ ]")[1]);
            index++;
        }
        input=true;
        System.out.println("Add meg a lefordítandó szöveget!");
        while(scanner.hasNext())
        {
            String sz=scanner.nextLine();
            if(sz.equals(""))
            {
                input =false;
            }
            else if (input==true)
            {
                boolean volt=false;
                for(int j=0;j<foreign.size();j++)
                {

                    if(foreign.get(j).equals(sz))
                    {
                        System.out.println(english.get(j));
                        break;
                    }
                    else if(sz!=foreign.get(j) && j==foreign.size()-1 && !volt)
                    {
                        System.out.println("eh");
                    }
                }
            }
        }
    }
}
