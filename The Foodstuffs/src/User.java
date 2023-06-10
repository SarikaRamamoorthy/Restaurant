import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class User {
    private Connection con;
    private String name;
    private char[] password;
    private String pwd;
    private java.sql.Date OrderDate;
    private Scanner s = new Scanner(System.in);
    
    public User(Connection con){
        this.con = con;
    }

    public void userInfo(){
        Console console = System.console();
        //to store user name and password
        if(console == null){
            System.out.println("No console available");
            return;
        }
        name = console.readLine("       User Name: ");
        password = console.readPassword("       Password : ");
        pwd = String.valueOf(password);
        OrderDate = java.sql.Date.valueOf(LocalDateTime.now().toLocalDate());
        return;                                         
    }

    public void selectSignType(){
        boolean signinFlag = false;
        boolean signupFlag = false;
        while(true){
            System.out.println("       1. Sign In");
            System.out.println("       2. Sign Up");
            System.out.println("       3. Exit");
            System.out.println();
            System.out.print("       Enter your choice (1/2/3): ");
            int choice = s.nextInt();
            System.out.println();
            if(choice == 1){
                while(!signinFlag)
                signinFlag = signIn();
                break;
            }
            else if(choice == 2){
                while(!signupFlag)
                signupFlag = signUp();
                break;
            }
            else if(choice == 3){
                break;
            }
            else{
                System.out.println("       Invalid Choice");
           }
        }
    }

    public boolean signIn(){
        userInfo();
        try{
            PreparedStatement stmt = con.prepareStatement("select user_name from user where user_name = ?;");
            stmt.setString(1, name);
            ResultSet res = stmt.executeQuery();
            if(res.next()){
                PreparedStatement stmt1 = con.prepareStatement("select DateOfLastOrder from user where user_name = ? and password = ?;");
                stmt1.setString(1, name);
                stmt1.setString(2, pwd);
                ResultSet res1 = stmt1.executeQuery();
                if(res1.next()){
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    formatter = formatter.withLocale(Locale.US);        

                    LocalDate lastdate = LocalDate.parse(res1.getString(1), formatter);
                    Period difference = Period.between(lastdate,OrderDate.toLocalDate());
                    PreparedStatement stmt2 = con.prepareStatement("update user set DateOflastOrder = ? where user_name = ? and password = ?;");
                    stmt2.setDate(1,OrderDate);
                    stmt2.setString(2,name);
                    stmt2.setString(3,pwd);
                    stmt2.executeUpdate();
                    PreparedStatement stmt3 = con.prepareStatement("update user set spl_customer = ? where user_name = ? and password = ?;");
                    if(difference.getDays()<=7 &&( difference.getMonths() == 0 && difference.getYears() == 0 )){
                        stmt3.setString(1,"Yes");
                        stmt3.setString(2,name);
                        stmt3.setString(3,pwd);
                        stmt3.executeUpdate();
                        System.out.println();
                        System.out.println("       Congrats!! You are our special customer");
                        System.out.println();
                        return true;
                    }
                    else{
                        stmt3.setString(1,"No");
                        stmt3.setString(2,name);
                        stmt3.setString(3,pwd);
                        stmt3.executeUpdate();
                        return true;
                    }
                }
                else{
                    System.out.println("       Invalid or wrong password");
                    return false;
                }
            }
            else{
                System.out.println("       Invalid UserName");
                return false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean signUp(){
        userInfo();
        try{
            PreparedStatement stmt1 = con.prepareStatement("select user_name from user where user_name = ?;");
            stmt1.setString(1, name);
            ResultSet res = stmt1.executeQuery();
            if(res.next()){
                System.out.println();
                System.out.println("       !!! User Name exists !!!");
                System.out.println();
                return false;
            }
            else{
                PreparedStatement stmt = con.prepareStatement("insert into user(user_name,password,DateOfLastOrder) values(?,?,?);");
                stmt.setString(1, name);
                stmt.setString(2, pwd);
                stmt.setDate(3, OrderDate);
                stmt.execute();
                return true;
            }    
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}