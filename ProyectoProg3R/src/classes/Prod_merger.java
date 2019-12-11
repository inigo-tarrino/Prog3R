package classes;
import java.util.ArrayList;
import java.util.List;
public class Prod_merger {

	    private final List<Product> products = new ArrayList<Product>();

	    public Prod_merger ()
	    {
	        this.saveItems();
	    }
	    
	    public List<Product> getProducts() {
	        return products;
	    }
	    
	    public void saveItems() {
	    //    String [] productNames = {"", "", "",""};
	    //    Double [] productPrice = {0.0d, 0.0d, 0.0d,0.0d};
	    //
	        
	        for (int i=0; i < 5/*productNames.length*/; i++) {
	            this.products.add(new Product(i+1, "", 5, null));
	            //Mejorponer todo el stock que tengamos en este metodo en los
	            //array de arriba y que este for los recorra
	        }
	    }
	}

