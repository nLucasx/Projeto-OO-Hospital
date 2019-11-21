package Model;
import java.util.ArrayList;
public class Doctor extends Employee
{
    private String specialization;
    private String crm;
    private ArrayList<Patient> queue;
    public Doctor(String name, String ssn, String gender, int age, String crm, String specialization) {
        super(name, ssn, gender, age, 10000);
        this.queue = new ArrayList();
        this.crm = crm;
        this.specialization = specialization;
    }
    public String getOccupation_area()
    {
        return "Médico";
    }
}
