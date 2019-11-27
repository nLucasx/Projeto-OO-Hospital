package Control;

import java.util.Collections;

import Model.Products;

public class ProductsQueue extends Queue<Products>{

	@Override
	public void enqueue(Products e) 
	{
		int i = super.getIndex(e.toString());
		if (i == -1) super.queue.add(e);
		else super.getItem(i).sumAmount(e.getAmount());
		this.organize();
	}
	public void organize()
	{
		Collections.sort(super.queue);
	}
	public void showQueue(int i) {
		for (Products e : super.queue)
    	{
    		if (e.getAmount() > 0) System.out.println("["+(i+1)+"] - " +e + " : " + e.getAmount() + " unidades.");
    		else System.out.println("["+(i+1)+"] - " + e + ": EM FALTA!");
    		i++;
    	}
		System.out.println("[0] - Sair");
	}
	public void showQueue()
	{
		for (Products e : super.queue)
    	{
    		if (e.getAmount() > 0) System.out.println(e + " : " + e.getAmount() + " unidades.");
    		else System.out.println(e + ": EM FALTA!");
    	}
	}

}
