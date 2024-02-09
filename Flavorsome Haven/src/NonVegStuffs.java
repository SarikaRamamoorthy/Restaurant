import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class NonVegStuffs {
    private Connection con = null;
    private String[] NonvegStuffsName = new String[30];
    private String[] OrderedName = new String[30];
    private int[] NonvegStuffsPrice = new int[30];
    private int[] OrderedPrice = new int[30];
    Scanner sc = null;
    public NonVegStuffs(Connection con,Scanner s){
        this.con = con;
        this.sc = s;
    }
    public void displayNonVegStuffs(){
        int index = 0 ;  
        int index1 = 0;

        try{
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("select * from Nonvegstuffs");
            System.out.println();
            System.out.println("       +==========================================+==================+    ");
            System.out.println("       |           NONVEGSTUFF'S MENU             |      PRICE       |    ");
            System.out.println("       |==========================================|==================+    ");
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |    Tiffin:                               |                  |   ");
            System.out.println("       |                                          |                  |   ");
            while(res.next() && (res.getInt(1)<=3)){
                NonvegStuffsPrice[index] = res.getInt(3);
                NonvegStuffsName[index] = res.getString(2);
                String info = res.getInt(1)+" "+NonvegStuffsName[index];
                String price = NonvegStuffsPrice[index]+"";
                info = String.format("%-36s",info);
                price = String.format("%-11s",price);
                System.out.println("       |      "+info+"|       "+price+"|");
                index++;
            }
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |    Gravy:                                |                  |   ");
            System.out.println("       |                                          |                  |   ");
            do{
                NonvegStuffsPrice[index] = res.getInt(3);
                NonvegStuffsName[index] = res.getString(2);
                String info = res.getInt(1)+" "+NonvegStuffsName[index];
                String price = NonvegStuffsPrice[index]+"";
                info = String.format("%-36s",info);
                price = String.format("%-11s",price);
                System.out.println("       |      "+info+"|       "+price+"|");
                index++;
            }while(res.next() && (res.getInt(1)<=7));
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |    Noodles:                              |                  |   ");
            System.out.println("       |                                          |                  |   ");
            do{
                NonvegStuffsPrice[index] = res.getInt(3);
                NonvegStuffsName[index] = res.getString(2);
                String info = res.getInt(1)+" "+NonvegStuffsName[index];
                String price = NonvegStuffsPrice[index]+"";
                info = String.format("%-36s",info);
                price = String.format("%-11s",price);
                System.out.println("       |      "+info+"|       "+price+"|");
                index++;
            }while(res.next() && (res.getInt(1)<=10));
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |    Rice:                                 |                  |   ");
            System.out.println("       |                                          |                  |   ");
            do{
                NonvegStuffsPrice[index] = res.getInt(3);
                NonvegStuffsName[index] = res.getString(2);
                String info = res.getInt(1)+" "+NonvegStuffsName[index];
                String price = NonvegStuffsPrice[index]+"";
                info = String.format("%-36s",info);
                price = String.format("%-11s",price);
                System.out.println("       |      "+info+"|       "+price+"|");
                index++;
            }while(res.next() && (res.getInt(1)<=13));
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |    Briyani:                              |                  |   ");
            System.out.println("       |                                          |                  |   ");
            do{
                NonvegStuffsPrice[index] = res.getInt(3);
                NonvegStuffsName[index] = res.getString(2);
                String info = res.getInt(1)+" "+NonvegStuffsName[index];
                String price = NonvegStuffsPrice[index]+"";
                info = String.format("%-36s",info);
                price = String.format("%-11s",price);
                System.out.println("       |      "+info+"|       "+price+"|");
                index++;
            }while(res.next() && (res.getInt(1)<=20));
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |__________________________________________|__________________|  ");
            System.out.println();
            while(true){
                System.out.println("        Enter your favourite nonveg stuff    ≧◠‿◠≦     (or)");
                System.out.print("        Enter zero (0) to finish ordering Nonvegstuff...        ");
                int favnonvegstuff = sc.nextInt();
                System.out.println();
                int quantity = 1;
                if(favnonvegstuff != 0){
                    System.out.print("        Enter the quantity: ");
                    quantity = sc.nextInt();
                }
                System.out.println();
                if(favnonvegstuff == 0){
                    Bill bill = new Bill();
                    bill.billGeneration(OrderedName, OrderedPrice);
                    break;
                }
                else if((favnonvegstuff > 0)&&(favnonvegstuff < 21)){
                    OrderedName[index1] = NonvegStuffsName[favnonvegstuff-1];
                    OrderedPrice[index1] = NonvegStuffsPrice[favnonvegstuff-1]*quantity;
                    index1++;
                }
                else{
                    System.out.println("             Invalid nonveg stuff ...");
                }
            }
        System.out.println();
    }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
