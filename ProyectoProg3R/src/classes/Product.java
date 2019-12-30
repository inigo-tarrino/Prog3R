package classes;

import java.util.List;

public class Product {
	
	protected int id;
	protected String name;
	protected double price;
	protected String desc;
	protected int mark; //NOTA: del 0 al 5
	
	public Product () {
		
	}
	
	
	public Product(int id, String name, double prize, String desc)
	{
		this.id = id;
		this.name = name;
		this.price = prize;
		this.desc = desc;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getPrize() 
	{
		return price;
	}

	public void setPrize(double prize) 
	{
		this.price = prize;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}



	 
}
