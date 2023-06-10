import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SweetStuffs {
    private Connection con = null;
    private String[] sweetStuffsName = new String[30];
    private String[] OrderedName = new String[30];
    private int[] sweetStuffsPrice = new int[30];
    private int[] OrderedPrice = new int[30];
    public SweetStuffs(Connection con){
        this.con = con;
    }
    public void displaySweetStuffs(){
        Scanner sc = new Scanner(System.in);
        int index = 0;
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
            }
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |__________________________________________|__________________|  ");
            System.out.println();
            while(true){
            int index1 = 0;
            System.out.println("             Enter your favourite sweet stuff    ≧◠‿◠≦     (or)");
            System.out.print("        Enter zero (0) to finish ordering sweetstuff...        ");
            int favsweetstuff = sc.nextInt();
            System.out.println();
            if(favsweetstuff == 0){
                break;
            }
            else if((favsweetstuff > 0)&&(favsweetstuff < 11)){
                OrderedName[index1] = sweetStuffsName[favsweetstuff-1];
                OrderedPrice[index1] = sweetStuffsPrice[favsweetstuff-1];
                index1++;
            }
            else{
                System.out.println("             Invalid sweet stuff ...");
            }
        }
            System.out.println();
            sc.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
