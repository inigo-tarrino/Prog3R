package windows;

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
import java.util.Scanner;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.User;
import ddbb.RegisterUser;

import javax.swing.JButton;
import javax.swing.JProgressBar;

public class VLogin extends JFrame{

	JFrame frame;
	private JTextField loginF;
	private JPasswordField passF;
	protected long i;

	static Connect cct= new Connect();
	static Connection conn = cct.conect();
	/**
	 * Launch the application.
	 */
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
		frame.getContentPane().add(LPassword);
		
		loginF = new JTextField();
		loginF.setBounds((frame.getWidth()/2)-(frame.getWidth()/4), 98, (frame.getWidth()/2), 40);
		frame.getContentPane().add(loginF);
		loginF.setColumns(10);
		
		JLabel LName = new JLabel("NickName");
		LName.setBounds((frame.getWidth()/2)-30, 51, 100, 40);
		frame.getContentPane().add(LName);
		
		JButton BLogin = new JButton("Login");
		BLogin.setBounds((frame.getWidth()/2)-125, 279, 110, 25);
		frame.getContentPane().add(BLogin);
		
		BLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
			@SuppressWarnings("deprecation")
			User user = new User(loginF.getText(), passF.getText());
			boolean verificado = RegisterUser.searchUser(user);
			System.out.println("The user is: " + verificado);
			if (verificado) {
				user = RegisterUser.completeUser(user);
				VMain vM = new VMain(user);
				vM.ventanaMain.setVisible(true);
				frame.dispose();
			} 
		}
	}
		);
		
		JProgressBar barra = new JProgressBar();
		barra.setBounds(0, 330, 578, 14);
		frame.getContentPane().add(barra);
		
		JButton BSignup = new JButton("SignUp");
		BSignup.setBounds((frame.getWidth()/2)+15, 279, 110, 25);
		frame.getContentPane().add(BSignup);
		
		BSignup.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
				{
					System.out.println("Signup");
					frame.dispose();
			    	VentanaSignUp window = new VentanaSignUp();
					window.frame.setVisible(true);	
				}
				
		
		});
		
	}
}
