package ddbbcon;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.awt.Transparency;
import java.sql.Connection;

public class Connect {

	private Connection conn = null;
	
	public Connection conect()
	{
		try {
			Class.forName("org.sqlite.JDBC");	
			conn= DriverManager.getConnection("jdbc:sqlite:Database/SecuoiaDDBB");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid credentials");
		}
		return conn;
		
	
	}

}
