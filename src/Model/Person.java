
package Model;
public class Person {
    private String name;
    private String ssn; // social_security_number;
    private String gender;
    private int age;

    public Person(String name, String ssn, String gender, int age)
    {
        this.name = name;
        this.ssn = ssn;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    
    public String getGender() {
        return gender;
    }

    public String getSsn() {
        return ssn;
    }
    
    public int getAge() {
        return age;
    }
    @Override
    public String toString()
    {
    	return "\nNome: " + this.getName() + "\n" +
    		   "Idade: " + this.getAge() + "\n" + 
    		   "Sexo: " + this.getGender() + "\n" +
    		   "CPF: " + this.getSsn() + "\n";
    			
    }
    
}
