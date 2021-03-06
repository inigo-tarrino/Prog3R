package ddbb;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ddbbcon.Connect;

import windows.*;

public class RegisterProduct{

	Connect cct= new Connect();
	Connection conn = cct.conect();
	public void addProduct(){
		
		String SQL = "INSERT INTO product (id, name, prize, desc) VALUES(?,?,?,?)";
		try 
		{
			PreparedStatement psid = conn.prepareStatement(SQL); //P_ID
			psid.setString(1, null);
			PreparedStatement psn = conn.prepareStatement(SQL); //P_Name
			psn.setString(2, windows.WAddProduct.tFName.getName());
			PreparedStatement psp = conn.prepareStatement(SQL); //P_Desc
			psp.setString(3, windows.WAddProduct.tFDesc.getName());
			PreparedStatement pse = conn.prepareStatement(SQL); //P_Price
			pse.setString(4, windows.WAddProduct.tFPrice.getName());
			PreparedStatement pscc = conn.prepareStatement(SQL); //CreditCard
			pscc.setString(5, null);
			
		}catch(Exception e)
		{
			System.out.println("Error adding item");
		}
	}
	
}
