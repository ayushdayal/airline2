import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AdminMenu extends JFrame {

    private JPanel contentPane;
    private JPanel checkReservationPanel;
    private JPanel updatePanel;
    private JPanel pilotPanel;
    private JPanel crewpanel;
    private JPanel checkPanel;
    String userName = "root";
    String password = "sidhu@007";
    String url = "jdbc:mysql://localhost:3306/flight";
    String driverName = "com.mysql.jdbc.Driver";
//asdfa


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminMenu frame = new AdminMenu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    JPanel dfs;
    JPanel container;

    public AdminMenu() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 916, 660);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        contentPane.setBounds(0,0,800,20);
        contentPane.setBackground(new Color(100100));

        JMenuBar mainmenu = new JMenuBar();
        mainmenu.setBounds(0,0,900,20);
        JMenu flight = new JMenu("FLIGHT"), staff = new JMenu("STAFF"), payment = new JMenu("PAYMENT");
        JMenuItem reservation = new JMenuItem("CHECK RESERVATION"), update = new JMenuItem("UPDATE"), pilot = new JMenuItem("PILOT"), crew = new JMenuItem("CREW"), check = new JMenuItem("CHECK");

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abc();
            }
        });
        flight.add(reservation);
        flight.add(update);
        staff.add(pilot);
        staff.add(crew);
        payment.add(check);
        mainmenu.add(flight);
        mainmenu.add(staff);
        mainmenu.add(payment);

        contentPane.add(mainmenu);
        add(contentPane,BorderLayout.CENTER);

        dfs = pilotDetails();
        add(dfs);

    }
    public void abc(){
        System.out.println("asd");
        dfs.setVisible(!dfs.isVisible());
    }


    public JPanel pilotDetails(){
        pilotPanel= new JPanel();
        pilotPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        pilotPanel.setBackground(new Color(222));
        pilotPanel.setLayout(null);
        pilotPanel.setBounds(0,-1000,800,500);
        JLabel searchHere= new JLabel("Pilot id");
        searchHere.setBounds(50,250,100,20);
        pilotPanel.add(searchHere);

        JTextField searchtext  = new JTextField();
        searchtext.setBounds(150,250,100,20);

       JButton searchbutton = new JButton("SEARCH");
       searchbutton.setBounds(250,250,100,20);
       searchbutton.addMouseListener(new MouseListener() {
           @Override
           public void mouseClicked(MouseEvent e) {
               try
               {
                   Class.forName(driverName);
                   Connection con = DriverManager.getConnection(url,userName,password);
                   String s=searchtext.getText();
                   String sql = "select * from pilot where pid='"+s+"'";
                   PreparedStatement ps = con.prepareStatement(sql);

                   ResultSet rs = ps.executeQuery();
                   if(rs==null)
                   {
                       JOptionPane.showMessageDialog(null,"Invalid pilot id");

                   }
                   else
                   {


//                       LoginPage rgf=new LoginPage();
//                       rgf.setUsername(s);
//
//                       rgf.setVisible(true);
//                       setVisible(false);
//                       dispose();
//                       con.close();

                   }


               }
               catch(Exception exp)

               {
                   JOptionPane.showMessageDialog(null,e);

               }
           }

           @Override
           public void mousePressed(MouseEvent e) {

           }

           @Override
           public void mouseReleased(MouseEvent e) {

           }

           @Override
           public void mouseEntered(MouseEvent e) {

           }

           @Override
           public void mouseExited(MouseEvent e) {

           }
       });

        pilotPanel.add(searchtext);

        return pilotPanel;
    }
    public JPanel flighUpdate(){
        updatePanel= new JPanel();
//        updatePanel.setBounds(0,200,900,500);
        updatePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        updatePanel.setBackground(new Color(222));
        updatePanel.setLayout(null);
        updatePanel.setBounds(0,-1000,800,500);
        JLabel searchHere= new JLabel("Pilot id");
//        searchHere.setText("search here");
        searchHere.setBounds(50,250,100,20);
        updatePanel.add(searchHere);

        JTextField searchtext  = new JTextField();
        searchtext.setBounds(150,250,100,20);
        updatePanel.add(searchtext);


        return pilotPanel;
    }

    public JPanel CheckReservation(){
       JPanel reservationpanel=new JPanel();
        reservationpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
       // reservationpanel.setBackground(new Color(222));
        reservationpanel.setLayout(null);
        reservationpanel.setBounds(0,-1000,800,500);
        JLabel searchHere= new JLabel(" Enter Flight id ");
//        searchHere.setText("search here");
        searchHere.setBounds(50,250,100,20);
        reservationpanel.add(searchHere);

        JTextField searchtext  = new JTextField();
        searchtext.setBounds(150,250,100,20);
        reservationpanel.add(searchtext);

        return reservationpanel;
    }

}
