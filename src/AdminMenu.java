import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;



public class AdminMenu extends JFrame {

    private JPanel contentPane;
    private JPanel checkReservationPanel;
    private JPanel updatePanel;
    private JPanel pilotPanel;
    private JPanel crewpanel;
    private JPanel checkPanel;


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

    public AdminMenu() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 916, 660);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        contentPane.setLayout(null);


        JMenuBar mainmenu = new JMenuBar();
        mainmenu.setBounds(0,0,900,20);
        JMenu flight = new JMenu("FLIGHT"), staff = new JMenu("STAFF"), payment = new JMenu("PAYMENT");
        JMenuItem reservation = new JMenuItem("CHECK RESERVATION"), update = new JMenuItem("UPDATE"), pilot = new JMenuItem("PILOT"), crew = new JMenuItem("CREW"), check = new JMenuItem("CHECK");

        flight.add(reservation);
        flight.add(update);
        staff.add(pilot);
        staff.add(crew);
        payment.add(check);
        mainmenu.add(flight);
        mainmenu.add(staff);
        mainmenu.add(payment);
        contentPane.add(mainmenu);
        contentPane.setBounds(0,0,900,500);
        add(contentPane,BorderLayout.CENTER);
        add(pilotDetails(),BorderLayout.CENTER);
//        contentPane.setJMenuBar(mainmenu);

    }

    public AdminMenu(GraphicsConfiguration gc) {
        super(gc);
    }

    public AdminMenu(String title) throws HeadlessException {
        super(title);

        new AdminMenu();
    }

    public AdminMenu(String title, GraphicsConfiguration gc) {
        super(title, gc);
    }

    public JPanel pilotDetails(){
        pilotPanel= new JPanel();
//        pilotPanel.setBounds(0,200,900,500);
        pilotPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        pilotPanel.setLayout(null);
        JLabel searchHere= new JLabel("Pilot id");
//        searchHere.setText("search here");
        searchHere.setBounds(50,250,100,20);
        pilotPanel.add(searchHere);

        JTextField searchtext  = new JTextField();
        searchtext.setBounds(150,250,100,20);
        pilotPanel.add(searchtext);


        return pilotPanel;
    }
}
