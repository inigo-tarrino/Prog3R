package ddbb;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JOptionPane;

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
		String pass = u.getPass();
		String email = u.getEmail();
		
		try {
		int ad;
		if(!u.isAdmin()){
			ad = 0;
		}else {
			ad = 1;
		}
		Statement stmt = conn.createStatement();
		String SQL = "INSERT INTO user (NickName, Password, Email, Admin) VALUES ('" + nick + "','" + pass + "','" + email + "','" + ad + "')";
		stmt.executeUpdate(SQL);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public static boolean searchUser(User u) throws SQLException {
		String SQL = "SELECT Nickname, Password FROM user WHERE Nickname= ? AND Password= ?";
		PreparedStatement stmt = conn.prepareStatement(SQL);
		try {
			stmt.setString(1, u.getNickName());
			stmt.setString(2, u.getPass());
			stmt.executeQuery();
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString(1));
				if (u.getNickName().equals(rs.getString("Nickname"))) {
					System.out.println("User exists");
					if (u.getPass().equals(rs.getString("Password"))) {
						System.out.println("Password correct");
						return true;
					}else {
						System.out.println("password incorrect");
						return false;
					}
				}else {
					System.out.println("User does not exist");
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public static int searchUser_by_name(String name , String email) throws SQLException {
		String SQL = "SELECT Nickname, Email, ID FROM user WHERE Nickname= ? AND Email= ?";
		PreparedStatement stmt = conn.prepareStatement(SQL);
		try {
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.executeQuery();
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString(1));
				if (name.equals(rs.getString("Nickname"))) {
					System.out.println("User exists");
					if (email.equals(rs.getString("Email"))) {
						System.out.println("email correct");
						return rs.getInt(3);
					}else {
						System.out.println("email incorrect");
						return -1;
					}
				}else {
					System.out.println("User does not exist");
					return -1;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return -1;
		}
		return -1;
	}
	
	public static HashMap<String, String> RememberUser (User us) {
		String SQL = "SELECT * FROM login";
		boolean exists = false;
		HashMap<String, String> users = new HashMap<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			if(rs.next() ) {
				//System.out.println(rs.getString(1) + " " + rs.getString(2));
				users.put(rs.getString(1), rs.getString(2));
				if ( rs.getString(1).equals(us.getNickName()) ) {
					if(rs.getString(2).equals(us.getPass())) {
						exists = true;
					}
				}
			}
			System.out.println(exists);
			if(!exists) {
				String query = "INSERT INTO login VALUES (? , ?)";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, us.getNickName());
				pstmt.setString(2, us.getPass());
				pstmt.executeUpdate();
			}
		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return users;
	}
	
	public static User completeUser(User user) {
		String SQL = "SELECT * FROM user";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				System.out.println(rs.getString(1));
				if (user.getNickName().equals(rs.getString("Nickname"))) {
					System.out.println("User exists");
					if (user.getPass().equals(rs.getString("Password"))) {
						System.out.println("Password correct");
						user.setEmail(rs.getString("Email"));
						user.setAddress(rs.getString("Adress"));
						user.setCreditCard(rs.getString("CreditCard"));
						return user;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return user;
	}
	public static void storePhoto (String path , String name , String email) throws SQLException {
		String SQL = "Update user set profilePhoto = ? where ID = ?";
		int user_id = searchUser_by_name(name, email);
		try {
			PreparedStatement stmt = conn.prepareStatement(SQL);
			stmt.setString(1, path);
			stmt.setInt(2, user_id);
			stmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
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
	public static String get_profile_image (String name , String email) throws SQLException {
		String SQL = "select profilePhoto from user where ID = ?";
		int user_id = searchUser_by_name(name, email);
		try {
			PreparedStatement stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, user_id);
			ResultSet rs = stmt.executeQuery(SQL);
			String photoPath = rs.getString(1);
			return photoPath;
		}catch (SQLException e2) {
			System.out.println(e2);
			e2.printStackTrace();
			return "";
		}
		
	}
	public static void main(String[] args) throws SQLException {
		verify();
	}
}
