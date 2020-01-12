package classes;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JList;
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
	
	public static Product getProduct(String nom) throws SQLException {
		String sql = "SELECT * FROM product WHERE name = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		try {
			stmt.setString(1, nom);
			ResultSet res = stmt.executeQuery();
			Product p = new Product();
			p.setId(res.getInt(1));
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
	
	public static void main(String[] args) throws IOException{
		ArrayList<Product> ProdList = new ArrayList<>();
		addItem(ProdList);
		Map<String, User> usersList1 = new Functions().getUsersList();
		for (int i = 0; i < usersList1.size(); i++) {
			System.out.println(usersList1.get(i).getNickName());
		}
	}
	
	public static void addItem(ArrayList<Product> ProdList){
		if(true){//User.isAdmin == true ) //Add this when database is implemented
		
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
	
	/** Funcion que escribe los elementos de una lista en un fichero
	 * y lo guarda en un path pasado por parámetro*/
	
	public static void writeToFile(String path, JList lista) {
		if(lista.getModel().getSize() == 0) {
			JOptionPane.showMessageDialog(null, "There has to be something in the cart");
		}else {
			int val = lista.getModel().getSize();
			PrintWriter writer = null;
			try {
				writer = new PrintWriter(path);
				
				SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss z");
				Date date = new Date(System.currentTimeMillis());
				
				//Escribe la fecha en la primera linea del fichero.
				writer.println(formatter.format(date));
				writer.println(val);
				for (int i = 0; i < val; i++){
					writer.println(lista.getModel().getElementAt(i));
				}
				JOptionPane.showMessageDialog(null, "Purchase confirmed! Check Your tickets in the main screen");
			}catch(Exception ex) {
				System.out.println(""+ex);
				ex.printStackTrace();
			}finally {
				writer.close();
			}
			System.out.println("Purchase done.");
		}
	}
	
	/** Crea un directorio con mkdir. 
	 *  Usado para crear la carpeta users y 
	 *  luego subcarpetas con el nombre de cada usuario.*/
	
	public static boolean createDirectory(String path) {
		File dir = new File(path);
		boolean ok = dir.mkdir();
		if(!ok){ 
			return false;
		}else{
			return true;
		}
	}
	
	/**Carga los ficheros de un path pasado por parametro.
	 * Usado para cargar los ficheros con el boton de History*/
	
	public static ArrayList<File> loadFiles(String path) {
		File dir = new File(path);
		File[] directoryListing = dir.listFiles();
		ArrayList<File> arr = new ArrayList<File>();
		if( directoryListing != null ) {
			for(File child : directoryListing) {
				System.out.println(child.toString());
				arr.add(child);
			}
		}
		return arr;
	}
}

