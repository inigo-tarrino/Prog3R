package BBDD;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Connect {

	private Connection conn = null;
	
	public void conect() throws ClassNotFoundException, SQLException 
	{
		Class.forName("org.sqlite.JDBC");
		
		conn= DriverManager.getConnection("jdbc:sqlite:Database/SecuoiaDB.db");
	}
}
