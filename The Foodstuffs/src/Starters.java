// import java.util.Scanner;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class Starters {
    private Connection con = null;
    public Starters(Connection con){
        this.con = con;
    }
    public void displaystarters(){
        // Scanner sc = new Scanner(System.in);
        System.out.println();
        try{
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("Select * from starterstuffs");
            System.out.println("       +==========================================+==================+    ");
            System.out.println("       |          STARTERSTUFF'S MENU             |      PRICE       |    ");
            System.out.println("       |==========================================|==================+    ");
            System.out.println("       |                                          |                  |    ");
            System.out.println("       |    Veg Starters:                         |                  |    ");
            System.out.println("       |                                          |                  |   ");
            while(res.next()&&(res.getInt("SNo")<=10)){
                String info = res.getInt(0)+" "+res.getString(1);
                String price = res.getInt(2)+"";
                info = String.format("%-42s",info);
                price = String.format("%-18s",price);
                System.out.println("       |"+info+"|"+price+"|");
            }
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |    Non-veg Starters:                     |                  |   ");
            System.out.println("       |                                          |                  |   ");
            do{
                String info = res.getInt(0)+" "+res.getString(1);
                String price = res.getInt(2)+"";
                info = String.format("%-42s",info);
                price = String.format("%-18s",price);
                System.out.println("       |"+info+"|"+price+"|");
            }while(res.next());
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |__________________________________________|__________________|  ");
            

        }
        catch(Exception e){
            e.printStackTrace();
            
        }
        System.out.println();
        System.out.print("             Enter your favourite starter stuff    ≧◠‿◠≦   ");
        // int favstarter = sc.nextInt();
        System.out.println();
    }
}
























// System.out.println("       |      1  Chilly Paneer                    |       158        |   ");
// System.out.println("       |      2  Paneer Tikka                     |       260        |   ");
// System.out.println("       |      3  Pepper Paneer                    |       210        |   ");
// System.out.println("       |      4  Paneer Manchurian                |       180        |   ");
// System.out.println("       |      5  Tandoori Mushroom                |       260        |   ");
// System.out.println("       |      6  Gobi Manchurian                  |       133        |    ");
// System.out.println("       |      7  Babycorn 65                      |       180        |   ");
// System.out.println("       |      8  Babycorn Hot Pepper              |       180        |   ");
// System.out.println("       |      9  Babycorn Manchurian              |       180        |   ");
// System.out.println("       |     10  Chilly BabyCorn Manchurian       |       115        |   ");
// System.out.println("       |     11 Mutton Chukka                     |       157        |   ");
// System.out.println("       |     12 Mutton Milagu Fry                 |       415        |   ");
// System.out.println("       |     13 Mutton Keema Ball                 |       169        |   ");
// System.out.println("       |     14 Mutton Curry                      |       260        |   ");
// System.out.println("       |     15 Pepper Mutton                     |       315        |   ");
// System.out.println("       |     16 Prawns 65                         |       219        |   ");
// System.out.println("       |     17 Prawns Manchurian                 |       280        |   ");
// System.out.println("       |     18 Dragon Prawns                     |       280        |   ");
// System.out.println("       |     19 Chilly Prawns                     |       250        |   ");
// System.out.println("       |     20 Boneless Pepper Chicken           |       210        |   ");
// System.out.println("       |     21 Pepper Chicken                    |       145        |   ");
// System.out.println("       |     22 Chilly Chicken                    |       133        |   ");
// System.out.println("       |     23 Chicken Lollipop                  |       251        |   ");
// System.out.println("       |     24 Chicken 777                       |       140        |   ");
// System.out.println("       |     25 Chettinad Chicken                 |       251        |   ");
// System.out.println("       |     26 Honey Chilly Chicken              |       330        |   ");
// System.out.println("       |     27 Basil Chilly Chicken              |       330        |   ");
// System.out.println("       |     28 Chicken Prikpan                   |       330        |   ");
// System.out.println("       |     29 Chicken Dry                       |       330        |   ");
// System.out.println("       |     30 Dragon Chicken                    |       169        |   ");