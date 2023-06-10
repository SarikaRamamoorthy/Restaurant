import java.sql.Connection;
import java.util.Scanner;

public class Menu {
    private Connection con = null;
    private Scanner s = new Scanner(System.in);
    public Menu(Connection con){
        this.con = con;
    }

   public void displayMenu(){
        System.out.println();
        System.out.println("       +===============================+    ");
        System.out.println("       |        FOODSTUFF'S MENU       |    ");
        System.out.println("       |===============================|    ");
        System.out.println("       |        1. Starters            |    ");
        System.out.println("       |        2. Veg Stuffs          |    ");
        System.out.println("       |        3. Non-veg Stuffs      |    ");
        System.out.println("       |        4. Sweet Stuffs        |    ");
        System.out.println("       |        5. Fruit Stuffs        |    ");
        System.out.println("       |        6. Back                |    ");
        System.out.println("       |_______________________________|    ");
        System.out.println();
        System.out.print("        Enter your favourite choice    ≧◠‿◠≦   ");
        int favchoice = s.nextInt();
        System.out.println();
        if(favchoice == 1){
            //starters
            Starters display = new Starters(con);
            display.displaystarters();
        }
        else if(favchoice == 2){
            //veg 
            VegStuffs display = new VegStuffs(con);
            display.displayVegStuffs();
        }
        else if(favchoice == 3){
            //nonveg
            NonVegStuffs display = new NonVegStuffs(con);
            display.displayNonVegStuffs();
        }
        else if(favchoice == 4){
            //sweet
            SweetStuffs display = new SweetStuffs(con);
            display.displaySweetStuffs();   
        }
        else if(favchoice == 5){
            //fruit
            FruitStuffs display = new FruitStuffs(con);
            display.displayFruitStuffs();       
        }
        else if(favchoice == 6){
            //TODO
        }
        else{
            System.out.println("        Invalid choice of selection ");
        }
    }
}
