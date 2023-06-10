import java.sql.Connection;
import java.sql.DriverManager;

public class App {
    public static void main(String[] args) throws Exception {
        User userobj = null;
        Menu menuobj = null;
        System.out.println();
        System.out.println("       ******************************");
        System.out.println("                  Foodstuffs         ");
        System.out.println("       ******************************");
        System.out.println();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Foodstuffs","root","123456789");
            userobj = new User(con);
            menuobj = new Menu(con);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        userobj.selectSignType();
        menuobj.displayMenu();
    }
}
