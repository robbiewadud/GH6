import java.util.*;
public class Database
{
    private static String n;
    private static int am;
    
    public Database(String name, int amount)
    {
        n = name;
        am = amount;
    }
    
    public int editAmount(int x)
    {
        int y = x;
        return y++;
    }
    
    public String getName()
    {
        return n;
    }
   
    public int getAmount()
    {
        return am;
    }
}
