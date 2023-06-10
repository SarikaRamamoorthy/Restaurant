import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class NonVegStuffs {
    private Connection con = null;
    public NonVegStuffs(Connection con){
        this.con = con;
    }
    public void displayNonVegStuffs(){
        // Scanner sc = new Scanner(System.in);
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
            }while(res.next() && (res.getInt(1)<=7));
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |    Noodles:                              |                  |   ");
            System.out.println("       |                                          |                  |   ");
            do{
                String info = res.getInt(1)+"  "+res.getString(2);
                String price = res.getInt(3)+"";
                info = String.format("%-36s",info);
                price = String.format("%-11s",price);
                System.out.println("       |      "+info+"|       "+price+"|");
            }while(res.next() && (res.getInt(1)<=10));
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |    Rice:                                 |                  |   ");
            System.out.println("       |                                          |                  |   ");
            do{
                String info = res.getInt(1)+"  "+res.getString(2);
                String price = res.getInt(3)+"";
                info = String.format("%-36s",info);
                price = String.format("%-11s",price);
                System.out.println("       |      "+info+"|       "+price+"|");
            }while(res.next() && (res.getInt(1)<=13));
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |    Briyani:                              |                  |   ");
            System.out.println("       |                                          |                  |   ");
            do{
                String info = res.getInt(1)+"  "+res.getString(2);
                String price = res.getInt(3)+"";
                info = String.format("%-36s",info);
                price = String.format("%-11s",price);
                System.out.println("       |      "+info+"|       "+price+"|");
            }while(res.next() && (res.getInt(1)<=20));
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |__________________________________________|__________________|  ");
            System.out.println();
            System.out.print("             Enter your favourite Nonveg stuff    ≧◠‿◠≦   ");
            // int favstarter = sc.nextInt();
            System.out.println();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
