import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class VegStuffs {
    private Connection con = null;
    public VegStuffs(Connection con){
        this.con = con;
    }
    public void displayVegStuffs(){
        // Scanner sc = new Scanner(System.in);
        try{
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("select * from vegstuffs");
            System.out.println();
            System.out.println("       +==========================================+==================+    ");
            System.out.println("       |            VEGSTUFF'S MENU               |      PRICE       |    ");
            System.out.println("       |==========================================|==================+    ");
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |    Tiffin:                               |                  |   ");
            System.out.println("       |                                          |                  |   ");
            while(res.next() && (res.getInt(1)<=10)){
                String info = res.getInt(1)+"  "+res.getString(2);
                String price = res.getInt(3)+"";
                info = String.format("%-36s",info);
                price = String.format("%-11s",price);
                System.out.println("       |      "+info+"|       "+price+"|");
            }
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |    Gravy:                                |                  |   ");
            System.out.println("       |                                          |                  |   ");
            do{
                String info = res.getInt(1)+"  "+res.getString(2);
                String price = res.getInt(3)+"";
                info = String.format("%-36s",info);
                price = String.format("%-11s",price);
                System.out.println("       |      "+info+"|       "+price+"|");
            }while(res.next() && (res.getInt(1)<=15));
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |    Noodles:                              |                  |   ");
            System.out.println("       |                                          |                  |   ");
            do{
                String info = res.getInt(1)+"  "+res.getString(2);
                String price = res.getInt(3)+"";
                info = String.format("%-36s",info);
                price = String.format("%-11s",price);
                System.out.println("       |      "+info+"|       "+price+"|");
            }while(res.next() && (res.getInt(1)<=17));
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |    Rice:                                 |                  |   ");
            System.out.println("       |                                          |                  |   ");
            do{
                String info = res.getInt(1)+"  "+res.getString(2);
                String price = res.getInt(3)+"";
                info = String.format("%-36s",info);
                price = String.format("%-11s",price);
                System.out.println("       |      "+info+"|       "+price+"|");
            }while(res.next() && (res.getInt(1)<=20));
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |    Briyani & Pulao:                      |                  |   ");
            System.out.println("       |                                          |                  |   ");
            do{
                String info = res.getInt(1)+"  "+res.getString(2);
                String price = res.getInt(3)+"";
                info = String.format("%-36s",info);
                price = String.format("%-11s",price);
                System.out.println("       |      "+info+"|       "+price+"|");
            }while(res.next() && (res.getInt(1)<=25));
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |__________________________________________|__________________|  ");
            System.out.println();
            System.out.print("             Enter your favourite Veg stuff    ≧◠‿◠≦   ");
            // int favstarter = sc.nextInt();
            System.out.println();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}


















// System.out.println("       |      1  Pongal                           |        45        |   ");
// System.out.println("       |      2  Idly                             |        30        |   ");
// System.out.println("       |      3  Poori                            |        50        |   ");
// System.out.println("       |      4  Sevai                            |        40        |   ");
// System.out.println("       |      5  Paper Roast                      |       175        |   ");
// System.out.println("       |      6  Family Roast                     |       500        |    ");
// System.out.println("       |      7  Parotta                          |        48        |   ");
// System.out.println("       |      8  Chappati                         |        45        |   ");
// System.out.println("       |      9  Mushroom Kothu Parotta           |        75        |   ");
// System.out.println("       |     10 Curd Semiya                       |        50        |   ");
// System.out.println("       |     11 Paneer Butter Masala              |       110        |   ");
// System.out.println("       |     12 Paneer Tikka Masala               |       110        |   ");
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