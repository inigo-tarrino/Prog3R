package ddbb;

import java.sql.*;
import java.util.Scanner;


import classes.User;
import ddbbcon.*;
import windows.*;

public class RegisterUser
{
	//Conection with ddbb
	static Connect cct= new Connect();
	static Connection conn = cct.conect();
	
	public static void addUser(User u) 
	{
		String nick = u.getNickName();
		
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
	public static void verify() throws SQLException 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Usuario: ");
		String NickName = s.nextLine();
		
		System.out.println("Contraseña: ");
		String password = s.nextLine();
		s.close();
		
		conn= DriverManager.getConnection("jdbc:sqlite:Database/SecuoiaDDBB.db");
		PreparedStatement stmt2 = conn.prepareStatement("SELECT Nickname FROM User WHERE Nickname=? AND Password = ?");
		//PreparedStatement psn = conn.prepareStatement(null); //NickName
		stmt2.setString(1, NickName);
		stmt2.setString(2, password);

		
		ResultSet rs =stmt2.executeQuery();
		if(rs.next()) 
		{
			System.out.println("Login OK");
		} else 
		{
			System.out.println("Error");
		}
	}
	public static void main(String[] args) throws SQLException {
		verify();
	}
}
