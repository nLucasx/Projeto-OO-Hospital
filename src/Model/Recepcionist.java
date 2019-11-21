
package Model;

public class Recepcionist extends Employee 
{
    public Recepcionist(String name, String ssn, String gender, int age) {
        super(name, ssn, gender, age, 1500);
    }
    public String getOccupation_area()
    {
        return "Recepcionista";
    }
    
}
