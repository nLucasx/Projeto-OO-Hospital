package Control;
import Model.Patient;
public class Nursery extends Account {
	private Queue<Patient>triageList;
	
	public Nursery(String user, String pass) {
		super(user, pass);
		this.triageList = new NormalQueue();
	}
	public void triageEvaluation(Patient patient, Reception reception)
    {
        reception.afterTriage(patient);
    }
	public void addTriageList(Patient patient)
	{
		this.triageList.enqueue(patient);
	}
	public Patient getPatient()
	{
		return this.triageList.dequeue();
	}
	public boolean existPatient()
	{
		return this.triageList.SizeOfQueue() > 0;
	}
	public boolean existSsn(String ssn)
	{
		for (int i = 0; i < this.triageList.SizeOfQueue(); i++)
		{
			if (this.triageList.getItem(i).getSsn().equals(ssn)) return true;
		}
		return false;
	}
}
