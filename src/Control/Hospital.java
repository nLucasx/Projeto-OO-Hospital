
package Control;
import java.util.*;

import Model.Products;
import View.Screen;

public class Hospital {
    public String name;
    public Hospital() 
    {
        this.name = "Mais Saúde";
    }
    
    public static void main(String[] args) 
    {
        Hospital hospital = new Hospital();
        hospital.mainMenu();
    }
    public void mainMenu()
    {
        Screen screen = new Screen();
        screen.draw_main_menu();
        Exceptions filter = new Exceptions();
        
        boolean correct_option = false;
        int option = -1;
        while (!correct_option)
        {
            option = filter.verify_menu(3);
            if (option == -2 || option == -1) screen.draw_main_menu();
            switch (option)
            {
                case 1 :
                    System.out.println("Opção indisponível");
                    break;
                case 2 :
                    receptionMenu();
                    break;
                case 3 :
                    administratorMenu();
                    break;
                case 0 :
                    System.out.println("Saindo ...");
                    correct_option = true;
                    break;
            }
        }
    }
    public void administratorMenu()
    {
        Admin admin = new Admin("admin", "admin");
        Screen screen = new Screen();
        Exceptions filter = new Exceptions();
        boolean correct_option = false;
        String user, pass;
        Scanner input = new Scanner(System.in);
        int option = 0;
        while (!correct_option)
        {
            System.out.println("Digite o login:");
            System.out.print("Usuário >> ");
            user = input.nextLine();
            System.out.print("Senha >> ");
            pass = input.nextLine();
            
            if (user.equals(admin.getUser()) && pass.equals(admin.getPassword()))
            {    
                correct_option = true;
            }
            else System.out.println("Senha ou usuário inválidos!");
        }
        
        correct_option = false;
        while (!correct_option)
        {
            screen.draw_admin_menu();
            option = filter.verify_menu(8);
            switch (option)
            {
                case 1 :
                	adminManageEmployees(1, admin);
                    break;
                case 2 :
                	adminManageEmployees(2, admin);
                    break;
                case 3 :
                    adminPayEmployees(admin);
                    break;
                case 4 :
                    adminSearchEmployee(admin);
                    break;
                case 5 :
                	adminAddProducts(admin);
                    break;
                case 6:
                	adminRemoveProducts(admin);
                	break;
                case 7:
                	admin.showProducts();
                	break;
                case 8:
                	adminAddBalance(admin);
                	break;
                case 0 :
                    System.out.println("Saindo ...");
                    correct_option = true;
                    break;
            }
        }
        
    }
    public void adminManageEmployees(int op, Admin admin)

