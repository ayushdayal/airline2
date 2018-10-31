
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import  net.proteanit.sql.DbUtils;



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

        pilot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("pilot action listner ");
                pilotPanel.setVisible(!pilotPanel.isVisible());
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
                System.out.println("check action listner ");
                checkPanel.setVisible(!isVisible());
            }
        });
        reservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("crew action listner ");
                checkReservationPanel.setVisible(!checkReservationPanel.isVisible());
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("crew action listner ");
                updatePanel.setVisible(!updatePanel.isVisible());
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

        //main bar panel
        contentPane.add(mainmenu);
        add(contentPane, BorderLayout.CENTER);
        contentPane.setVisible(true);

        //check reservation panel
        checkReservationPanel= getCheckReservationPanel();
        add(checkReservationPanel);
        checkReservationPanel.setVisible(false);

        //flight update panel
        updatePanel= getUdatePanel();
        add(updatePanel);
        updatePanel.setVisible(false);

        //pilot panel
        dfs = getPilotPanel();
        add(dfs);
        dfs.setVisible(false);

        //crew panel
        crewpanel = getCrewpanel();
        add(crewpanel, BorderLayout.CENTER);
        crewpanel.setVisible(false);

        // payment panel
        checkPanel = getCheck();
        add(checkPanel, BorderLayout.CENTER);
        checkPanel.setVisible(false);

    }


    public JPanel getCrewpanel() {
        crewpanel = new JPanel();
        crewpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        crewpanel.setLayout(null);
        crewpanel.setBounds(0, 0, 900, 800);
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
        JTextField staffidF = new JTextField(" ");


        String s = staffidF.getText().toString();
        final Integer[] s1 = new Integer[2];

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "select salary from staff where staffid='" + s + "'";
                ResultSet rs = OpenConection.openConnection(sql);


                try {
                    s1[0] =rs.getInt(0);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                if (rs == null) {
                    JOptionPane.showMessageDialog(null, "Invalid crew id");
                }
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "select workinghrs from staff where staffid='" + s + "'";
                ResultSet rs = OpenConection.openConnection(sql);


                try {
                    s1[1] =rs.getInt(0);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                if (rs == null) {
                    JOptionPane.showMessageDialog(null, "Invalid crew id");
                }
            }
        });

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
        staffidF.setBounds(120, 70, 100, 20);
        crewpanel.add(staffidF);
        JTextField salaryF = new JTextField("  ");
        salaryF.setBounds(120, 90, 100, 20);
        crewpanel.add(salaryF);
        salaryF.setText(String.valueOf(s1[0]));
        JTextField workingHoursF = new JTextField(" ");
        workingHoursF.setBounds(120, 110, 100, 20);
        crewpanel.add(workingHoursF);
        workingHoursF.setText(String.valueOf(s1[1]));

        return crewpanel;
    }

    public JPanel getPilotPanel() {
        pilotPanel = new JPanel();
        pilotPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        pilotPanel.setLayout(null);
        pilotPanel.setBounds(0, 0, 900, 800);
        pilotPanel.setBackground(new Color(327879));

//        JLabel CrewidLabel= new JLabel(" Crew id ");
//        CrewidLabel.setBounds(5,50,100,20);
//        pilotPanel.add(CrewidLabel);
        JLabel staffid = new JLabel(" pilot id ");
        staffid.setBounds(5, 70, 100, 20);
        pilotPanel.add(staffid);
        JLabel salary = new JLabel(" salary ");
        salary.setBounds(5, 90, 100, 20);
        pilotPanel.add(salary);
        JLabel workingHours = new JLabel(" working hours ");
        workingHours.setBounds(5, 110, 100, 20);
        pilotPanel.add(workingHours);
        JLabel LicenceNo = new JLabel(" working hours ");
        LicenceNo.setBounds(5, 130, 100, 20);
        pilotPanel.add(LicenceNo);

        JButton button = new JButton();
        button.setBounds(240, 70, 100, 20);
        button.setText("search");
        pilotPanel.add(button);

        JButton button2 = new JButton();
        button2.setBounds(340, 70, 100, 20);
        button2.setText("new");
        pilotPanel.add(button2);

        JButton button3 = new JButton();
        button3.setBounds(340, 90, 100, 20);
        button3.setText("edit");
        pilotPanel.add(button3);

        JButton button4 = new JButton();
        button4.setBounds(340, 110, 100, 20);
        button4.setText("delete");
        button4.setBackground(new Color(888888888));
        pilotPanel.add(button4);


//        JTextField CrewidLabelF= new JTextField("  ");
//        CrewidLabelF.setBounds(120,50,100,20);
//        pilotPanel.add(CrewidLabelF);
        JTextField staffidF = new JTextField(" ");
        staffidF.setBounds(120, 70, 100, 20);
        pilotPanel.add(staffidF);
        JTextField salaryF = new JTextField("  ");
        salaryF.setBounds(120, 90, 100, 20);
        pilotPanel.add(salaryF);
        JTextField workingHoursF = new JTextField(" ");
        workingHoursF.setBounds(120, 110, 100, 20);
        pilotPanel.add(workingHoursF);
        JTextField LicenceNoF = new JTextField(" working hours ");
        LicenceNoF.setBounds(120, 130, 100, 20);
        pilotPanel.add(LicenceNoF);

        return pilotPanel;
    }

    public JPanel getCheck() {

        checkPanel = new JPanel();
        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 900, 800);
        checkPanel.add(scrollPane);
        scrollPane.setViewportView(table);

        String query="select * from light";

          ResultSet set=OpenConection.openConnection(query);
        // Dont call While loop or if condition here

      table.setModel(DbUtils.resultSetToTableModel(set));


        return checkPanel;
    }

    public JPanel getUdatePanel() {
        updatePanel = new JPanel();
        updatePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        updatePanel.setLayout(null);
        updatePanel.setBounds(0, 0, 900, 800);
        updatePanel.setBackground(new Color(11111111));

//        JLabel CrewidLabel= new JLabel(" Crew id ");
//        CrewidLabel.setBounds(5,50,100,20);
//        updatePanel.add(CrewidLabel);
        JLabel fid = new JLabel(" fid");
        fid.setBounds(5, 70, 100, 20);
        updatePanel.add(fid);
        JLabel from = new JLabel(" from ");
        from.setBounds(5, 90, 100, 20);
        updatePanel.add(from);
        JLabel to = new JLabel(" to ");
        to.setBounds(5, 110, 100, 20);
        updatePanel.add(to);

        JButton button = new JButton();
        button.setBounds(240, 70, 100, 20);
        button.setText("search");
        updatePanel.add(button);

        JButton button2 = new JButton();
        button2.setBounds(340, 70, 100, 20);
        button2.setText("new");
        updatePanel.add(button2);

        JButton button3 = new JButton();
        button3.setBounds(340, 90, 100, 20);
        button3.setText("edit");
        updatePanel.add(button3);

        JButton button4 = new JButton();
        button4.setBounds(340, 110, 100, 20);
        button4.setText("delete");
        button4.setBackground(new Color(888888888));
        updatePanel.add(button4);


//        JTextField CrewidLabelF= new JTextField("  ");
//        CrewidLabelF.setBounds(120,50,100,20);
//        updatePanel.add(CrewidLabelF);
        JTextField FidF = new JTextField(" ");
        FidF.setBounds(120, 70, 100, 20);
        updatePanel.add(FidF);
        JTextField fromF = new JTextField("  ");
        fromF.setBounds(120, 90, 100, 20);
        updatePanel.add(fromF);
        JTextField toF = new JTextField(" ");
        toF.setBounds(120, 110, 100, 20);
        updatePanel.add(toF);

        return updatePanel;
    }

    public JPanel getCheckReservationPanel() {
        checkReservationPanel = new JPanel();
        checkReservationPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        checkReservationPanel.setLayout(null);
        checkReservationPanel.setBounds(0, 0, 900, 800);
        checkReservationPanel.setBackground(new Color(2342423));

//        JLabel CrewidLabel= new JLabel(" Crew id ");
//        CrewidLabel.setBounds(5,50,100,20);
//        checkReservationPanel.add(CrewidLabel);
        JLabel fid = new JLabel(" flight id ");
        fid.setBounds(5, 70, 100, 20);
        checkReservationPanel.add(fid);
//        JLabel avaSeats = new JLabel(" A seats ");
//        avaSeats.setBounds(5, 90, 100, 20);
//        checkReservationPanel.add(avaSeats);


        JButton button = new JButton();
        button.setBounds(240, 70, 100, 20);
        button.setText("search");
        checkReservationPanel.add(button);


        JButton button3 = new JButton();
        button3.setBounds(340, 90, 100, 20);
        button3.setText("edit");
        checkReservationPanel.add(button3);

//        JTextField CrewidLabelF= new JTextField("  ");
//        CrewidLabelF.setBounds(120,50,100,20);
//        checkReservationPanel.add(CrewidLabelF);
        JTextField fifF = new JTextField(" ");
        fifF.setBounds(120, 70, 100, 20);
        checkReservationPanel.add(fifF);
//        JTextField avaSeatsF = new JTextField("  ");
//        avaSeatsF.setBounds(120, 90, 100, 20);
//        checkReservationPanel.add(avaSeatsF);


        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 300, 900, 400);
        checkReservationPanel.add(scrollPane);
        scrollPane.setViewportView(table);

        String query="select * from bookedticket where flight_id="+fifF.getText().toString()+";" ;
System.out.println(query);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ResultSet set=OpenConection.openConnection(query);
                // Dont call While loop or if condition here

                table.setModel(DbUtils.resultSetToTableModel(set));
            }
        });



        return checkReservationPanel;
    }



}
