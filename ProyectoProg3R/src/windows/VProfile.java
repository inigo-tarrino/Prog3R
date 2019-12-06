package windows;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import classes.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VProfile extends JFrame {

	JFrame frame;
	private static final long serialVersionUID = 1L;
	private JLabel Nick, e_mail, address, Nick_txt, e_mail_txt, address_txt;
	private JLabelProfile JLP;
	Connection conn;
	private User usuario;

	/**
	 * 1.- Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User u = new User("prueba", "1", "eeee", false);
					VProfile window = new VProfile(u);
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
	public VProfile(User usu) {
		this.usuario = usu;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(500 , 400);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Profile");
		
		JPanel panel_prin = new JPanel();
		panel_prin.setLayout( new BorderLayout());
		JPanel panel_labels = new JPanel();
		panel_labels.setLayout( new GridLayout(3 , 2));
		Nick = new JLabel("NickName: ");
		e_mail = new JLabel("E-mail: ");
		address = new JLabel("Address: ");
		Nick_txt = new JLabel(usuario.getNickName());
		Nick_txt.setBorder( BorderFactory.createLineBorder(Color.BLACK));
		e_mail_txt = new JLabel(usuario.getEmail());
		e_mail_txt.setBorder( BorderFactory.createLineBorder(Color.BLACK));
		address_txt = new JLabel(usuario.getAddress());
		address_txt.setBorder( BorderFactory.createLineBorder(Color.BLACK));
		
		panel_labels.add(Nick);
		panel_labels.add(Nick_txt);
		panel_labels.add(e_mail);
		panel_labels.add(e_mail_txt);
		panel_labels.add(address);
		panel_labels.add(address_txt);
		panel_prin.add(panel_labels , BorderLayout.SOUTH);
		
	
		JLP = new JLabelProfile();
		JLP.setToolTipText("Click to add a profile image");
		JLP.setBorder( BorderFactory.createLineBorder(Color.BLACK));
		panel_prin.add(JLP , BorderLayout.CENTER);
		
		frame.getContentPane().add(panel_prin);
		
		////////
		JLP.addMouseListener( new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image", "jpg", "gif", "png");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					JLP.setIcon(ResizeImage(path));
				}
				else if (result == JFileChooser.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "No file selected");
				}
			}
		});
		
		
	}
	
	public ImageIcon ResizeImage(String path) {
		ImageIcon myImage = new ImageIcon(path);
		Image img = myImage.getImage();
		Image newImg = img.getScaledInstance(JLP.getWidth(), JLP.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}
	public void showData() throws SQLException, ClassNotFoundException{
		String sql = "SELECT NickName, Email FROM user WHERE NickName=? AND Email=?;";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			stmt.setString(1, VentanaSignUp.TFnn.getText());
			stmt.setString(2, VentanaSignUp.TFemail.getText());
		}
	}
}
