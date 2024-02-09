import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class FruitStuffs {
    private Connection con = null;
    private String[] FruitStuffsName = new String[10];
    private String[] OrderedName = new String[10];
    private int[] FruitStuffsPrice = new int[10];
    private int[] OrderedPrice = new int[10];
    Scanner sc = null;
    public FruitStuffs(Connection con,Scanner s){
        this.con = con;
        this.sc = s;
    }
    public void displayFruitStuffs(){
        int index = 0;
        int index1 = 0;

        try{
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("select * from fruitstuffs");
            System.out.println();
            System.out.println("       +==========================================+==================+    ");
            System.out.println("       |            FRUITSTUFF'S MENU             |      PRICE       |    ");
            System.out.println("       |==========================================|==================+    ");
            System.out.println("       |                                          |                  |   ");
            while(res.next()){
                FruitStuffsPrice[index] = res.getInt(3);
                FruitStuffsName[index] = res.getString(2);
                String info = res.getInt(1)+" "+FruitStuffsName[index];
                String price = FruitStuffsPrice[index]+"";
                info = String.format("%-36s",info);
                price = String.format("%-11s",price);
                System.out.println("       |      "+info+"|       "+price+"|");
                index++;
            }
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |__________________________________________|__________________|  ");
            System.out.println();
            while(true){
                System.out.println("        Enter your favourite Fruit stuff    ≧◠‿◠≦     (or)");
                System.out.print("        Enter zero (0) to finish ordering Fruitstuff...        ");
                int favfruitstuff = sc.nextInt();
                System.out.println();
                int quantity = 1;
                if(favfruitstuff != 0){
                    System.out.print("        Enter the quantity: ");
                    quantity = sc.nextInt();
                }
                System.out.println();
                if(favfruitstuff == 0){
                    Bill bill = new Bill();
                    bill.billGeneration(OrderedName, OrderedPrice);
                    break;
                }
                else if((favfruitstuff > 0)&&(favfruitstuff < 11)){
                    OrderedName[index1] = FruitStuffsName[favfruitstuff-1];
                    OrderedPrice[index1] = FruitStuffsPrice[favfruitstuff-1]*quantity;
                    index1++;
                }
                else{
                    System.out.println("             Invalid fruit stuff ...");
                }
            }
            System.out.println();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
