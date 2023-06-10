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
        }
        else if(favchoice == 3){
            //nonveg
        }
        else if(favchoice == 4){
            //sweet
        }
        else if(favchoice == 5){
            //fruit
        }
        // else if(favchoice == 6){
        //     break;
        // }
        else{
            System.out.println("        Invalid choice of selection ");
        }
    }
}
