package Control;
import java.util.ArrayList;
import Model.DoctorInformation;
import Model.Patient;
import View.DoctorScreen;
public class Doctor extends Account{
	private DoctorInformation information;
	private boolean busy;
	private ArrayList <Patient> myPatients;
	private Queue <Patient> queue;
	private Patient patient;
	public Doctor(String name, String ssn, String gender, int age, String crm, String specialization) {
		super();
		this.information = new DoctorInformation(name, ssn, gender, age, crm, specialization);
		this.busy = false;
		this.myPatients = new ArrayList<Patient>();
		this.queue = new NormalQueue();
		this.patient = null;
		super.setUser(this.information.getSsn());
		super.setPassword(this.information.getCrm());
	}
	public DoctorInformation getDoctor()
	{
		return this.information;
	}
	public void ImBusy()
	{
		this.busy = true;
	}
	public void IamNotBusy()
	{
		this.busy = false;
	}
	public boolean getStatus()
	{
		return this.busy;
	}
	public int getListSize()
	{
		return this.queue.SizeOfQueue();
	}
	public Patient getPatient()
	{
		return this.patient;
	}
	public void setPatient()
	{
		this.patient = this.queue.dequeue();
		this.ImBusy();
	}
	public void showPatients()
	{
		DoctorScreen screen = new DoctorScreen();
		screen.printPatients(myPatients);
	}
	public void showList()
	{
		this.queue.showQueue();
	}
	public void addPatient(Patient p)
	{
		this.queue.enqueue(p);
	}
}
