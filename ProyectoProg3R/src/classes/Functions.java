package classes;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import ddbbcon.Connect;

public class Functions {

	private static Scanner sc;
	private static Map<String, User> usersList;
	User newUser = null;
	static Connect cct= new Connect();
	static Connection conn = cct.conect();

	public static void addUser(User newUser) {
		usersList.put(newUser.getNickName(), newUser);
	}
	
	public Map<String, User> getUsersList() throws IOException{
		return Functions.usersList;
	}
	
	public static Product get_producto(String nom) throws SQLException {
		String sql = "SELECT * FROM product WHERE name = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		try {
			stmt.setString(1, nom);
			ResultSet res = stmt.executeQuery();
			Product p = new Product();
			p.setId( res.getInt(1) );
			p.setName(nom);
			p.setPrize(res.getDouble(3));
			p.setDesc(res.getString(4));
			return p;
		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			Product p = new Product();
			return p;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		ArrayList<Product> ProdList = new ArrayList<>();
		addItem(ProdList);
		Map<String, User> usersList1 = new Functions().getUsersList();
		for (int i = 0; i < usersList1.size(); i++) {
			System.out.println(usersList1.get(i).getNickName());
		}
	}
	
	public static void addItem(ArrayList<Product> ProdList) 
	{
		if(true)//User.isAdmin == true ) //Add this when database is implemented
		{
			sc = new Scanner(System.in);
			
			System.out.println("Insert id: ");
			int id = sc.nextInt();
			
			System.out.println("Insert name: ");
			String name = sc.next();
			
			System.out.println("Insert price: ");
			double price = sc.nextDouble();
			
			System.out.println("Insert description: ");
			String desc = sc.next();
			
			Product p = new Product(id, name, price, desc) {
			};
			
			ProdList.add(p);
			for (int i = 1; i <= ProdList.size(); i++)
			{
			System.out.println("Item added");
			System.out.println("The product added is: ["+ProdList.get(i-1).getId()+", "+
			ProdList.get(i-1).getName()+", "+ProdList.get(i-1).getPrize()+", "+
			ProdList.get(i-1).getDesc()+", "+"] ");
			}
		}
		else
		System.out.println("Not Enought permissions to do that");
	}
	
	public static void writeToFile(String path, DefaultListModel listModel) {
		if(listModel.getSize() == 0) {
			JOptionPane.showMessageDialog(null, "There has to be something in the cart");
		}else {
			int val = listModel.getSize();
			PrintWriter writer = null;
			try {
				writer = new PrintWriter(path);
				writer.println(val);
				for (int i = 0; i < val; i++) {
					writer.println(listModel.getElementAt(i));
				}
				JOptionPane.showMessageDialog(null, "Purchase confirmed! Check Purchase.txt");
			}catch(Exception ex) {
				System.out.println(""+ex);
			}finally {
				writer.close();
			}
			System.out.println("Compra Realizada");
		}
	}
}

