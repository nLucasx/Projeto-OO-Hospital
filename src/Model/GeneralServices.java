
package Model;

public class GeneralServices extends Employee
{
    private int teste;
    public GeneralServices(String name, String ssn, String gender, int age, int teste) {
        super(name, ssn, gender, age, 998);
        this.teste = teste;
    }
    
    public String getOccupation_area()
    {
        return "Serviço geral";
    }
}
