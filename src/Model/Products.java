package Model;

public class Products implements Comparable <Products>{
	private String name;
	private int amount;
	
	public Products(String name, int amount) 
	{
		this.name = name;
		this.amount = amount;
	}
	public int getAmount()
	{
		return this.amount;
	}
	public String getName()
	{
		return this.name;
	}
	
	@Override
	
	public int compareTo(Products p) 
	{
		if (this.amount > p.getAmount()) return 1;
		else if (this.amount < p.getAmount()) return -1;
		else return 0;		
	}
}
