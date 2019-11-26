package Control;
import java.util.ArrayList;
public abstract class Queue <E>{
	protected ArrayList<E> queue;
	public Queue() {
		this.queue = new ArrayList<E>();
	}
	public E dequeue()
	{
		return this.queue.remove(0);
	}
	public int SizeOfQueue()
	{
		return this.queue.size();
	}
	public E getItem(int index)
	{
		return this.queue.get(index);
	}
	public int getIndex(String name)
	{
		for (int i = 0; i < this.SizeOfQueue(); i++)
		{
			E e = this.queue.get(i);
			if (name.equals(e.toString()))
			{
				return i;
			}
		}
		return -1;
	}
	public abstract void showQueue();
	public abstract void enqueue(E e);
}
