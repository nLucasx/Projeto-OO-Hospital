package Control;
import Model.Patient;
public class Report {
	private Patient patient;
	private String description;
	private String medicine;
	public Report(Patient patient, String description, String medicine) {
		this.patient = patient;
		this.description = description;
		this.medicine = medicine;
	}
	
	@Override
	public String toString()
	{
		return "Relatório médico\n" + "Nome: " + this.patient.getName() + "\n" +
				"CPF: " + this.patient.getSsn() + "\n" +
				"Queixa: " + this.description + "\n" + 
				"Remédio prescrito: " + this.medicine + "\n";
				
	}
	public Patient getPatient()
	{
		return this.patient;
	}
}
