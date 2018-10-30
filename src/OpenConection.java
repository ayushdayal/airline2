import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

 public class OpenConection {
    static  String driverName = "com.mysql.jdbc.Driver";
   static String url = "jdbc:mysql://localhost:3306/flight";
   static String userName = "root";
   static String password = "sidhu@007";
   public static ResultSet openConnection(String sqlQuery){
       try {
           Class.forName(driverName);

       Connection con = DriverManager.getConnection(url, userName, password);
           String sql = sqlQuery;
           PreparedStatement ps = con.prepareStatement(sql);

           ResultSet rs = ps.executeQuery();
       return rs;
       } catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
                   JOptionPane.ERROR_MESSAGE);
       }
       return null;
   }
}
