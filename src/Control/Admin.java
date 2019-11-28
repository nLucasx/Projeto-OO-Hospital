package Control;
import Model.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.PriorityQueue;

public class Admin extends Account {
    private ArrayList <Employee> allemployees;
    private ProductsQueue HproductList;
    private ProductsQueue CproductList;
    private double balance;
    
    public Admin(String user, String password)
    {
        super(user, password);
        this.allemployees = new ArrayList<Employee>();
        this.balance = 120000;
        this.HproductList = new ProductsQueue();
        this.CproductList = new ProductsQueue();
        HproductList.enqueue(new Products("Seringas", 400));
        HproductList.enqueue(new Products("Caixa de luvas", 140));
        HproductList.enqueue(new Products("Caixa de máscaras", 300));
        HproductList.enqueue(new Products("Agulhas", 70));
        HproductList.enqueue(new Products("Caixa de algodões", 120));
        HproductList.enqueue(new Products("Gazes", 0));
        
        CproductList.enqueue(new Products("Álcool", 20));
        CproductList.enqueue(new Products("Água sanitária", 70));
        CproductList.enqueue(new Products("Detergente", 50));
        CproductList.enqueue(new Products("Desinfetante", 0));
    }
    public void AddEmployee(int age, String name, String gender, String ssn, String crm, String specialization, ArrayList<Doctor>accounts)
    {
        Doctor doctor = new Doctor(name, ssn, gender, age, crm, specialization);
        accounts.add(doctor);
        this.allemployees.add(doctor.getDoctor());
    }
    public void AddEmployee(int age, String name, String gender, String ssn, String specialization)
    {
        Employee nurse = new Nurse(name, ssn, gender, age, specialization);
        this.allemployees.add(nurse);
    }
    public void AddEmployee(int age, String name, String gender, String ssn, int op)
    {
        if (op == 1)
        {
        	Employee recepcionist = new Recepcionist(name, ssn, gender, age);
        	this.allemployees.add(recepcionist);
        }
        else
        {
        	Employee gen_service = new GeneralServices(name, ssn, gender, age);
            this.allemployees.add(gen_service);
        }
    }
    
    public double getBalance() {
		return balance;
	}
    public int getSizeOfQueueH()
    {
    	return this.HproductList.SizeOfQueue();
    }
    public int getSizeOfQueueC()
    {
    	return this.CproductList.SizeOfQueue();
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
    public Products getHProduct(int index)
    {
    	return this.HproductList.getItem(index);
    }
    public Products getCProduct(int index)
    {
    	return this.CproductList.getItem(index);
    }
    public void removeProducts(int option, int index, int number)
    {
    	if (option == 1)
    	{
    		this.HproductList.getItem(index).subAmount(number);
    		this.HproductList.organize();
    	}
    	else if (option == 2)
    	{
    		this.CproductList.getItem(index).subAmount(number);
    		this.CproductList.organize();
    	}
    }
    public void PayEmployees()
    {
    	if (getBalance() > getAllSalary()) this.balance -= getAllSalary();
    }
    public boolean existSsn(String ssn)
    {
        for (Person person : this.allemployees)
        {
            if (person.getSsn().equals(ssn)) return true;
        }
        return false;
    }
    public void addBalance(double money)
    {
    	if (this.getBalance() < 9999999) this.balance += money;
    	else System.out.println("Não é possível adicionar mais saldo!");
    }
    public void addProduct(int option, String name, int number)
    {
    	if (option == 1) 
    	{
    		this.HproductList.enqueue(new Products(name, number));
    	}
    	else if (option == 2) 
    	{
    		this.CproductList.enqueue(new Products(name, number));
    	}
    }
    public void showProducts(int option)
    {
    	if (option == 1)
    	{
    		System.out.println("\nMateriais Hospitalares:");
        	this.HproductList.showQueue(0);
    	}
    	else if (option == 2)
    	{
    		System.out.println("\nMateriais de Limpeza:");
        	this.CproductList.showQueue(0);
    	} 
    }
    public void showProducts()
    {
    	System.out.println("\nMateriais Hospitalares:");
    	this.HproductList.showQueue();
    	System.out.println("\nMateriais de Limpeza:");
    	this.CproductList.showQueue();
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
    public void deleteEmployee(int i)
    {
    	this.allemployees.remove(i);
    }
    public void deleteEmployee(int i, ArrayList<Doctor> accounts)
    {
    	this.allemployees.remove(i);
    	//accounts.removeAccount(doctor);
    }
    public boolean isEmpty()
    {
       return this.allemployees.isEmpty();
    }
}
