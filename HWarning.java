import java.sql.*;
import java.util.*;
import java.io.*;

public class HWarning
{
    public static ArrayList<String> tempNames = new ArrayList <String>();    

    public static void main(String[] args) throws Exception
    {
        Database [] gas = dataFill();
        Database [] ele = dataFill();
        Database [] unemp = dataFill();
        Database [] ss = dataFill();
        ArrayList<Database> ML = new ArrayList <Database>(); 
        boolean flag=true;
        //try{
        //Class.forName("Database Name");
        int z = 0;

        while(z < 4)
        {

            if(z == 0)
            { //Gas Company
                Connection Gct = null;
                Statement Gst = null;
                //Gct = DriverManager.getConnection("C:Users:Claire:Documents:GH6 SQL Files:Laclede Gas Example.sql");
                //Gct.setAutoCommit(false);
                //Gst = Gct.createStatement();
                //ResultSet Gdb = Gst.executeQuery("");

                for(int x=0; x<10; x++) //temp java code
                //while(Gbd.next()) //sql code
                //if(Edb.getBoolean("ElectricityBillPayment"))
                {
                    ML.add(gas[x]);
                }

                //Gdb.close();
                //Gst.close();
                //Gct.close();

            }
            else if(z==1)
            {
                //Electric Company
                Connection Ect = null;
                Statement Est = null;
                //Ect = DriverManager.getConnection("C:Users:Claire:Documents:GH6 SQL Files:Ameren Database Example.sql");
                //Ect.setAutoCommit(false);
                //Est = Ect.createStatement();
                //ResultSet Edb = Est.executeQuery("");

                for(int x=0; x<10; x++) //temp java code
                //while(Gbd.next()) //sql code
                //if(Edb.getBoolean("ElectricityBillPayment"))
                {
                    
                    for(int y=0; y<ML.size(); y++)
                    {
                        if(ele[x].getName() == ML.get(y).getName())
                        {
                            Database w = new Database(ML.get(y).getName(), ML.get(y).getAmount() +1);
                            ML.remove(y);
                            ML.add(w);
                            flag=false;
                        }
                    }
                    if(flag)
                    {
                        ML.add(ele[x]);
                    }
                    flag=true;
                }
                
                //Edb.close();
                //Est.close(); 
                //Ect.close();
            }
            else if(z==2)
            {
                //Unemployment Checks
                Connection Uct = null;
                Statement Ust = null;
                //Uct = DriverManager.getConnection("C:Users:Claire:Documents:GH6 SQL Files:MO Department of Label Database Example.sql");
                //Uct.setAutoCommit(false);
                //Ust = Uct.createStatement();
                //ResultSet Udb = Ust.executeQuery("");

                for(int x=0; x<10; x++) //temp java code
                //while(Gbd.next()) //sql code
                //if(Edb.getBoolean("ElectricityBillPayment"))
                {
                    for(int y=0; y<ML.size(); y++)
                    {
                        if(unemp[x].getName() == ML.get(y).getName())
                        {
                            Database w = new Database(ML.get(y).getName(), ML.get(y).getAmount() +1);
                            ML.remove(y);
                            ML.add(w);
                            flag=false;
                        }
                    }
                    if(flag)
                    {
                        ML.add(unemp[x]);
                    }
                    flag = true;
                }

                //Udb.close();
                //Ust.close();
                //Uct.close();
            }
            else if(z==3)
            {

                //Social Services
                Connection Fct = null;
                Statement Fst = null;
                //Fct = DriverManager.getConnection("C:Users:Claire:Documents:GH6 SQL Files:Social Services Example.sql");
                //Fct.setAutoCommit(false);
                //Fst = Fct.createStatement();
                //Fdb = Fst.executeQuery("");

                for(int x=0; x<10; x++) //temp java code
                //while(Gbd.next()) //sql code
                //if(Edb.getBoolean("ElectricityBillPayment"))
                {
                    for(int y=0; y<ML.size(); y++)
                    {
                        if(ss[x].getName() == ML.get(y).getName())
                        {
                            Database w = new Database(ML.get(y).getName(), ML.get(y).getAmount() +1);
                            ML.remove(y);
                            ML.add(w);
                            flag=false;
                        }
                    }
                    if(flag)
                    {
                        ML.add(ss[x]);
                    }
                    flag = true;
                }

                //Fdb.close();
                //Fst.close();
                //Fct.close();
            }
            z++;
        }

            
        //}catch(Exception e) {}

        //System.out.println(ML.size());
        for(int x=0; x<ML.size(); x++)
        {
            System.out.println(ML.get(x).getName());
            if(ML.get(x).getAmount() >= 3)
            {

                tempNames.add(ML.get(x).getName());
            }
        }

        try{
            Scanner fileScanner = new Scanner(new File("PotentialRisks.txt"));
            PrintWriter pw = new PrintWriter(new File("PotentialRisks.txt"));
            pw.println(tempNames);
            pw.close();
        }catch(IOException e) {}

    }

    public static Database[] dataFill()
    {
        Database[] data = new Database[10];

        for(int x = 0; x < 10; x++)
        {
            Random rand = new Random();
            String stemp = "customer" + rand.nextInt(12);
            data[x] = new Database(stemp, 1); 
        }

        return data;
    }

}