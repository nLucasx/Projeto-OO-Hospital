
package Model;

public class Nurse extends Person{
    private String specialization;
    
    public Nurse(String name, String ssn, String gender, int age, String specialization) {
        super(name, ssn, gender, age);
        this.specialization = specialization;
    }
    public String getOccupation_area()
    {
        return "Enfermeiro";
    }
}
