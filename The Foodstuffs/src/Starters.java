// import java.util.Scanner;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;

public class Starters {
    private Connection con = null;
    private String[] StartersName = new String[30];
    private String[] OrderedName = new String[30];
    private int[] StartersPrice = new int[30];
    private int[] OrderedPrice = new int[30];
    public Starters(Connection con){
        this.con = con;
    }
    public void displaystarters(){
        int index = 0;
        Scanner sc = new Scanner(System.in);
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
                StartersPrice[index] = res.getInt(3);
                StartersName[index] = res.getString(2);
                String info = res.getInt(1)+" "+StartersName[index];
                String price = StartersPrice[index]+"";
                info = String.format("%-37s",info);
                price = String.format("%-11s",price);
                System.out.println("       |     "+info+"|       "+price+"|");
                index++;
            }
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |    Non-veg Starters:                     |                  |   ");
            System.out.println("       |                                          |                  |   ");
            do{
                StartersPrice[index] = res.getInt(3);
                StartersName[index] = res.getString(2);
                String info = res.getInt(1)+" "+StartersName[index];
                String price = StartersPrice[index]+"";
                info = String.format("%-37s",info);
                price = String.format("%-11s",price);
                System.out.println("       |     "+info+"|       "+price+"|");
                index++;
            }while(res.next());
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |__________________________________________|__________________|  ");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println();
        while(true){
            int index1 = 0;
            System.out.println("             Enter your favourite starter stuff    ≧◠‿◠≦    (or)");
            System.out.print("           Enter zero (0) to finish ordering starters...    ");
            int favstarter = sc.nextInt();
            System.out.println();
            if(favstarter == 0){
                break;
            }
            else if((favstarter > 0)&&(favstarter < 31)){
                OrderedName[index1] = StartersName[favstarter-1];
                OrderedPrice[index1] = StartersPrice[favstarter-1];
                index1++;
            }
            else{
                System.out.println("             Invalid starter stuff ...");
            }
        }
        System.out.println();
        sc.close();
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