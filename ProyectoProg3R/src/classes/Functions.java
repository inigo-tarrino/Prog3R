package classes;
import java.util.ArrayList;
import java.util.Scanner;

public class Functions {

	private static Scanner sc;

	public static void addUser(ArrayList<User> userList) {
		//Este user luego hay que cambiarlo y coger cada columna de users de la BD.
		User user = new User("e", "1234", "enekovalero@gmail.com", "Barakaldo", true, null);
		for (int i = 0; i <= userList.size(); i++) {
			userList.add(user);
			System.out.println(userList.get(i).getNickName());
		}
			
		
	}
	
	/*public static void deleteUser(ArrayList<User> userList) {
		if(!userList.isEmpty()) {
			for (User u : userList) {
				userList.remove(u);
			}
		}
	}*/
	
	public static void main(String[] args) {
		ArrayList<User> userList = new ArrayList<>();

		ArrayList<Product> ProdList = new ArrayList<>();
	//	addUser(userList);
		
		addItem(ProdList);
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
			
			Product p = new Product(id, name, price, desc, 0) {
			};
			
			ProdList.add(p);
			for (int i = 1; i <= ProdList.size(); i++)
			{
			System.out.println("Item added");
			System.out.println("The product added is: ["+ProdList.get(i-1).getId()+", "+
			ProdList.get(i-1).getName()+", "+ProdList.get(i-1).getPrize()+", "+
			ProdList.get(i-1).getDesc()+", "+ProdList.get(i-1).getMark()+"] ");
			}
		}
		else
		System.out.println("Not Enought permissions to do that");
	}
}

