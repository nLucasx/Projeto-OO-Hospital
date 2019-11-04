
package Model;

public class Recepcionist extends Person 
{
    public Recepcionist(String name, String ssn, String gender, int age) {
        super(name, ssn, gender, age);
    }
    public String getOccupation_area()
    {
        return "Recepcionista";
    }
}
