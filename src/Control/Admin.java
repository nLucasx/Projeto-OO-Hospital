package Control;
import Model.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Admin {
    private String user;
    private String password;
    private ArrayList <Person> allemployees;
    private ArrayList <Recepcionist> recepcionists;
    private ArrayList <Doctor> doctors;
    private ArrayList <GeneralServices> gen_services;
    private ArrayList <Nurse> nurses;
    private double balance;
    
    public Admin(String user, String password)
    {
        this.password = password;
        this.user = user;
        this.recepcionists = new ArrayList();
        this.doctors = new ArrayList();
        this.gen_services = new ArrayList();
        this.nurses = new ArrayList();
        this.allemployees = new ArrayList();
        this.balance = 120000;
    }
    public void AddEmployee(int age, String name, String gender, String ssn, String crm, String specialization)
    {
        Doctor doctor = new Doctor(name, ssn, gender, age, crm, specialization);
        this.doctors.add(doctor);
        this.allemployees.add(doctor);
    }
    public void AddEmployee(int age, String name, String gender, String ssn, String specialization)
    {
        Nurse nurse = new Nurse(name, ssn, gender, age, specialization);
        this.nurses.add(nurse);
        this.allemployees.add(nurse);
    }
    public void AddEmployee(int age, String name, String gender, String ssn)
    {
        Recepcionist recepcionist = new Recepcionist(name, ssn, gender, age);
        this.recepcionists.add(recepcionist);
        this.allemployees.add(recepcionist);
    }
    public void AddEmployee(int age, String name, String gender, String ssn, int teste)
    {
        GeneralServices gen_service = new GeneralServices(name, ssn, gender, age, teste);
        this.gen_services.add(gen_service);
        this.allemployees.add(gen_service);
    }
    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }
    public boolean exist_ssn(String ssn)
    {
        for (Person person : this.allemployees)
        {
            if (person.getSsn().equals(ssn)) return true;
        }
        return false;
    }
    
    public int return_index_of_person(String ssn)
    {
        for (int i = 0; i < this.allemployees.size(); i++)
        {
            if (this.allemployees.get(i).getSsn().equals(ssn)) return i;
        }
        return -1;
    }
    public void show_employees()
    {
        for (int i = 0; i < allemployees.size(); i++)
        {
            System.out.println("Nome: " + allemployees.get(i).getName());
            System.out.println("CPF: " + allemployees.get(i).getSsn());
            System.out.println("Área de atuação: " + allemployees.get(i).getOccupation_area());
            System.out.println("Idade: " + allemployees.get(i).getAge());
        }
    }
    public void delete_employee(int i)
    {
        Person removed = this.allemployees.remove(i);
        if (removed.getOccupation_area().equals("Médico")) removed = this.doctors.remove(i);
        else if (removed.getOccupation_area().equals("Recepcionista")) removed = this.recepcionists.remove(i);
        else if (removed.getOccupation_area().equals("Enfermeiro")) removed = this.nurses.remove(i);
        else removed = this.gen_services.remove(i);
    }
    public boolean isEmpty()
    {
       return this.allemployees.isEmpty();
    }
}
