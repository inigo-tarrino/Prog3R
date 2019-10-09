package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JProgressBar;

public class VLogin {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;

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
		
		passwordField = new JPasswordField();
		passwordField.setBounds((frame.getWidth()/2)-125, 200, 250, 40);
	//	passwordField.setBounds(x, y, width, height);
		frame.getContentPane().add(passwordField);
		
		JLabel LPassword = new JLabel("Password");
		LPassword.setBounds((frame.getWidth()/2)-30, 154, 100, 40);
		frame.getContentPane().add(LPassword);
		
		textField = new JTextField();
		textField.setBounds((frame.getWidth()/2)-125, 98, 250, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel LName = new JLabel("NickName");
		LName.setBounds((frame.getWidth()/2)-30, 51, 100, 40);
		frame.getContentPane().add(LName);
		
		JButton BLogin = new JButton("Login");
		BLogin.setBounds((frame.getWidth()/2)-125, 279, 110, 25);
		frame.getContentPane().add(BLogin);
		
		JButton BSignup = new JButton("SignUp");
		BSignup.setBounds((frame.getWidth()/2)+15, 279, 110, 25);
		frame.getContentPane().add(BSignup);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(0, 330, 578, 14);
		frame.getContentPane().add(progressBar);
	}
}
