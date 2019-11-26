package Model;
public class DoctorInformation extends Employee
{
    private String specialization;
    private String crm;
    public DoctorInformation(String name, String ssn, String gender, int age, String crm, String specialization) {
        super(name, ssn, gender, age, 10000);
        this.crm = crm;
        this.specialization = specialization;
    }
    public String getOccupation_area()
    {
        return "Médico";
    }
    public String getCrm()
    {
    	return this.crm;
    }
    public String getSpecialization()
    {
    	return this.specialization;
    }
    @Override
    public String toString()
    {
    	return "Dr(a)." + super.getName() + " " + " - Especialização: " + this.getSpecialization() + "\n";
    }
    
}
