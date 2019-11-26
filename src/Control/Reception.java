
package Control;
import Model.Patient;
import Model.DoctorInformation;
public class Reception extends Account{
    Queue <Patient> emergencyList;

    
    public Reception(String user, String password)
    {
        super(user, password);
        this.emergencyList = new EmergencyQueue();

    }
    public void afterTriage(Patient patient)
    {
    	this.emergencyList.enqueue(patient);
    }
    public void callPatient()
    {
    	Patient p = this.emergencyList.dequeue();
    	System.out.println("Paciente " + p.getName() + "compareça a sala de emergência!");
    }
    public void callPatient(Doctor doctor) //overload
    {
        
    }
    public void checkList()
    {
        if (this.emergencyList.SizeOfQueue() > 0)
        {
        	System.out.println("\nLista de espera da emergência");
        	this.emergencyList.showQueue();
        }
        else System.out.println("Nenhum paciente na lista no momento!");
    }
}
