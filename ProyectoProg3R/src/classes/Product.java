package classes;

public abstract class Product {
	
	protected int id;
	protected String name;
	protected double prize;
	protected String desc;
	protected int mark;
	
	public Product()
	{
		this.id = 0;
		this.name = " ";
		this.prize = 0.0;
		this.desc = null;
		this.mark = 0;
	}
	
	public Product(int id, String name, double prize, String desc, int mark)
	{
		this.id = id;
		this.name = name;
		this.prize = prize;
		this.desc = desc;
		this.mark = mark;
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
		return prize;
	}

	public void setPrize(double prize) 
	{
		this.prize = prize;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public int getMark() 
	{
		return mark;
	}

	public void setMark(int mark)
	{
		this.mark = mark;
	}
	
	

	
}
