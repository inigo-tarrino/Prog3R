package classes;

import java.util.ArrayList;
import java.util.List;

public class Cart
{

    static List<Product> cart = new ArrayList<Product>();
    
    public void addProdbyID(int pid) {
        Product product = getProductByProductID(pid);
        addProd(product);
    }

    private Product getProductByProductID(int pid) {
        Product product = null;
        List<Product> products = new Prod_merger().getProducts();
        for (Product prod: products) {
            if (prod.getId() == pid) {
                product = prod;
                break;
            }
        }
        return product;
    }
    
    private static void addProd(Product product) 
    {
        cart.add(product);
    }

    public static void removeProd(Product product) {
        
        cart.remove(product);
    }

    public static void printcart() {
    	int i = 0;
    	
        if(cart.size()==0)
        {
        System.out.println("0 items on it");
        }
        else 
        {
        	  for (Product prod: cart)
              {
                System.out.println(prod.getName());
                i++;
                System.out.println("You have an amount of "+i+" on your shopping cart");
              }
        }
    }
    public static void main(String[] args) {
    	Product p = new Product();
    	Product p1 = new Product(2,"Epri",4," ");
    	Product p2 = new Product(3,"Colacao",5," ");
    	addProd(p);
    	addProd(p1);
    	addProd(p2);
		printcart();
		
		System.out.println("Rectification");
		
		removeProd(p2);
		printcart();
		
	}
}	

