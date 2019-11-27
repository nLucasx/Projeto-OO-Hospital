package Control;
import java.util.ArrayList;
import java.util.Scanner;
import Model.DoctorInformation;
import Model.Patient;
import View.DoctorScreen;
public class Doctor extends Account{
	private DoctorInformation information;
	private boolean busy;
	private ArrayList <Patient> myPatients;
	private ArrayList <Report> reports;
	private Queue <Patient> queue;
	private Patient patient;
	public Doctor(String name, String ssn, String gender, int age, String crm, String specialization) {
		super();
		this.information = new DoctorInformation(name, ssn, gender, age, crm, specialization);
		this.busy = false;
		this.myPatients = new ArrayList<Patient>();
		this.reports = new ArrayList<Report>();
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
	public boolean existSsn(String ssn)
	{
		for (int i = 0; i < queue.SizeOfQueue(); i++)
		{
			if (queue.getItem(i).getSsn().equals(ssn)) return true;
		}
		return false;
	}
	public void consultation()
	{
		if (this.getStatus())
		{
			Scanner input = new Scanner(System.in);
			String description = null, medicine = null;
			
			System.out.println("\nConsulta médica");
			System.out.println("\nInformações sobre o paciente: ");
			System.out.println(this.patient.toString());
			System.out.print("Registre a queixa do paciente >> ");
			
			description = input.nextLine();
			
			System.out.print("Registre o remédio que será prescrito >> ");
			
			medicine = input.nextLine();
			
			System.out.println("Sucesso! Um relatório será gerado a partir desta consulta.");
			
			Report newReport = new Report(this.patient, description, medicine);
			this.reports.add(newReport);
			this.myPatients.add(patient);
			this.patient = null;
			this.IamNotBusy();
		}
		else System.out.println("A recepção ainda não chamou um paciente para ser atendido!");
			
	}
	public void searchReport()
	{
		Scanner input = new Scanner(System.in);
		String ssn = null;
		System.out.print("Digite o CPF do paciente >> ");
		ssn = input.nextLine();
		
		for (Report r : reports)
		{
			if (r.getPatient().getSsn().equals(ssn))
			{
				System.out.println(r.toString());
				return;
			}
		}
		System.out.println("Relatório não encontrado");
	}
}
