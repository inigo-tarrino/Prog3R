package Ventanas;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JProgressBar;

public class VLogin extends JFrame{

	JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	protected long i;

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
		passwordField.setBounds((frame.getWidth()/2)-(frame.getWidth()/4), 200, (frame.getWidth()/2), 40);
	//	passwordField.setBounds(x, y, width, height);
		frame.getContentPane().add(passwordField);
		
		JLabel LPassword = new JLabel("Password");
		LPassword.setFont(new Font("Times", Font.PLAIN, 20));
		LPassword.setBounds((frame.getWidth()/2)-40, 154, 100, 40);
		frame.getContentPane().add(LPassword);
		
		textField = new JTextField();
		textField.setBounds((frame.getWidth()/2)-(frame.getWidth()/4), 98, (frame.getWidth()/2), 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel LName = new JLabel("NickName");
		LName.setBounds((frame.getWidth()/2)-30, 51, 100, 40);
		frame.getContentPane().add(LName);
		
		JButton BLogin = new JButton("Login");
		BLogin.setBounds((frame.getWidth()/2)-125, 279, 110, 25);
		frame.getContentPane().add(BLogin);
		
		BLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Login");
				frame.dispose();
				VMain window = new VMain();
				window.ventanaMain.setVisible(true);
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
