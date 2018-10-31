import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;

//import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class LoginPage extends JFrame {

	private JPanel Loginpane;
	JFrame frame, frame1;
	JTextField textbox;
	JLabel label;
	JButton button;
	JPanel panel;
	private JLabel UserName;
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/flight";
	String userName = "root";
	String password = "sidhu@007";
	String[] columnNames = {"Flight ID", "Name", "Departure", "Arrival","Seats","Price"};
	private JTextField textField;
	private JTextField textField1;
	private String username;
	private int ID;
	public void setuserid(int t)
	{
		this.ID=t;
	}
	
	
	public void setUsername(String s)
	{
		this.username=s;
		UserName.setText("Welcome "+username);;
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame3 = new LoginPage();
					frame3.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
		
	


	/**
	 * Create the frame.
	 */
	
	public LoginPage() 
		{
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 918, 737);
			Loginpane = new JPanel();
			Loginpane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(Loginpane);
			
			JLabel label = new JLabel("");
			label.setBounds(349, 19, 0, 0);
			
			JLabel lblFrom = new JLabel("FROM");
			lblFrom.setBounds(132, 142, 95, 13);

			String getDestinationQuery="select distinct dFrom from light ; ";
			ResultSet rs=OpenConection.openConnection(getDestinationQuery);
			String destinations[]= new String[15];
			try {

				int i=0;
				while (rs.next())
					destinations[i++]=rs.getString(1);
			} catch (SQLException e) {
				e.printStackTrace();
			}


			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(251, 139, 129, 19);
			comboBox.setModel(new DefaultComboBoxModel(destinations));
			comboBox.setToolTipText("");
			
			JLabel lblTo = new JLabel("TO");
			lblTo.setBounds(442, 137, 34, 22);

			String toS[]= new String[15];
			try {
		         getDestinationQuery="select distinct arrivesto from light ; ";
rs=OpenConection.openConnection(getDestinationQuery);
				int i=0;
				while (rs.next())
					toS[i++]=rs.getString(1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JComboBox comboBox2 = new JComboBox();
			comboBox2.setBounds(562, 139, 129, 19);
			comboBox2.setModel(new DefaultComboBoxModel(toS));
			Loginpane.setLayout(null);
			Loginpane.add(label);
			Loginpane.add(lblFrom);
			Loginpane.add(comboBox);
			Loginpane.add(lblTo);
			Loginpane.add(comboBox2);
			
			JCalendar calendar = new JCalendar();
			calendar.setBounds(251, 180, 206, 135);
			Loginpane.add(calendar);
			
			JLabel lblDate = new JLabel("DATE");
			lblDate.setBounds(132, 180, 95, 13);
			Loginpane.add(lblDate);
			
			
				
			
			
			
			JButton btnLogOut = new JButton("Log out");
			btnLogOut.setBounds(759, 10, 145, 21);
			btnLogOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					First rgf=new First();
					rgf.setVisible(true);
					 setVisible(false);
					 dispose();
				}
			});
			Loginpane.add(btnLogOut);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.setBounds(0, 334, 904, 28);
//			btnSearch.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					showTableData();
//				}
//			});
			btnSearch.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTable table = new JTable();
                    String query="select * from light where dFrom="+comboBox.getSelectedItem().toString()+" and arrivesto="+comboBox2.getSelectedItem().toString()+";" ;
                    System.out.println(query);
                    ResultSet set=OpenConection.openConnection(query);
                    table.setModel(DbUtils.resultSetToTableModel(set));
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(0, 400, 900, 400);
                    Loginpane.add(scrollPane);
                    scrollPane.setViewportView(table);
                }
            });
			Loginpane.add(btnSearch);
			
			JButton btnMyBookings = new JButton("My Bookings");
			btnMyBookings.setBounds(0, 84, 155, 21);
			btnMyBookings.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PreviousBooking rgf=new PreviousBooking();
					rgf.setusername(username);
					
						rgf.setVisible(true);
						setVisible(false);
						dispose();
						 
					
				}
			});
			Loginpane.add(btnMyBookings);
			
			JButton btnNewButton = new JButton("Book");
			btnNewButton.setBounds(408, 642, 85, 21);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					booking rgf=new booking();
					String s=textField1.getText();
						rgf.setAmount(s);
						int result = Integer.parseInt(textField.getText());
						s=username;
						rgf.setFlightid(result);
						rgf.setusername(s);
						
					rgf.setVisible(true);
					
					setVisible(false);
					dispose();
			        
				}
			});
			Loginpane.add(btnNewButton);
			
			JLabel lblFlightId = new JLabel("Flight Id");
			lblFlightId.setBounds(132, 646, 95, 13);
			Loginpane.add(lblFlightId);
			
			textField = new JTextField();
			textField.setBounds(253, 643, 96, 19);
			Loginpane.add(textField);
			textField.setColumns(10);
			
			textField1 = new JTextField();
			textField1.setBounds(562, 643, 96, 19);
			Loginpane.add(textField1);
			textField1.setColumns(10);
			
			UserName = new JLabel("New label");
			UserName.setBounds(0, 10, 155, 13);
			Loginpane.add(UserName);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(31, 401, 800, 162);
			Loginpane.add(scrollPane);
			

			
			
			
			
			
			
			
		}
	}

