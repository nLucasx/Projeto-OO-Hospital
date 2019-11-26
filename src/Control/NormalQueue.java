package Control;
import Model.Patient;
import Control.Doctor;
public class NormalQueue extends Queue<Patient>{
	public NormalQueue() {
		super();
	}
	public void enqueue(Patient e) {
		super.queue.add(e);
	}
	@Override
	public void showQueue() {
		
		if (super.SizeOfQueue() > 0)
		{
			System.out.println("\nLista de espera: ");
			for (Patient p : super.queue)
			{
				System.out.println("Nome: " + p.getName());
			}	
		}
		else System.out.println("Nenhum paciente na lista de espera do médico!");
	}

}
