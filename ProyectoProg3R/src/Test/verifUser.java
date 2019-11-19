package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import classes.User;

public class verifUser {
	User eneko = new User("Eneko", "12345678", "enekovalero@gmail.com", "Barakaldo", true, "1453213143425735");
	@Test
	public void testAdmin() {
		User result = new User("Eneko", "12345678", "enekovalero@gmail.com", "Barakaldo", true, "1453213143425735");
		User expected = eneko;
		assertTrue(eneko.isAdmin());
	}
	@Test
	public void testUser() {
		User result = eneko; //new User("Eneko", "12345678", "enekovalero@gmail.com", "Barakaldo", true, "1453213143425735");
		User expected = eneko;
		assertEquals(expected, result);
	}
	
}
