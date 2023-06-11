import java.sql.Connection;
import java.util.Scanner;

public class Menu {
    private Connection con = null;
    private Scanner s = null;
    public Menu(Connection con,Scanner s){
        this.con = con;
        this.s = s;
    }

    public boolean displayMenu(){
        boolean orderFinish = false;
        while(true){
            System.out.println();
            System.out.println("       +===============================+    ");
            System.out.println("       |        FOODSTUFF'S MENU       |    ");
            System.out.println("       |===============================|    ");
            System.out.println("       |        1. Starters            |    ");
            System.out.println("       |        2. Veg Stuffs          |    ");
            System.out.println("       |        3. Non-veg Stuffs      |    ");
            System.out.println("       |        4. Sweet Stuffs        |    ");
            System.out.println("       |        5. Fruit Stuffs        |    ");
            System.out.println("       |        6. Generate bill       |    ");
            System.out.println("       |        7. Exit                |    ");
            System.out.println("       |_______________________________|    ");
            System.out.println();
            System.out.print("        Enter your choice    ≧◠‿◠≦   ");
            int choice = s.nextInt();
            System.out.println();
            if(choice == 1){
                //starters
                Starters display = new Starters(con,s);
                display.displaystarters();
            }
            else if(choice == 2){
                //veg 
                VegStuffs display = new VegStuffs(con,s);
                display.displayVegStuffs();
            }
            else if(choice == 3){
                //nonveg
                NonVegStuffs display = new NonVegStuffs(con,s);
                display.displayNonVegStuffs();
            }
            else if(choice == 4){
                //sweet
                SweetStuffs display = new SweetStuffs(con,s);
                display.displaySweetStuffs();   
            }
            else if(choice == 5){
                //fruit
                FruitStuffs display = new FruitStuffs(con,s);
                display.displayFruitStuffs();       
            }
            else if(choice == 6){
                Bill bill = new Bill();
                bill.billDisplay();
            }
            else if(choice == 7){
                orderFinish = true;
                break;
            }
            else{
                System.out.println("        Invalid choice of selection ");
            }
        }
        return orderFinish;
    }
}
