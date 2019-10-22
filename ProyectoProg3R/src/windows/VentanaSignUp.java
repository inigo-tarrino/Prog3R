package windows;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;

import classes.Functions;
import classes.User;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JPasswordField;

public class VentanaSignUp {

	JFrame frame;
	JButton btnSU;
	private JTextField TFnn;
	private JPasswordField TFpass;
	private JTextField TFemail;
	private ArrayList<User> userList;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSignUp window = new VentanaSignUp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public VentanaSignUp() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(new Dimension(450, 450));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 413);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel NickName = new JLabel("Nickname:");
		NickName.setFont(new Font("Tahoma", Font.PLAIN, 21));
		NickName.setBounds(39, 65, 105, 33);
		panel.add(NickName);
		
		JLabel PassWord = new JLabel("Password:");
		PassWord.setFont(new Font("Tahoma", Font.PLAIN, 21));
		PassWord.setBounds(39, 150, 105, 33);
		panel.add(PassWord);
		
		JLabel Email = new JLabel("Email:");
		Email.setFont(new Font("Tahoma", Font.PLAIN, 21));
		Email.setBounds(39, 231, 105, 33);
		panel.add(Email);
		
		TFnn = new JTextField();
		TFnn.setBounds(223, 72, 105, 27);
		panel.add(TFnn);
		TFnn.setColumns(10);
		
		TFpass = new JPasswordField();
		TFpass.setColumns(10);
		TFpass.setBounds(223, 157, 105, 27);
		panel.add(TFpass);
		
		TFemail = new JTextField();
		TFemail.setColumns(10);
		TFemail.setBounds(223, 238, 105, 27);
		panel.add(TFemail);
		
		btnSU = new JButton("SIGN UP");
		btnSU.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSU.setBounds(293, 350, 120, 33);
		btnSU.setFocusPainted(false);
		panel.add(btnSU);
		userList = new ArrayList<>();
		btnSU.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				validateNickName(TFnn, "Please enter a nickname");
				validatePassword(TFpass, "please enter a valid password (must be 8 or more characters)");
				validateEmail(TFemail);
				Functions.addUser(userList);
				frame.dispose();
				VMain vM = new VMain();
				vM.ventanaMain.setVisible(true);
			}

			
		});
		
		JCheckBox chckbxAdmin = new JCheckBox("Admin");
		chckbxAdmin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxAdmin.setBounds(155, 298, 105, 27);
		chckbxAdmin.setFocusPainted(false);
		panel.add(chckbxAdmin);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBack.setBounds(24, 350, 120, 33);
		btnBack.setFocusPainted(false);
		panel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				VLogin vL = new VLogin();
				vL.frame.setVisible(true);
				
				
			}
		});
	}
	
	public boolean validateNickName(JTextField TFnn, String errormsg){
	  if (TFnn.getText().equals("")) {
		  return failedMessage( TFnn, errormsg );
	  }else {
		  return true;
	  }  
	}
	
	public boolean validatePassword(JTextField TFpass, String errormsg){
	  if (TFpass.getText().equals("") || TFpass.getText().length() < 8) {
		  return failedMessage( TFpass, errormsg );
	  }else {
		  return true; 
	  }  
	}

	private void validateEmail(JTextField TFemail) {
		String regex = "^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$";
		if (Pattern.matches(regex, TFemail.getText())) {
		}else{
		  failedMessage(TFemail, "Please enter a valir email.");
		}
	}

	private boolean failedMessage(JTextField f, String errormsg) {
		JOptionPane.showMessageDialog(null, errormsg); 
		f.requestFocus();
		return false;
	}
}
