
package Model;

public abstract class Employee extends Person{

    double salary;
	public Employee(String name, String ssn, String gender, int age, double salary) {
        super(name, ssn, gender, age);
        this.salary = salary;
    }
	public double getSalary()
	{
		return this.salary;
	}
    public abstract String getOccupation_area();
}
