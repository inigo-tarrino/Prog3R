package classes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/** Clase del carrito de la compra*/

public class Cart
{

    protected ArrayList<Product> cart;
    private double precio = 0;
    
    public Cart () {
    	cart = new ArrayList<Product>();
    }

    public Product getProduct(int ind) {
        Product pr = cart.get(ind);
        return pr;
    }
     public double get_Prize() {
    	 return precio;
     }
    
     public void remove_item (int i) {
    	 cart.remove(i);
     }
     
     public double update_prize() {
    	 double prec = 0.0;
    	 DecimalFormat df = new DecimalFormat("#.##");
    	 for (Product p : cart) {
    		 prec += p.getPrize();
    		 df.format(prec);
    	 }
    	 return prec;
     }
    public ArrayList<Product> get_product_array () {
    	return cart;
    }
    public int get_Size() {
    	return cart.size();
    }
    
    public void addProd(Product product) 
    {
        cart.add(product);
        precio += product.getPrize();
    }

    public void removeProd(Product product) {
        
        cart.remove(product);
    }

    public void printcart() {
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
}	

