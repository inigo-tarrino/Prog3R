package ddbbcon;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import classes.User;
import ddbb.RegisterUser;

import java.awt.Transparency;
import java.sql.Connection;

public class Connect {

	/** Clase que crea la conexion 
	 * a la base de datos */
	
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
