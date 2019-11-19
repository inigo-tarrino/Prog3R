package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import classes.Product;

public class verifProduct {
	Product product = new Product() {
	};
	Product product2 = new Product() {
	};
	@Test
	public void test() {
		product.setName("Colacao");
		product2.setName("Colacao");
		assertEquals(product.getName(), product2.getName());
	}

}