    {
        if (op == 1)
        {
            boolean end = false;
            while (!end)
            {
                System.out.println("\nCadastro de funcionários");
                Screen screen = new Screen();
                Exceptions filter = new Exceptions();
                boolean correct_option = false;
                int option = 0;
                screen.draw_employee_option();
                while (!correct_option)
                {
                    option = filter.verify_menu(4);
                    if (option == -2 || option == -1) screen.draw_employee_option();
                    else correct_option = true;
   
                }
                correct_option = false;
                if (option > 0)
                {
                    String name, ssn = null, gender;
                    int age = 0;
                    Scanner input = new Scanner(System.in);
                    System.out.println("Entre com as informações do funcionário.");
                    System.out.print("Digite o nome >> ");
                    name = input.nextLine();
                    System.out.print("Digite o sexo >> ");
                    gender = input.nextLine();

                    while (!correct_option)
                    {  
                        System.out.print("Digite a idade >> ");
                        age = filter.verify_integer();
                        if (age != -1) correct_option = true;
                    }
                    correct_option = false;
                    
                    while (!correct_option)
                    {
                        System.out.print("Digite o CPF (apenas números) >> ");
                        ssn = input.nextLine();
                        correct_option = filter.verify_ssn(ssn);
                    }

                    if (!admin.exist_ssn(ssn))
                    {
                        if (option == 1)
                        {
                            String crm, specialization;
                            System.out.print("Digite o CRM do médico >> ");
                            crm = input.nextLine();
                            System.out.print("Digite a especialização >> ");
                            specialization = input.nextLine();
                            admin.AddEmployee(age, name, gender, ssn, crm, specialization);
                            System.out.println("Usuário cadastrado com sucesso!");
                        }
                        else if (option == 2)
                        {
                            String specialization;
                            System.out.print("Digite a especialização >> ");
                            specialization = input.nextLine();
                            admin.AddEmployee(age, name, gender, ssn, specialization);
                            System.out.println("Usuário cadastrado com sucesso!");
                        }
                        else if (option == 3)
                        {
                            admin.AddEmployee(age, name, gender, ssn);
                            System.out.println("Usuário cadastrado com sucesso!");
                        }
                        else 
                        {
                            admin.AddEmployee(age, name, gender, ssn, 1);
                            System.out.println("Usuário cadastrado com sucesso!");
                        }
                    }
                    else System.out.println("Erro! Esse cpf já está cadastrado!");
                }
                else end = true;
            }
        }
        else if (op == 2)
        {
            if (!admin.isEmpty())
            {
                System.out.println("\nFuncionários cadastrados: ");
                admin.showEmployee();
                Scanner input = new Scanner(System.in);
                boolean correct_option = false;
                String ssn;
                char choice;
                Exceptions filter = new Exceptions();
                int index = -1;

                while (!correct_option)
                {
                    System.out.print("Digite o CPF (apenas números) >> ");
                    ssn = input.nextLine();
                    correct_option = filter.verify_ssn(ssn);
                    if (correct_option)
                    {
                        index = admin.return_index_of_person(ssn);
                        if (index == -1)
                        {
                            System.out.println("Funcionário não encontrado!");
                            correct_option = false;
                        }
                    }
                }
                System.out.print("Você tem certeza que deseja excluir o funcionário? S(sim)/N(não) >> ");
                choice = input.next().charAt(0);
                if (choice == 'S' || choice == 's')
                {
                    admin.delete_employee(index);
                    System.out.println("O funcionário foi excluído!");
                }
                else System.out.println("Saindo...");
            }
            else System.out.println("Não existe nenhum usuário cadastrado no momento!");
        }
    }
    public void adminSearchEmployee(Admin admin)
    {
    	Exceptions filter = new Exceptions();
    	Scanner input = new Scanner(System.in);
    	boolean correct_option = false;
    	String ssn = null;
    	while (!correct_option)
    	{
    		System.out.print("Digite o CPF (apenas números) >> ");
            ssn = input.nextLine();
            correct_option = filter.verify_ssn(ssn);
    	}
    	if (admin.exist_ssn(ssn))
    	{
    		admin.showEmployee(admin.return_index_of_person(ssn));
    	}
    	else System.out.println("Funcionário não encontrado!");
    }
    public void adminPayEmployees(Admin admin)
    {
    	char choice;
    	Scanner input = new Scanner(System.in);
    	System.out.println("No momento, a clínica possui " + admin.getBalance() + " R$");
    	if (admin.getBalance() < admin.getAllSalary()) System.out.println("Não há saldo o suficiente para pagar todos os funcionários!");
    	else
    	{
    		System.out.println("Deseja pagar todos funcionários? S(sim) / N(não) >> ");
    		choice = input.next().charAt(0);
            if (choice == 'S' || choice == 's')
            {
            	admin.PayEmployees();
        		System.out.println("Foram gastos " + admin.getAllSalary() + " R$ do saldo da clínica");
        		System.out.println("Saldo atual: " + admin.getBalance() + " R$");
            }
    		
    	}
    	
    }
    public void adminAddBalance(Admin admin)
    {
    	Exceptions filter = new Exceptions();
    	double money = 0;
    	boolean correct_option = false;
    	while (!correct_option)
    	{	
    		System.out.print("Digite quanto de saldo você quer adicionar >> ");
    		money = filter.verifyDouble();
    		if (money > 0) correct_option = true; 
    	}
    	admin.addBalance(money);
    	System.out.println("Sucesso! Saldo atual: " + admin.getBalance());
    }
    public void adminAddProducts(Admin admin)
    {
    	Screen screen = new Screen();
    	Exceptions filter = new Exceptions();
    	int option = 0, number = 0;
		boolean correct_option = false, correct_option2 = false;
    	String name = null;
    	Scanner input = new Scanner(System.in);
    	
    	while (!correct_option)
    	{
    		screen.drawProductsMenu();
    		option = filter.verify_menu(2);
    		if (option == -2 || option == -1) screen.drawProductsMenu();
    		else
    		{
    			if (option > 0)
    			{
    				System.out.print("Digite o nome do produto >> ");
    				name = input.nextLine();
    				while(!correct_option2)
    				{	
    					System.out.print("Digite a quantidade >> ");
    					number = filter.verify_integer();
                    	if (number != -1) correct_option2 = true;
    				}
    				admin.addProduct(option, name, number);
    				System.out.println("\n Produto Registrado com sucesso!");
    			}
    			else correct_option = true;
    		}
    	}
    }
    public void adminRemoveProducts(Admin admin)
    {
    	boolean correct_option = false, correct_option2 = false, correct_option3 = false;
    	int option = 0, number = 0, product = 0, amount = 0;
    	Scanner input = new Scanner(System.in);
    	Exceptions filter = new Exceptions();
    	Screen screen = new Screen();
    	while (!correct_option)
    	{
    		screen.drawProductsMenu();
    		option = filter.verify_menu(2);
    		if (option > 0)
    		{
    			while(!correct_option2)
    			{
    				admin.showProducts(option);
    				if (option == 1) 
    				{
    					product = filter.verify_menu(admin.getSizeOfQueueH());
    					if (product > 0) amount = admin.getHProduct(product-1).getAmount();
    				}
   					else if (option == 2) 
   					{
   						product = filter.verify_menu(admin.getSizeOfQueueC());
   						if (product > 0) amount = admin.getCProduct(product-1).getAmount();
   					}
   					
    				if (product > 0 && amount > 0) 
    				{
    					while(!correct_option3)
    					{
    						System.out.print("Digite a quantidade a ser removida do registro >> ");
    						number = filter.verify_integer();
    						if (number > 0)
    						{
    							if (option == 1)
    							{	
    								if (amount >= number)
    								{
    									admin.removeProducts(option, product-1, number);
    									System.out.println("Materiais removidos com sucesso!");
    									correct_option3 = true;
    								}
    								else System.out.println("Esta quantidade é maior que a registrada!");
    							}
    							else
    							{
    								if (amount >= number)
    								{
    									admin.removeProducts(option, product-1, number);
    									System.out.println("Materiais removidos com sucesso!");
    									correct_option3 = true;
    								}
    								else System.out.println("Esta quantidade é maior que a registrada!");
    							}
    						}
    					}
    					correct_option3 = false;
    				}
    				else if (product > 0 && amount == 0) System.out.println("Este produto está em falta!");
    				else correct_option2 = true;
   				}
    			correct_option2 = false;
   			} 
    		else correct_option = true;
    	}
   	}
    	 
