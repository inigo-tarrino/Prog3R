package classes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Functions {

	private static Scanner sc;
	private static Map<String, User> usersList;
	User newUser = null;

	public static void addUser(User newUser) {
		usersList.put(newUser.getNickName(), newUser);
	}
	
	public Map<String, User> getUsersList() throws IOException{
		return Functions.usersList;
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

