package ddbb;

import java.sql.*;
import ddbbcon.*;
import windows.*;

public class RegisterUser
{
	//Conection with ddbb
	static Connect cct= new Connect();
	static Connection conn = cct.conect();
	
	public static void addUser() 
	{
		String SQL = "INSERT INTO User(Nickname,Password,Email,Adress,CreditCard) VALUES(?,?,?,?,?)";
		try 
		{
			System.out.println("Launching data saver");
			PreparedStatement psn = conn.prepareStatement(SQL); //NickName
			psn.setString(1, windows.VentanaSignUp.TFnn.getText());
			PreparedStatement psp = conn.prepareStatement(SQL); //Password
			psp.setString(2, windows.VentanaSignUp.TFpass.getName());
			PreparedStatement pse = conn.prepareStatement(SQL); //Email
			pse.setString(3, windows.VentanaSignUp.TFemail.getText());
			PreparedStatement psa = conn.prepareStatement(SQL); //Adress
			psa.setString(4, null);
			PreparedStatement pscc = conn.prepareStatement(SQL); //CreditCard
			pscc.setString(5, null);
			
		}catch(Exception e)
		{
			System.out.println(e);
			System.out.println("Error al registrarse");
		}
	}
	
}
