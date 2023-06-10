import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SweetStuffs {
    private Connection con = null;
    public SweetStuffs(Connection con){
        this.con = con;
    }
    public void displaySweetStuffs(){
        // Scanner sc = new Scanner(System.in);
        try{
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("select * from sweetstuffs");
            System.out.println();
            System.out.println("       +==========================================+==================+    ");
            System.out.println("       |            SWEETSTUFF'S MENU             |      PRICE       |    ");
            System.out.println("       |==========================================|==================+    ");
            System.out.println("       |                                          |                  |   ");
            while(res.next()){
                String info = res.getInt(1)+"  "+res.getString(2);
                String price = res.getInt(3)+"";
                info = String.format("%-36s",info);
                price = String.format("%-11s",price);
                System.out.println("       |      "+info+"|       "+price+"|");
            }
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |__________________________________________|__________________|  ");
            System.out.println();
            System.out.print("             Enter your favourite sweet stuff    ≧◠‿◠≦   ");
            // int favstarter = sc.nextInt();
            System.out.println();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
