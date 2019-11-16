package ddbb;

import java.sql.*;
import ddbbcon.*;
import windows.*;

public class RegisterUser
{
	//Conection with ddbb
	Connect cct= new Connect();
	Connection conn = cct.conect();
	
	public void addUser() 
	{
		String SQL = "INSERT INTO user(Nickname,Password,Email,Adress,CreditCard) VALUES(?,?,?,?,?)";
		try 
		{
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
			
		}
	}
	
}
