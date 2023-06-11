import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SweetStuffs {
    private Connection con = null;
    private String[] sweetStuffsName = new String[10];
    private String[] OrderedName = new String[10];
    private int[] sweetStuffsPrice = new int[10];
    private int[] OrderedPrice = new int[10];
    Scanner sc = null;
    public SweetStuffs(Connection con,Scanner s){
        this.con = con;
        this.sc = s;
    }
    public void displaySweetStuffs(){
        int index = 0;
        int index1 = 0;
        try{
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("select * from sweetstuffs");
            System.out.println();
            System.out.println("       +==========================================+==================+    ");
            System.out.println("       |            SWEETSTUFF'S MENU             |      PRICE       |    ");
            System.out.println("       |==========================================|==================+    ");
            System.out.println("       |                                          |                  |   ");
            while(res.next()){
                sweetStuffsPrice[index] = res.getInt(3);
                sweetStuffsName[index] = res.getString(2);
                String info = res.getInt(1)+" "+sweetStuffsName[index];
                String price = sweetStuffsPrice[index]+"";
                info = String.format("%-36s",info);
                price = String.format("%-11s",price);
                System.out.println("       |      "+info+"|       "+price+"|");
                index++;
            }
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |__________________________________________|__________________|  ");
            System.out.println();
            while(true){
                System.out.println("        Enter your favourite sweet stuff    ≧◠‿◠≦     (or)");
                System.out.print("        Enter zero (0) to finish ordering sweetstuff...        ");
                int favsweetstuff = sc.nextInt();
                System.out.println();
                int quantity = 1;
                if(favsweetstuff != 0){
                    System.out.print("        Enter the quantity: ");
                    quantity = sc.nextInt();
                }
                System.out.println();
                if(favsweetstuff == 0){
                    Bill bill = new Bill();
                    bill.billGeneration(OrderedName, OrderedPrice);
                    break;
                }
                else if((favsweetstuff > 0)&&(favsweetstuff < 11)){
                    OrderedName[index1] = sweetStuffsName[favsweetstuff-1];
                    OrderedPrice[index1] = sweetStuffsPrice[favsweetstuff-1]*quantity;
                    index1++;
                }
                else{
                    System.out.println("             Invalid sweet stuff ...");
                }
            }
            System.out.println();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
