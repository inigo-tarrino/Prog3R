package windows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import ddbbcon.Connect;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.User;
import ddbb.RegisterUser;

import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;

public class VLogin extends JFrame{

	static Logger log;
	JFrame frame;
	private JTextField loginF;
	private JPasswordField passF;
	protected long i;
	private HashMap<String , String> us;

	static Connect cct= new Connect();
	static Connection conn = cct.conect();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VLogin window = new VLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VLogin() {
		//Generando el log
		try {
			log = Logger.getLogger("LoginLog");
			Handler h = new FileHandler("Login.xml");
			
			log.addHandler(h);
			log.setLevel(Level.FINEST);
			h.setLevel(Level.FINEST);
		}catch (Exception e){
			System.err.println("Not log file found");
		}
		log.log(Level.INFO,"App Inicialized on" +(new Date()));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Sequoia");
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		
		passF = new JPasswordField();
		passF.setBounds((frame.getWidth()/2)-(frame.getWidth()/4), 200, (frame.getWidth()/2), 40);
		frame.getContentPane().add(passF);
		
		JLabel LPassword = new JLabel("Password");
		LPassword.setBounds((frame.getWidth()/2)-30, 154, 100, 40);
		LPassword.setOpaque(false);
		frame.getContentPane().add(LPassword);
		
		loginF = new JTextField();
		loginF.setBounds((frame.getWidth()/2)-(frame.getWidth()/4), 98, (frame.getWidth()/2), 40);
		frame.getContentPane().add(loginF);
		loginF.setColumns(10);
		
		
		
		JLabel LName = new JLabel("NickName");
		LName.setBounds((frame.getWidth()/2)-30, 51, 100, 40);
		frame.getContentPane().add(LName);
		
		JButton BLogin = new JButton("Login");
		BLogin.setFocusPainted(false);
		BLogin.setBounds((frame.getWidth()/2)-125, 279, 110, 25);
		frame.getContentPane().add(BLogin);

		
		BLogin.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
			@SuppressWarnings("deprecation")
			User user = new User(loginF.getText(), passF.getText());
			boolean verificado = false;
			try{
				//Busca el usuario introducido el la base de datos.
				verificado = RegisterUser.searchUser(user);
			}catch (SQLException e1){
				e1.printStackTrace();
			}
			System.out.println("The user is: " + verificado);
			if(verificado==false) {
				JOptionPane.showMessageDialog(null, "Please enter a valid user");
			}
			if (verificado) {
				//Recoge todos los datos del usuario para pasarlos luego a otras ventanas.
				user = RegisterUser.completeUser(user);			
				VMain vM = new VMain(user);
				vM.ventanaMain.setVisible(true);
				frame.dispose();
			} 
		}
	}
		);
		JProgressBar barra = new JProgressBar();
		//barra.setBounds(0, 330, 578, 14);
		frame.getContentPane().add(barra);
		
		JButton BSignup = new JButton("SignUp");
		BSignup.setBounds((frame.getWidth()/2)+15, 279, 110, 25);
		BSignup.setFocusPainted(false);
		frame.getContentPane().add(BSignup);
		
		BSignup.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) 
				{
					System.out.println("Signup");
					frame.dispose();
			    	VentanaSignUp window = new VentanaSignUp();
					window.frame.setVisible(true);	
				}
				
		
		});
		
	}
	
	class ventanaRemember extends JFrame{
		
		private static final long serialVersionUID = 1L;

		public ventanaRemember() {
			this.setSize(400 , 100);
			this.setTitle("Registered Users");
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.setLocationRelativeTo(null);
			
			String[] menuItems = { "Ping", "Traceroute", "Netstat", "Dig" };
			JList<String> list = new JList<String>(menuItems);
			JScrollPane scrollPane = new JScrollPane(list);
			
			getContentPane().add(scrollPane , BorderLayout.CENTER);
		}
	}
}
