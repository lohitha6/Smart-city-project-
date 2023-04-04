import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setTitle("MainMenu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New user? Click here to register");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel_1.setBounds(98, 130, 241, 21);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignUp signup = new SignUp();
				signup.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(349, 122, 133, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Existing user? Click here to login");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel.setBounds(98, 190, 229, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(349, 190, 133, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Admin login");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AdminLogin adminlogin = new AdminLogin();
				adminlogin.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_3.setBounds(688, 122, 133, 29);
		contentPane.add(btnNewButton_3);
		
		JLabel Background = new JLabel("Register");
		Background.setIcon(new ImageIcon("p2.png"));
		Background.setBounds(0, 0, 886, 563);
		contentPane.add(Background);
	}
}
class UserDetails{
	
	public String name;
	public String password;
	public int age;
	public String username;
	public String usertype;
	
	public UserDetails()
	{
		
	}
	
	public UserDetails(String nm, String pass, String usnm, String ustyp, int ag)
	{
		name = nm;
		password = pass;
		age = ag;
		username = usnm;
		usertype = ustyp;
		try {
		      FileWriter myWriter = new FileWriter("usernames.txt",true);
		      myWriter.write(username+" "+password+" "+usertype+"\n");
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}
	
}
 class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(55, 47, 116, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(55, 86, 116, 13);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(181, 44, 139, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(181, 83, 139, 19);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("User Type");
		lblNewLabel_2.setBounds(56, 132, 115, 13);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Student", "Tourist"}));
		comboBox.setBounds(181, 128, 139, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String username, pass,usertype;
				username = textField.getText();
				pass = String.valueOf(passwordField.getPassword());
				usertype = comboBox.getSelectedItem().toString();
				String chk = username+" "+pass+" "+usertype;
				int flag=0;
				try {
				      File myObj = new File("usernames.txt");
				      Scanner myReader = new Scanner(myObj);
				      while (myReader.hasNextLine()) {
				        String data = myReader.nextLine();
				        if(data.equals(chk))
				        {
				        	flag = 1;
				        }
				        
				      }
				      myReader.close();
				    } catch (FileNotFoundException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }
				if(flag == 1 && usertype.equals("Student"))
				{
					StudentMenu sm = new StudentMenu();
					sm.setVisible(true);
					dispose();
				}
				
				if(flag == 1 && usertype.equals("Tourist"))
				{
					TouristMenu sm = new TouristMenu();
					sm.setVisible(true);
					dispose();
				}
				
				if(flag==0)
				{
					JOptionPane.showMessageDialog(null, "Invalid Username or password!");
				}
			
				
			}
		});
		btnNewButton.setBounds(181, 187, 68, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				dispose();
			}
		});
		btnNewButton_1.setBounds(259, 187, 68, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("city.png"));
		lblNewLabel_3.setBounds(0, 0, 436, 263);
		contentPane.add(lblNewLabel_3);
	}
}
class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(43, 46, 106, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(43, 87, 106, 13);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(159, 43, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 84, 96, 19);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user, pass;
				user = textField.getText();
				pass = String.valueOf(passwordField.getPassword());
				String ad = "admin";
				
				if(user.equals(ad) && pass.equals(ad))
				{
					AdminMenu admin = new AdminMenu();
					admin.setVisible(true);
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Username or password!");
				}
			}
		});
		btnNewButton.setBounds(159, 143, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(159, 174, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("city2.png"));
		lblNewLabel_2.setBounds(0, 0, 381, 242);
		contentPane.add(lblNewLabel_2);
	}

}
class AdminMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public AdminMenu() {
		setTitle("AdminMenu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Data");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(35, 39, 97, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddData a = new AddData();
				a.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(154, 42, 97, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Delete Data");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(35, 113, 129, 33);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DeleteData d = new DeleteData();
				d.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(154, 115, 97, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(47, 207, 97, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("city1.png"));
		lblNewLabel_2.setBounds(0, 0, 381, 272);
		contentPane.add(lblNewLabel_2);
	}
}
 class StudentMenu extends JFrame {
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMenu frame = new StudentMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentMenu() {
		setTitle("StudentMenu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View Colleges");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(29, 23, 175, 23);
		contentPane.add(lblNewLabel);
		
		List<String> stringListclg = new ArrayList<String>();
		try {
		      File myObj = new File("places.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(data.equals("College"))
		        {
		        	stringListclg.add(myReader.nextLine());
		        	String d = myReader.nextLine();
		        	String e = myReader.nextLine();
		        	String f = myReader.nextLine();
		        }
		        
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		String[] stringArrclg = stringListclg.toArray( new String[] {} );
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(stringArrclg));
		comboBox.setBounds(29, 66, 536, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("View College");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String place, name;
				name = comboBox.getSelectedItem().toString();
				place = "College";
				DisplayPlaces dp = new DisplayPlaces(place,name);
				dp.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(29, 110, 123, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("View Libraries");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(29, 178, 175, 23);
		contentPane.add(lblNewLabel_1);
		
		
		
		
		List<String> stringListlib = new ArrayList<String>();
		try {
		      File myObj = new File("places.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(data.equals("Library"))
		        {
		        	stringListlib.add(myReader.nextLine());
		        	String d = myReader.nextLine();
		        	String e = myReader.nextLine();
		        	String f = myReader.nextLine();
		        }
		        
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		String[] stringArrlib = stringListlib.toArray( new String[] {} );
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(stringArrlib));
		comboBox_1.setBounds(29, 225, 536, 21);
		contentPane.add(comboBox_1);
		
		
		JButton btnNewButton_1 = new JButton("View Library");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String place, name;
				name = comboBox_1.getSelectedItem().toString();
				place = "Library";
				DisplayPlaces dp = new DisplayPlaces(place,name);
				dp.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(28, 269, 124, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(177, 269, 99, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\5 th sem\\java\\SmartCity\\JavaImages\\unnamed.jpg"));
		lblNewLabel_2.setBounds(0, 0, 634, 377);
		contentPane.add(lblNewLabel_2);
	}
}
class DisplayPlaces extends JFrame {
	

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//DisplayPlaces frame = new DisplayPlaces();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DisplayPlaces(String place,String name) {
		setTitle("DisplayPlaces");
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(25, 23, 45, 13);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(118, 20, 191, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contact Info");
		lblNewLabel_1.setBounds(25, 168, 79, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(118, 165, 191, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setBounds(25, 205, 65, 13);
		contentPane.add(lblNewLabel_2);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(25, 237, 284, 93);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_3 = new JLabel("About");
		lblNewLabel_3.setBounds(25, 51, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(25, 70, 284, 81);
		contentPane.add(textArea_1);
		
		try {
		      File myObj = new File("places.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String plc = myReader.nextLine();
		        String nm = myReader.nextLine();
		        String abt = myReader.nextLine();
		        String ctc = myReader.nextLine();
		        String addr = myReader.nextLine();
		        if(plc.equals(place)&&name.equals(nm))
		        {
		        	textField.setText(nm);
		        	textField_1.setText(ctc);
		        	textArea.setText(abt);
		        	textArea_1.setText(addr);
		        	
		        }
		        
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(226, 354, 83, 19);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("E:\\5 th sem\\java\\SmartCity\\JavaImages\\images (3).jpg"));
		lblNewLabel_4.setBounds(0, 0, 419, 437);
		contentPane.add(lblNewLabel_4);
	}
}
class TouristMenu extends JFrame {
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TouristMenu frame = new TouristMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TouristMenu() {
		setTitle("TouristMenu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View Hotels");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(29, 23, 175, 23);
		contentPane.add(lblNewLabel);
		
		List<String> stringListclg = new ArrayList<String>();
		try {
		      File myObj = new File("places.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(data.equals("Hotel"))
		        {
		        	stringListclg.add(myReader.nextLine());
		        	String d = myReader.nextLine();
		        	String e = myReader.nextLine();
		        	String f = myReader.nextLine();
		        }
		        
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		String[] stringArrclg = stringListclg.toArray( new String[] {} );
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(stringArrclg));
		comboBox.setBounds(29, 66, 536, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("View Hotels");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String place, name;
				name = comboBox.getSelectedItem().toString();
				place = "Hotel";
				DisplayPlaces dp = new DisplayPlaces(place,name);
				dp.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(29, 110, 123, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("View Attractions");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(29, 178, 175, 23);
		contentPane.add(lblNewLabel_1);
		
		
		
		
		List<String> stringListlib = new ArrayList<String>();
		try {
		      File myObj = new File("places.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(data.equals("Tourist Attraction"))
		        {
		        	stringListlib.add(myReader.nextLine());
		        	String d = myReader.nextLine();
		        	String e = myReader.nextLine();
		        	String f = myReader.nextLine();
		        }
		        
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		String[] stringArrlib = stringListlib.toArray( new String[] {} );
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(stringArrlib));
		comboBox_1.setBounds(29, 225, 536, 21);
		contentPane.add(comboBox_1);
		
		
		JButton btnNewButton_1 = new JButton("View Attractions");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String place, name;
				name = comboBox_1.getSelectedItem().toString();
				place = "Tourist Attraction";
				DisplayPlaces dp = new DisplayPlaces(place,name);
				dp.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(28, 269, 124, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(177, 269, 99, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\5 th sem\\java\\SmartCity\\JavaImages\\unnamed.jpg"));
		lblNewLabel_2.setBounds(0, 0, 634, 377);
		contentPane.add(lblNewLabel_2);
	}
}
 
class College
{
	String name;
	String about;
	String contactInfo;
	String address;
	
	public College()
	{
		
	}
	
	public College(String nm,String abt, String cinf, String add)
	{
		name = nm;
		about = abt;
		contactInfo = cinf;
		address = add;
	}
	
}

class TouristAttractions
{
	String name;
	String about;
	String contactInfo;
	String address;
	
	public TouristAttractions()
	{
		
	}
	
	public TouristAttractions(String nm,String abt, String cinf, String add)
	{
		name = nm;
		about = abt;
		contactInfo = cinf;
		address = add;
	}
	
}

class Libraries
{
	String name;
	String about;
	String contactInfo;
	String address;
	
	public Libraries()
	{
		
	}
	
	public Libraries(String nm,String abt, String cinf, String add)
	{
		name = nm;
		about = abt;
		contactInfo = cinf;
		address = add;
	}
	
}

class Hotels
{
	String name;
	String about;
	String contactInfo;
	String address;
	
	public Hotels()
	{
		
	}
	
	public Hotels(String nm,String abt, String cinf, String add)
	{
		name = nm;
		about = abt;
		contactInfo = cinf;
		address = add;
	}
	
}

 class AddData extends JFrame {
	
	public ArrayList<Hotels> hotels = new ArrayList<Hotels>();
	public ArrayList<Libraries> libraries = new ArrayList<Libraries>();
	public ArrayList<TouristAttractions> touristAttractions = new ArrayList<TouristAttractions>();
	public ArrayList<College> colleges = new ArrayList<College>();

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					AddData frame = new AddData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public AddData() {
		setTitle("AddData");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(139, 38, 191, 19);
		contentPane.add(textField);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(46, 41, 45, 13);
		contentPane.add(lblNewLabel);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(46, 88, 284, 81);
		contentPane.add(textArea_1);
		
		JLabel lblNewLabel_3 = new JLabel("About");
		lblNewLabel_3.setBounds(46, 69, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(139, 183, 191, 19);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("Contact Info");
		lblNewLabel_1.setBounds(46, 186, 79, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setBounds(46, 223, 65, 13);
		contentPane.add(lblNewLabel_2);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(46, 255, 284, 93);
		contentPane.add(textArea);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"College", "Tourist Attraction", "Library", "Hotel"}));
		comboBox.setBounds(46, 7, 136, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Add Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String place;
				String name, about, contact,address;
				about = textArea_1.getText();
				contact = textField_1.getText();
				
				name = textField.getText();
				address = textArea.getText();
			    place = comboBox.getSelectedItem().toString();
			    if(address.length()>50)
			    {
			    	JOptionPane.showMessageDialog(null, "Address should not exceed 50 characters!");
			    }
			    else if(about.equals("")||contact.equals("")||name.equals("")||address.equals("")||contact.length()!=10)
			    {
			    	JOptionPane.showMessageDialog(null, "Invalid Input!");
			    }
			    else
			    {
			    	try {
					      FileWriter myWriter = new FileWriter("places.txt",true);
					      myWriter.write(place+"\n"+name+"\n"+about+"\n"+contact+"\n"+address+"\n");
					      myWriter.close();
					      System.out.println("Successfully wrote to the file.");
					    } catch (IOException e) {
					      System.out.println("An error occurred.");
					      e.printStackTrace();
					    }
				    
				    if(place.equals("College"))
				    {
				    	College coll = new College(name,about,contact,address);
				    	colleges.add(coll);
				    	JOptionPane.showMessageDialog(null, "College Added!");
				    }
				    if(place.equals("Tourist Attraction"))
				    {
				    	TouristAttractions coll = new TouristAttractions(name,about,contact,address);
				    	touristAttractions.add(coll);
				    	JOptionPane.showMessageDialog(null, "Tourist Attraction Added!");
				    }
				    if(place.equals("Library"))
				    {
				    	Libraries coll = new Libraries(name,about,contact,address);
				    	libraries.add(coll);
				    	JOptionPane.showMessageDialog(null, "Library Added!");
				    }
				    if(place.equals("Hotel"))
				    {
				    	Hotels coll = new Hotels(name,about,contact,address);
				    	hotels.add(coll);
				    	JOptionPane.showMessageDialog(null, "Hotel Added!");
				    }
			    }
			    
			    
			    
			}
		});
		btnNewButton.setBounds(46, 381, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(146, 381, 79, 19);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("color1.png"));
		lblNewLabel_4.setBounds(0, 0, 456, 459);
		contentPane.add(lblNewLabel_4);
		
		
		
		
	}
}
class DeleteData extends JFrame {
	
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteData frame = new DeleteData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DeleteData() {
		setTitle("DeleteData");
		
		List<String> colleges = new ArrayList<String>();
		try {
		      File myObj = new File("places.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(data.equals("College"))
		        {
		        	colleges.add(myReader.nextLine());
		        	var d = myReader.nextLine();
		        	var e = myReader.nextLine();
		        	var f = myReader.nextLine();
		        }
		        
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		String[] collegearray = colleges.toArray( new String[] {} );
		
		List<String> library = new ArrayList<String>();
		try {
		      File myObj = new File("places.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(data.equals("Library"))
		        {
		        	library.add(myReader.nextLine());
		        	String d = myReader.nextLine();
		        	String e = myReader.nextLine();
		        	String f = myReader.nextLine();
		        }
		        
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		String[] libraryarray = library.toArray( new String[] {} );
		
		List<String> attractions = new ArrayList<String>();
		try {
		      File myObj = new File("places.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(data.equals("Tourist Attraction"))
		        {
		        	attractions.add(myReader.nextLine());
		        	String d = myReader.nextLine();
		        	String e = myReader.nextLine();
		        	String f = myReader.nextLine();
		        }
		        
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		String[] attractionarray = attractions.toArray( new String[] {} );
		
		List<String> hotels = new ArrayList<String>();
		try {
		      File myObj = new File("places.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        if(data.equals("Hotel"))
		        {
		        	hotels.add(myReader.nextLine());
		        	String d = myReader.nextLine();
		        	String e = myReader.nextLine();
		        	String f = myReader.nextLine();
		        }
		        
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		String[] hotelarray = hotels.toArray( new String[] {} );
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("College");
		lblNewLabel.setBounds(24, 22, 65, 13);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(collegearray));
		comboBox.setBounds(24, 45, 356, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					  String name = comboBox.getSelectedItem().toString();
					  String place ="College";
				      File myObj = new File("places.txt");
				      Scanner myReader = new Scanner(myObj);
				      while (myReader.hasNextLine()) {
				        String plc = myReader.nextLine();
				        String nm = myReader.nextLine();
				        String abt = myReader.nextLine();
				        String ctc = myReader.nextLine();
				        String addr = myReader.nextLine();
				        if(plc.equals(place)&&name.equals(nm))
				        {
				        	
				        }
				        else
				        {
				        	try {
				  		      FileWriter myWriter = new FileWriter("places.txt");
				  		      myWriter.write(plc+"\n"+nm+"\n"+abt+"\n"+ctc+"\n"+addr+"\n");
				  		      myWriter.close();
				  		      System.out.println("Successfully wrote to the file.");
				  		    } catch (IOException e) {
				  		      System.out.println("An error occurred.");
				  		      e.printStackTrace();
				  		    }
				        }
				        
				      }
				      myReader.close();
				    } catch (FileNotFoundException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }
				
			}
		});
		btnNewButton.setBounds(24, 76, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Library");
		lblNewLabel_1.setBounds(24, 121, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(libraryarray));
		comboBox_1.setBounds(24, 144, 349, 21);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					  String name = comboBox_1.getSelectedItem().toString();
					  String place ="Library";
				      File myObj = new File("places.txt");
				      Scanner myReader = new Scanner(myObj);
				      while (myReader.hasNextLine()) {
				        String plc = myReader.nextLine();
				        String nm = myReader.nextLine();
				        String abt = myReader.nextLine();
				        String ctc = myReader.nextLine();
				        String addr = myReader.nextLine();
				        if(plc.equals(place)&&name.equals(nm))
				        {
				        	
				        }
				        else
				        {
				        	try {
				  		      FileWriter myWriter = new FileWriter("places2.txt");
				  		      myWriter.write(plc+"\n"+nm+"\n"+abt+"\n"+ctc+"\n"+addr+"\n");
				  		      myWriter.close();
				  		      System.out.println("Successfully wrote to the file.");
				  		    } catch (IOException e) {
				  		      System.out.println("An error occurred.");
				  		      e.printStackTrace();
				  		    }
				        }
				        
				      }
				      myReader.close();
				    } catch (FileNotFoundException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }
			}
		});
		btnNewButton_1.setBounds(24, 175, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tourist Attractions");
		lblNewLabel_2.setBounds(24, 219, 105, 13);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(attractionarray));
		comboBox_2.setBounds(24, 242, 349, 21);
		contentPane.add(comboBox_2);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					  String name = comboBox_2.getSelectedItem().toString();
					  String place ="Tourist Attraction";
				      File myObj = new File("places.txt");
				      Scanner myReader = new Scanner(myObj);
				      while (myReader.hasNextLine()) {
				        String plc = myReader.nextLine();
				        String nm = myReader.nextLine();
				        String abt = myReader.nextLine();
				        String ctc = myReader.nextLine();
				        String addr = myReader.nextLine();
				        if(plc.equals(place)&&name.equals(nm))
				        {
				        	
				        }
				        else
				        {
				        	try {
				  		      FileWriter myWriter = new FileWriter("places2.txt");
				  		      myWriter.write(plc+"\n"+nm+"\n"+abt+"\n"+ctc+"\n"+addr+"\n");
				  		      myWriter.close();
				  		      System.out.println("Successfully wrote to the file.");
				  		    } catch (IOException e) {
				  		      System.out.println("An error occurred.");
				  		      e.printStackTrace();
				  		    }
				        }
				        
				      }
				      myReader.close();
				    } catch (FileNotFoundException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }
			}
		});
		btnNewButton_2.setBounds(24, 273, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Hotels");
		lblNewLabel_3.setBounds(24, 317, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(hotelarray));
		comboBox_3.setBounds(24, 340, 349, 21);
		contentPane.add(comboBox_3);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					  String name = comboBox_3.getSelectedItem().toString();
					  String place ="Hotel";
				      File myObj = new File("places.txt");
				      Scanner myReader = new Scanner(myObj);
				      while (myReader.hasNextLine()) {
				        String plc = myReader.nextLine();
				        String nm = myReader.nextLine();
				        String abt = myReader.nextLine();
				        String ctc = myReader.nextLine();
				        String addr = myReader.nextLine();
				        if(plc.equals(place)&&name.equals(nm))
				        {
				        	
				        }
				        else
				        {
				        	try {
				  		      FileWriter myWriter = new FileWriter("places2.txt");
				  		      myWriter.write(plc+"\n"+nm+"\n"+abt+"\n"+ctc+"\n"+addr+"\n");
				  		      myWriter.close();
				  		      System.out.println("Successfully wrote to the file.");
				  		    } catch (IOException e) {
				  		      System.out.println("An error occurred.");
				  		      e.printStackTrace();
				  		    }
				        }
				        
				      }
				      myReader.close();
				    } catch (FileNotFoundException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }
			}
		});
		btnNewButton_3.setBounds(24, 371, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Close");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_4.setBounds(119, 371, 83, 21);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("city3.png"));
		lblNewLabel_4.setBounds(0, 0, 492, 450);
		contentPane.add(lblNewLabel_4);
	}

}

 class SignUp extends JFrame {
	public ArrayList<UserDetails> users = new ArrayList<UserDetails>();
	public UserDetails u1 = new UserDetails("Ganesh","ganesh","its_not_ganesh","Student",20);
	public UserDetails u2 = new UserDetails("Gaurav","gaurav","gaurav","Tourist",20);
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUp() {
		users.add(u1);
		users.add(u2);
		setTitle("Sign Up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(70, 31, 129, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(70, 65, 129, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(70, 98, 129, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setBounds(70, 133, 129, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Type of User");
		lblNewLabel_4.setBounds(70, 166, 129, 13);
		contentPane.add(lblNewLabel_4);
		
		String user_type[]={"Student","Tourist"};
		JComboBox comboBox = new JComboBox(user_type);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Student", "Tourist"}));
		comboBox.setBounds(224, 162, 87, 21);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(224, 28, 151, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(224, 95, 151, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(224, 130, 151, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(224, 62, 151, 19);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String usnm,pass,name,ustype,agge;
				int age;
				
				usnm = textField.getText();
				pass = String.valueOf(passwordField.getPassword());
				name = textField_1.getText();
				agge = textField_2.getText();
				
				int flag =0;
				char[] chars = name.toCharArray();
			      StringBuilder sb = new StringBuilder();
			      for(char c : chars){
			         if(Character.isDigit(c)){
			            flag = 1;
			            break;
			         }
			      }
				ustype = comboBox.getSelectedItem().toString();
				
				if(flag==1)
				{
					JOptionPane.showMessageDialog(null, "Name should not contain numbers!!");
				}
				else if(!agge.matches("[0-9]+"))
				{
					JOptionPane.showMessageDialog(null, "Age should be a whole number!!");
				}
				
				else if(usnm.equals("")||pass.equals("")||name.equals("")||textField_2.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Invalid Input!!");
				}
				else
				{
					age = Integer.parseInt(textField_2.getText());
					UserDetails u = new UserDetails(name, pass, usnm, ustype, age);
					users.add(u);
					Login login = new Login();
					login.setVisible(true);
					
					dispose();
				}
				
				
			}
		});
		btnNewButton.setBounds(226, 227, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(321, 227, 76, 21);
		contentPane.add(btnNewButton_1);
	}
}
