
package Model;

import java.util.Scanner;
import Control.Exceptions;

public class Nurse extends Employee{
    private String specialization;
    
    public Nurse(String name, String ssn, String gender, int age, String specialization) {
        super(name, ssn, gender, age, 5000);
        this.specialization = specialization;
    }
    public void triageEvaluation()
    {
        
    }
    public String getOccupation_area()
    {
        return "Enfermeiro";
    }
}
