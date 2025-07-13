
package bank.management.system;
import java.sql.*;

public class Conn {

   // step:1 Create Connection
    Connection c;
    Statement s;
    public Conn(){
        try{
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","ishant@jaiswal@2004");
            s=c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