    public void receptionMenu()
    {
        Screen screen = new Screen();
        Reception reception = new Reception("recep", "recep");
        boolean correct_option = false;
        Exceptions filter = new Exceptions();
        int option;
        
        while (!correct_option)
        {
            screen.drawReceptionMenu();
            option = filter.verify_menu(4);
            if (option == -2 || option == -1) screen.drawReceptionMenu();
            else
            {	
            	switch (option)
            	{
                	case 1 :
                		//receptionAddPatients(1, reception);
                		break;
                	case 2 :
                		//receptionAddPatients(2, reception);
                		break;
                	case 3 :
                		System.out.println("Opção indisponível");
                    	break;
                	case 4 :
                		//reception.showQueue();
                		break;
                	case 0:
                		correct_option = true;
                		break;
            	}
            }
        }
    }
    public void receptionAddPatients(int op, Reception reception)
    {
        Scanner input = new Scanner(System.in);
        boolean correct_option = false;
        String name, ssn = null, gender;
        Exceptions filter = new Exceptions();
        int age = 0;
        System.out.println("Entre com as informações do paciente.");
        System.out.print("Digite o nome >> ");
        name = input.nextLine();
        System.out.print("Digite o sexo >> ");
        gender = input.nextLine();
        
        while (!correct_option)
        {  
            System.out.print("Digite a idade >> ");
            age = filter.verify_integer();
            if (age != -1) correct_option = true;
        }
        
        correct_option = false;
                    
        while (!correct_option)
        {
            System.out.print("Digite o CPF (apenas números) >> ");
            ssn = input.nextLine();
            correct_option = filter.verify_ssn(ssn);
        }
        
        if (op == 1)
        {
            //reception.Emergency(name, ssn, gender, age);
        }
        else if (op == 2)
        {
            
        }
    }
}
