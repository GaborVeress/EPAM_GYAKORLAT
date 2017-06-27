/**
 * Created by Student on 6/26/2017.
 */
public class Address implements Validate
{
    private String telepules,utca;
    private int iranyitoszam;
    public Address(String s)
    {
        try
        {
            iranyitoszam=Integer.parseInt(s.split("[ ]")[0]);
        }
        catch (Exception e)
        {
            System.out.println("Hibás lakcím megadás!");
            iranyitoszam=0;
        }
        if(s!="")
        {
            telepules = s.split("[,]")[1].split(" ")[0].split("[ ]")[1];
            utca += s.split("[,]")[1];
        }
    }

    public String getTelepules()
    {
        return telepules;
    }

    public void setTelepules(String telepules) {
        this.telepules = telepules;
    }

    public String getUtca() {
        return utca;
    }

    public void setUtca(String utca) {
        this.utca = utca;
    }

    public int getIranyitoszam() {
        return iranyitoszam;
    }

    public void setIranyitoszam(int iranyitoszam) {
        this.iranyitoszam = iranyitoszam;
    }
    @Override
    public boolean Validator(Address cím)
    {
        if ("".equals(cím.utca) || "".equals(cím.telepules) || cím.iranyitoszam == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
