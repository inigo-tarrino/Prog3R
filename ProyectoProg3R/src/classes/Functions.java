package classes;
import java.util.ArrayList;

public class Functions {

	public static void addUser(ArrayList<User> userList) {
		//Este user luego hay que cambiarlo y coger cada columna de users de la BD.
		User user = new User("e", "1234", "enekovalero@gmail.com", "Barakaldo", true);
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
		addUser(userList);
	}
}

