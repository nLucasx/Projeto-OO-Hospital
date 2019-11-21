package Control;
import Model.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.PriorityQueue;

public class Admin {
    private String user;
    private String password;
    private ArrayList <Employee> allemployees;
    private ArrayList <Doctor> doctors;
    private ArrayList <Products> HproductList;
    private ArrayList <Products> CproductList;
    private double balance;
    
    public Admin(String user, String password)
    {
        this.password = password;
        this.user = user;
        this.doctors = new ArrayList();
        this.allemployees = new ArrayList();
        this.balance = 120000;
        this.HproductList = new ArrayList();
        this.CproductList = new ArrayList();
        HproductList.add(new Products("Seringas", 400));
        HproductList.add(new Products("Caixa de luvas", 140));
        HproductList.add(new Products("Caixa de máscaras", 300));
        HproductList.add(new Products("Agulhas", 70));
        HproductList.add(new Products("Caixa de algodões", 120));
        HproductList.add(new Products("Gazes", 0));
        
        CproductList.add(new Products("Álcool", 20));
        CproductList.add(new Products("Água sanitária", 70));
        CproductList.add(new Products("Detergente", 50));
        CproductList.add(new Products("Desinfetante", 0));
        Collections.sort(HproductList);
        Collections.sort(CproductList);
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
        this.allemployees.add(nurse);
    }
    public void AddEmployee(int age, String name, String gender, String ssn)
    {
        Recepcionist recepcionist = new Recepcionist(name, ssn, gender, age);
        this.allemployees.add(recepcionist);
    }
    public void AddEmployee(int age, String name, String gender, String ssn, int teste)
    {
        GeneralServices gen_service = new GeneralServices(name, ssn, gender, age, teste);
        this.allemployees.add(gen_service);
    }
    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }
    public double getBalance() {
		return balance;
	}
    public double getAllSalary()
    {
    	double allsalary = 0;
    	for (Employee i : this.allemployees)
    	{
    		allsalary += i.getSalary();
    	}
    	return allsalary;
    }
    public void PayEmployees()
    {
    	if (getBalance() > getAllSalary()) this.balance -= getAllSalary();
    }
    public boolean exist_ssn(String ssn)
    {
        for (Person person : this.allemployees)
        {
            if (person.getSsn().equals(ssn)) return true;
        }
        return false;
    }
    public void addBalance(double money)
    {
    	this.balance += money;
    }
    public void showProducts()
    {
    	System.out.println("\nMateriais Hospitalares:");
    	for (Products e : this.HproductList)
    	{
    		if (e.getAmount() > 0) System.out.println(e.getName() + " : " + e.getAmount() + " unidades.");
    		else System.out.println(e.getName() + ": EM FALTA!");
    	}
    	
    	System.out.println("\nMateriais de Limpeza:");
    	for (Products e : this.CproductList)
    	{
    		if (e.getAmount() > 0) System.out.println(e.getName() + " : " + e.getAmount() + " unidades.");
    		else System.out.println(e.getName() + ": EM FALTA!");
    	}
    }
    public int return_index_of_person(String ssn)
    {
        for (int i = 0; i < this.allemployees.size(); i++)
        {
            if (this.allemployees.get(i).getSsn().equals(ssn)) return i;
        }
        return -1;
    }
    public void showEmployee(int index)
    {
    	System.out.println("\nNome: " + allemployees.get(index).getName());
        System.out.println("CPF: " + allemployees.get(index).getSsn());
        System.out.println("Área de atuação: " + allemployees.get(index).getOccupation_area());
        System.out.println("Idade: " + allemployees.get(index).getAge() + "\n");
    }
    public void showEmployee()
    {
        for (int i = 0; i < allemployees.size(); i++)
        {
            System.out.println("\nNome: " + allemployees.get(i).getName());
            System.out.println("CPF: " + allemployees.get(i).getSsn());
            System.out.println("Área de atuação: " + allemployees.get(i).getOccupation_area());
            System.out.println("Idade: " + allemployees.get(i).getAge() + "\n");
        }
    }
    public void delete_employee(int i)
    {
        Employee removed = this.allemployees.remove(i);
        if (removed.getOccupation_area().equals("Médico")) this.doctors.remove(removed);
    }
    public boolean isEmpty()
    {
       return this.allemployees.isEmpty();
    }
}
