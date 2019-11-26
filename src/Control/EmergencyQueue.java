package Control;
import Model.Patient;
public class EmergencyQueue extends Queue <Patient>{
	public EmergencyQueue() {
		super();
	}
	@Override	
	public void enqueue(Patient e) {
		super.queue.add(e);
		for (int i = 0; i < super.SizeOfQueue(); i++)
		{
			for (int j = i+1; j < super.SizeOfQueue(); j++)
			{
				if (super.queue.get(i).getPriority() < super.queue.get(j).getPriority())
				{
					Patient temp = super.queue.get(i);
					super.queue.set(i, super.queue.get(j));
					super.queue.set(j, temp);
				}
				else if (super.queue.get(i).getPriority() == super.queue.get(j).getPriority())
				{
					if (super.queue.get(i).getAge() < super.queue.get(j).getAge())
					{
						Patient temp = super.queue.get(i);
						super.queue.set(i, super.queue.get(j));
						super.queue.set(j, temp);
					}
				}
			}
		}
	}
	@Override
	public void showQueue() {
		for (int i = 0; i < super.SizeOfQueue(); i++)
		{
			System.out.println("Nome: " + super.queue.get(i).getName());
		}
	}
}
