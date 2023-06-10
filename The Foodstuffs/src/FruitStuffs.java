import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class FruitStuffs {
    private Connection con = null;
    private String[] FruitStuffsName = new String[30];
    private String[] OrderedName = new String[30];
    private int[] FruitStuffsPrice = new int[30];
    private int[] OrderedPrice = new int[30];
    public FruitStuffs(Connection con){
        this.con = con;
    }
    public void displayFruitStuffs(){
        Scanner sc = new Scanner(System.in);
        int index = 0;
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
            }
            System.out.println("       |                                          |                  |   ");
            System.out.println("       |__________________________________________|__________________|  ");
            System.out.println();
            while(true){
            int index1 = 0;
            System.out.println("             Enter your favourite Fruit stuff    ≧◠‿◠≦     (or)");
            System.out.print("        Enter zero (0) to finish ordering Fruitstuff...        ");
            int favfruitstuff = sc.nextInt();
            System.out.println();
            if(favfruitstuff == 0){
                break;
            }
            else if((favfruitstuff > 0)&&(favfruitstuff < 11)){
                OrderedName[index1] = FruitStuffsName[favfruitstuff-1];
                OrderedPrice[index1] = FruitStuffsPrice[favfruitstuff-1];
                index1++;
            }
            else{
                System.out.println("             Invalid fruit stuff ...");
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
