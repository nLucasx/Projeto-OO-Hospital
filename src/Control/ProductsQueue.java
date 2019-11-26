package Control;

import java.util.Collections;

import Model.Products;

public class ProductsQueue extends Queue<Products>{

	@Override
	public void enqueue(Products e) 
	{
		int i = super.getIndex(e.toString());
		if (i == -1)
		{
			super.queue.add(e);
			Collections.sort(super.queue);
		}
		else
		{
			super.getItem(i).sumAmount(e.getAmount());
		}
	}

	@Override
	public void showQueue() {
		// TODO Auto-generated method stub
		
	}

}
