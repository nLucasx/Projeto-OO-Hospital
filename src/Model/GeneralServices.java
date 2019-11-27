
package Model;

public class GeneralServices extends Employee
{
    public GeneralServices(String name, String ssn, String gender, int age) {
        super(name, ssn, gender, age, 998);
    }
    
    public String getOccupation_area()
    {
        return "Serviço geral";
    }
}
