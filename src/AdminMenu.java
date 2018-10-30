import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import  net.proteanit.sql.DbUtils;


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
//asdfabqydsgaWDSUEWY3WGYRYURGYGYEG


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
        contentPane.setBounds(0, 0, 800, 20);
        contentPane.setBackground(new Color(100100));

        JMenuBar mainmenu = new JMenuBar();
        mainmenu.setBounds(0, 0, 900, 20);
        JMenu flight = new JMenu("FLIGHT"), staff = new JMenu("STAFF"), payment = new JMenu("PAYMENT");
        JMenuItem reservation = new JMenuItem("CHECK RESERVATION"), update = new JMenuItem("UPDATE"), pilot = new JMenuItem("PILOT"), crew = new JMenuItem("CREW"), check = new JMenuItem("CHECK");

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abc();
            }
        });
        crew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("crew action listner ");
                crewpanel.setVisible(!crewpanel.isVisible());
            }
        });
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkPanel.setVisible(!isVisible());
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
        add(contentPane, BorderLayout.CENTER);
        crewpanel = getCrewpanel();
        add(crewpanel, BorderLayout.CENTER);

        checkPanel = Paymentcheck();
        add(checkPanel, BorderLayout.CENTER);
        checkPanel.setVisible(true);
        dfs = pilotDetails();
        add(dfs);


    }

    public void abc() {
        System.out.println("asd");
        dfs.setVisible(!dfs.isVisible());
    }

    public JPanel getCrewpanel() {
        crewpanel = new JPanel();
        crewpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        crewpanel.setLayout(null);
        crewpanel.setBounds(30, 30, 800, 500);
        crewpanel.setBackground(new Color(2342423));

//        JLabel CrewidLabel= new JLabel(" Crew id ");
//        CrewidLabel.setBounds(5,50,100,20);
//        crewpanel.add(CrewidLabel);
        JLabel staffid = new JLabel(" staff id ");
        staffid.setBounds(5, 70, 100, 20);
        crewpanel.add(staffid);
        JLabel salary = new JLabel(" salary ");
        salary.setBounds(5, 90, 100, 20);
        crewpanel.add(salary);
        JLabel workingHours = new JLabel(" working hours ");
        workingHours.setBounds(5, 110, 100, 20);
        crewpanel.add(workingHours);

        JButton button = new JButton();
        button.setBounds(240, 70, 100, 20);
        button.setText("search");
        crewpanel.add(button);

        JButton button2 = new JButton();
        button2.setBounds(340, 70, 100, 20);
        button2.setText("new");
        crewpanel.add(button2);

        JButton button3 = new JButton();
        button3.setBounds(340, 90, 100, 20);
        button3.setText("edit");
        crewpanel.add(button3);

        JButton button4 = new JButton();
        button4.setBounds(340, 110, 100, 20);
        button4.setText("delete");
        button4.setBackground(new Color(888888888));
        crewpanel.add(button4);


//        JTextField CrewidLabelF= new JTextField("  ");
//        CrewidLabelF.setBounds(120,50,100,20);
//        crewpanel.add(CrewidLabelF);
        JTextField staffidF = new JTextField(" ");
        staffidF.setBounds(120, 70, 100, 20);
        crewpanel.add(staffidF);
        JTextField salaryF = new JTextField("  ");
        salaryF.setBounds(120, 90, 100, 20);
        crewpanel.add(salaryF);
        JTextField workingHoursF = new JTextField(" ");
        workingHoursF.setBounds(120, 110, 100, 20);
        crewpanel.add(workingHoursF);

        return crewpanel;
    }

    public JPanel pilotDetails() {
        pilotPanel = new JPanel();
        pilotPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//        pilotPanel.setBackground(new Color(222));
        pilotPanel.setLayout(null);
        pilotPanel.setBounds(0, -1000, 800, 500);
        JLabel searchHere = new JLabel("Pilot id");
        searchHere.setBounds(50, 250, 100, 20);
        pilotPanel.add(searchHere);

        JTextField searchtext = new JTextField();
        searchtext.setBounds(150, 250, 100, 20);

        JButton searchbutton = new JButton("SEARCH");
        searchbutton.setBounds(250, 250, 100, 20);
        searchbutton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String s = searchtext.getText();
                    String sql = "select * from pilot where pid='" + s + "'";
                    ResultSet rs = OpenConection.openConnection(sql);
                    if (rs == null) {
                        JOptionPane.showMessageDialog(null, "Invalid pilot id");
                    }
                } catch (Exception exp) {
                    JOptionPane.showMessageDialog(null, e);
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

    public JPanel flighUpdate() {
        updatePanel = new JPanel();
//        updatePanel.setBounds(0,200,900,500);
        updatePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        updatePanel.setBackground(new Color(222));
        updatePanel.setLayout(null);
        updatePanel.setBounds(0, -1000, 800, 500);
        JLabel searchHere = new JLabel("Pilot id");
//        searchHere.setText("search here");
        searchHere.setBounds(50, 250, 100, 20);
        updatePanel.add(searchHere);

        JTextField searchtext = new JTextField();
        searchtext.setBounds(150, 250, 100, 20);
        updatePanel.add(searchtext);


        return updatePanel;
    }

    public JPanel CheckReservation() {
        JPanel reservationpanel = new JPanel();
        reservationpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        // reservationpanel.setBackground(new Color(222));
        reservationpanel.setLayout(null);
        reservationpanel.setBounds(0, 0, 800, 500);
        JLabel searchHere = new JLabel(" Enter Flight id ");
//        searchHere.setText("search here");
        searchHere.setBounds(50, 250, 100, 20);
        reservationpanel.add(searchHere);

        JTextField searchtext = new JTextField();
        searchtext.setBounds(150, 250, 100, 20);
        reservationpanel.add(searchtext);


        return reservationpanel;
    }

    public JPanel Paymentcheck() {

        checkPanel = new JPanel();
        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(97, 72, 218, 136);
        checkPanel.add(scrollPane);
        scrollPane.setViewportView(table);

        String query = "select * from emp";

        //  ResultSet set=OpenConection.openConnection(query);
        // Dont call While loop or if condition here

//       table.setModel(DbUtils.resultSetToTableModel(set));

        return checkPanel;
    }


}
