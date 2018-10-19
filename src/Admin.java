import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

    private JPanel Loginpane;
    private JButton btnNewAccount;
    private JTextField userName_1;
    private JLabel lblNewLabel;
    private JPasswordField passwordField;
    String driverName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/flight";
    String userName = "root";
    String password = "sidhu@007";
    private JPanel panel1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Admin frame2 = new Admin();
                    frame2.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Admin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 953, 517);
        Loginpane = new JPanel();
        Loginpane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(Loginpane);
        Loginpane.setLayout(null);

        JButton btnNewButton = new JButton("LOGIN");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try
                {
                    Class.forName(driverName);
                    Connection con = DriverManager.getConnection(url, userName, password);
                    String s=userName_1.getText();
                    String p=passwordField.getSelectedText();
                    String sql = "select * from admins where USERNAME='"+s+"'and password='"+p+"'";
                    PreparedStatement ps = con.prepareStatement(sql);

                    ResultSet rs = ps.executeQuery();
                    if(rs==null)
                    {
                        JOptionPane.showMessageDialog(null,"Invalid password or username");

                    }
                    else
                    {
                        LoginPage rgf=new LoginPage();
                        rgf.setUsername(s);

                        rgf.setVisible(true);
                        setVisible(false);
                        dispose();
                        con.close();

                    }


                }
                catch(Exception exp)

                {
                    JOptionPane.showMessageDialog(null,e);

                }
            }
        });
        btnNewButton.setBounds(5, 422, 934, 32);
        Loginpane.add(btnNewButton);


        userName_1 = new JTextField();
        userName_1.setBounds(417, 129, 96, 19);
        Loginpane.add(userName_1);
        userName_1.setColumns(10);

        lblNewLabel = new JLabel("USERNAME");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setBounds(10, 132, 269, 13);
        Loginpane.add(lblNewLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(417, 243, 96, 19);
        Loginpane.add(passwordField);

        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setBounds(10, 246, 269, 13);
        Loginpane.add(lblPassword);






    }
}
