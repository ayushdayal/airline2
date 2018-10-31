import javax.swing.*;
import java.sql.*;

public class OpenConection {
    static String driverName = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/flight";
    static String userName = "root";
    static String password = "root";
    static Connection con;

    public static ResultSet openConnection(String sqlQuery) {
        try {
            Class.forName(driverName);


            con = DriverManager.getConnection(url, userName, password);
            String sql = sqlQuery;
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            return rs;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
//           try {
//               con.close();
//           } catch (SQLException e) {
//               e.printStackTrace();
//           }
        }
        return null;
    }

    public static int openConnection(String sqlQuery, int a) {
        try {
            Class.forName(driverName);


            con = DriverManager.getConnection(url, userName, password);
            String sql = sqlQuery;
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = null;

            return ps.executeUpdate(sql);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
//           try {
//               con.close();
//           } catch (SQLException e) {
//               e.printStackTrace();
//           }
        }
        return 0;
    }

}
