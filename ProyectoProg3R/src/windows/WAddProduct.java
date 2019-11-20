package windows;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class WAddProduct {

	private JFrame frame;
	private final JLabel lName = new JLabel("Name");
	public static JTextField tFName;
	public static JTextField tFPrice;
	public static JTextField tFDesc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WAddProduct window = new WAddProduct();
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
	public WAddProduct() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frame = new JFrame();
		frame.setTitle("Add Product");
		frame.setBounds(100, 100, 320, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lName.setBounds(10, 64, 58, 38);
		frame.getContentPane().add(lName);
		
		JLabel lPrice = new JLabel("Price");
		lPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lPrice.setBounds(10, 162, 58, 25);
		frame.getContentPane().add(lPrice);
		
		JLabel lDesc = new JLabel("Type");
		lDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lDesc.setBounds(10, 240, 80, 25);
		frame.getContentPane().add(lDesc);
		
		JLabel lblMark = new JLabel("Mark");
		lblMark.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMark.setBounds(10, 323, 58, 25);
		frame.getContentPane().add(lblMark);
		
		tFName = new JTextField();
		tFName.setBounds(169, 76, 96, 19);
		frame.getContentPane().add(tFName);
		tFName.setColumns(10);
		
		tFPrice = new JTextField();
		tFPrice.setBounds(169, 167, 96, 19);
		frame.getContentPane().add(tFPrice);
		tFPrice.setColumns(10);
		
		tFDesc = new JTextField();
		tFDesc.setBounds(169, 245, 96, 19);
		frame.getContentPane().add(tFDesc);
		tFDesc.setColumns(10);
		
		
		
		JRadioButton rB1 = new JRadioButton("1");
		rB1.setBounds(132, 325, 31, 25);
		rB1.setFocusPainted(false);
		frame.getContentPane().add(rB1);
		
		JRadioButton rB2 = new JRadioButton("2");
		rB2.setBounds(165, 325, 31, 25);
		rB2.setFocusPainted(false);
		frame.getContentPane().add(rB2);
		
		JRadioButton rB3 = new JRadioButton("3");
		rB3.setBounds(198, 327, 31, 21);
		rB3.setFocusPainted(false);
		frame.getContentPane().add(rB3);
		
		JRadioButton rB4 = new JRadioButton("4");
		rB4.setBounds(229, 328, 31, 19);
		rB4.setFocusPainted(false);
		frame.getContentPane().add(rB4);
		
		JRadioButton rB5 = new JRadioButton("5");
		rB5.setBounds(262, 325, 31, 25);
		rB5.setFocusPainted(false);
		frame.getContentPane().add(rB5);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rB1);
		bg.add(rB2);
		bg.add(rB3);
		bg.add(rB4);
		bg.add(rB5);
		
		JLabel lTitle = new JLabel("Add Product");
		lTitle.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lTitle.setBounds(107, 26, 96, 25);
		frame.getContentPane().add(lTitle);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(10, 376, 85, 21);
		frame.getContentPane().add(btnBack);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(208, 376, 85, 21);
		frame.getContentPane().add(btnSave);
		
	}
}
