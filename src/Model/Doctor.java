package Model;
import java.util.ArrayList;
public class Doctor extends Person
{
    private String specialization;
    private String crm;
    private ArrayList<Patient> queue;
    public Doctor(String name, String ssn, String gender, int age, String crm, String specialization) {
        super(name, ssn, gender, age);
        this.queue = new ArrayList();
        this.crm = crm;
        this.specialization = specialization;
    }
    public String getOccupation_area()
    {
        return "Médico";
    }
    
}
