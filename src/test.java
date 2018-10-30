import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test extends JFrame {

    private JPanel Loginpane;
    private JButton btnNewAccount;
    private JTextField userName_1;
    private JLabel lblNewLabel;
    private JPasswordField passwordField;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    test frame2 = new test();
                    frame2.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    test(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 953, 517);
        Loginpane = new JPanel();
        Loginpane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(Loginpane);
        Loginpane.setLayout(null);
        ResultSet set=OpenConection.openConnection("select salary from staff ");
        JTextField field= null;
        field = new JTextField();
        try {
            while (set.next()) {
                field.setText(set.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        field.setBounds(0,0,100,30);
      //  field.setText();
        add(field);
    }
}
