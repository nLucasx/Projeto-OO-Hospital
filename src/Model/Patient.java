
package Model;

public class Patient extends Person{
    private int priority;
    private String status; // descrição de como se sente;
    
    public Patient(String name, String ssn, String gender , int age, int priority, String status)
    {
        super(name, ssn, gender, age);
        this.priority = priority;
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }
    public void setPriority(int priority)
    {
    	this.priority = priority;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
}
