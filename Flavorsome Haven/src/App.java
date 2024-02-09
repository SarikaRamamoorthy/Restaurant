import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        User userobj = null;
        Menu menuobj = null;
        boolean orderState = false;
        Scanner s = new Scanner(System.in);
        System.out.println();
        System.out.println("       ******************************");
        System.out.println("              Flavorsome Heaven      ");
        System.out.println("       ******************************");
        System.out.println();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Foodstuffs","root","123456789");
            userobj = new User(con,s);
            menuobj = new Menu(con,s);
        }
        catch(Exception e){
            e.printStackTrace();
        }     
        while(!orderState){
            orderState = userobj.selectSignType();
            if(orderState)
            break;
            orderState = menuobj.displayMenu();
        }  
        System.out.println("             Come Back soon :)");
    }
}
