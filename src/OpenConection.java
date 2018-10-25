import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

abstract public class OpenConection {
    String driverName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/flight";
    String userName = "root";
    String password = "sidhu@007";
   public ResultSet openConnection(String sqlQuery){
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
