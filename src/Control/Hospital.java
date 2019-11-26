
package Control;
import java.util.*;

import Model.Patient;
import Model.Products;
import View.*;

public class Hospital {
	public String name;
	private Admin admin;
	private Reception reception;
	private Nursery nursery;
	private ArrayList<Doctor> doctors;
    public Hospital(String name) 
    {
    	this.name = name;
    	admin = new Admin("admin", "admin");
    	reception = new Reception("recep", "recep");
    	nursery = new Nursery("nursery", "nursery");
    	doctors = new ArrayList<Doctor>();
    }
    public void mainMenu()
    {
        Screen screen = new Screen();
        Exceptions filter = new Exceptions();
        
        boolean correct_option = false;
        int option = -1;
        while (!correct_option)
        {
        	screen.draw_main_menu();
        	option = filter.verify_menu(4);
            switch (option)
            {
                case 1 :
                    doctorsMenu();
                    break;
                case 2 :
                    receptionMenu();
                    break;
                case 3 :
                    administratorMenu();
                    break;
                case 4 :
                	nurseryMenu();
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
        Screen screen = new Screen();
        Exceptions filter = new Exceptions();
        boolean correct_option = false;
        int option = 0;
        while (!correct_option)
        {
           correct_option = admin.Login();
        }
        
        correct_option = false;
        while (!correct_option)
        {
            screen.draw_admin_menu();
            option = filter.verify_menu(8);
            switch (option)
            {
                case 1 :
                	adminManageEmployees(1);
                    break;
                case 2 :
                	adminManageEmployees(2);
                    break;
                case 3 :
                    adminPayEmployees();
                    break;
                case 4 :
                    adminSearchEmployee();
                    break;
                case 5 :
                	adminAddProducts();
                    break;
                case 6:
                	adminRemoveProducts();
                	break;
                case 7:
                	admin.showProducts();
                	break;
                case 8:
                	adminAddBalance();
                	break;
                case 0 :
                    System.out.println("Saindo ...");
                    correct_option = true;
                    break;
            }
        }
        
    }
    public void adminManageEmployees(int op)

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
                            admin.AddEmployee(age, name, gender, ssn, crm, specialization, doctors);
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
    public void adminSearchEmployee()
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
    public void adminPayEmployees()
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
    public void adminAddBalance()
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
    public void adminAddProducts()
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
    public void adminRemoveProducts()
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
        boolean correct_option = false;
        Exceptions filter = new Exceptions();
        int option;
        while (!correct_option)
        {
        	correct_option = reception.Login();
        }
        correct_option = false;
        
        while (!correct_option)
        {
            screen.drawReceptionMenu();
            option = filter.verify_menu(3);
            switch (option)
            {
                case 1 :
               		receptionPatientMenu();
               		break;
               	case 2 :
               		receptionCheckLists();
               		break;
               	case 3 :
               		receptionCallPatient();
                   	break;
               	case 0:
               		correct_option = true;
               		break;
            }
        }
    }
    public void receptionPatientMenu()
    {
    	Screen screen = new Screen();
    	Scanner input = new Scanner(System.in);
    	Exceptions filter = new Exceptions();
    	int option = -1;
    	
    	boolean correct_option = false;
    	while (!correct_option)
    	{
    		screen.drawReceptionConsultationMenu();
    		option = filter.verify_menu(2);
    		switch(option)
    		{
    			case 1:
    				receptionAddPatients(1);
    				break;
    			case 2:
    				if (doctors.size() > 0) receptionAddPatients(2);
    				else System.out.println("Não há médicos fora da emergência no momento!");
    				break;
    			case 0:
    				correct_option = true;
    				break;
    		}
    	}
    }
    public void receptionAddPatients(int op)
    {
        Scanner input = new Scanner(System.in);
        boolean correct_option = false;
        DoctorScreen screen = new DoctorScreen();
        String name, ssn = null, gender;
        Exceptions filter = new Exceptions();
        int age = 0, option = -1;
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
               
        if (op == 1)
        {
        	while (!correct_option)
            {
                System.out.print("Digite o CPF (apenas números) >> ");
                ssn = input.nextLine();
                correct_option = filter.verify_ssn(ssn);
                if (correct_option && nursery.existSsn(ssn))
                {
                	System.out.println("Este CPF já está na triagem!");
                	correct_option = false;
                }
                
            }
        	System.out.println("\nO paciente será encaminhado para triagem!");
        	nursery.addTriageList(new Patient(name, ssn, gender, age, 0, null));
        }
        else if (op == 2)
        {	
        	correct_option = false;
        	while (!correct_option)
        	{
        		screen.showDoctors(doctors);
        		option = filter.verify_menu(doctors.size());
        		if (option > 0)
        		{
        			System.out.println("\nO paciente foi adicionado na lista de espera do médico " + doctors.get(option-1).getDoctor().getName() + "\n");
        			doctors.get(option-1).addPatient(new Patient(name, ssn, gender, age, 0, null));
        			correct_option = true;
        		}
        		else if (option == 0)
        		{
        			System.out.println("Operação cancelada!");
        			correct_option = true;
        		}
        	}
        }
    }
    public void receptionCheckLists()
    {
   
    	Screen screen = new Screen();
    	DoctorScreen docScreen = new DoctorScreen();
    	boolean correct_option = false, correct_option2 = false;
    	int option = -1;
    	Exceptions filter = new Exceptions();
    	while (!correct_option)
    	{
    		screen.drawReceptionConsultationMenu();
    		option = filter.verify_menu(2);
    		if (option == 1) reception.checkList();
    		else if (option == 2)
    		{
    			if (doctors.size() > 0)
    			{
    				docScreen.showDoctors(doctors);
    				while (!correct_option2)
    				{
    					option = filter.verify_menu(doctors.size());
    					if (option > 0)
    					{
    						doctors.get(option-1).showList();
    						correct_option2 = true;
    					}
    					else if (option == 0)
    					{
    						correct_option2 = true;
    					}	
    				}
    			}
    			else System.out.println("Não há médicos fora da emergência no momento!");
    		}
    		else if (option == 0) correct_option = true;
    		correct_option2 = false;
    	}
    }
    public void receptionCallPatient()
    {
    	boolean correct_option = false, correct_option2 = false;
    	int option = -1, option2 = -1;
    	Exceptions filter = new Exceptions();
    	Screen screen = new Screen();
    	DoctorScreen docScreen = new DoctorScreen();
    	while (!correct_option)
    	{
    		screen.drawReceptionConsultationMenu();
    		option = filter.verify_menu(2);
    		if (option == 1)
    		{
    			if (reception.emergencyList.SizeOfQueue() > 0) reception.callPatient();
    			else System.out.println("Não existe nenhum paciente na lista de espera!");
    		}
    		else if (option == 2)
    		{
    			if (doctors.size() > 0)
    			{
    				while (!correct_option2)
    				{
    					docScreen.showDoctors(doctors);
    					option2 = filter.verify_menu(doctors.size());
    					if (option > 0)
    					{
    						if (doctors.get(option2-1).getListSize() > 0)
    						{
    							if (!doctors.get(option2-1).getStatus())
    							{
    								doctors.get(option2-1).setPatient();
    								System.out.println("Paciente " + doctors.get(option2-1).getPatient().getName() + " Comparecer a sala do médico " + doctors.get(option2-1).getDoctor().getName());
    							}
    							else System.out.println("O médico já está com um paciente em sala!");
    							correct_option2 = true;
    						}
    						else 
    						{
    							System.out.println("Não existe nenhum paciente na lista de espera!");
    							correct_option2 = true;
    						}
    					}
    					else if (option == 0) correct_option2 = true;
    				}
    				correct_option2 = false;
    			}
    			else System.out.println("Não há médicos fora da emergência no momento!");
    		}
    		else if (option == 0) correct_option = true;
    	}
    }
    
    public void nurseryMenu()
    {
    	 Screen screen = new Screen();
         Exceptions filter = new Exceptions();
         boolean correct_option = false;
         int option = -1;
         while (!correct_option)
         {
        	 correct_option = nursery.Login();
         }
         correct_option = false;
         while (!correct_option)
         {
        	 screen.drawNurseryMenu();
        	 option = filter.verify_menu(1);
        	 switch(option)
        	 {
        	 	case 1:
        	 		nurseryTriage();
        	 		break;
        	 	case 0:
        	 		correct_option = true;
        	 		break;
        	 }
         }
    }
    public void nurseryTriage()
    {
    	boolean correct_option = false;
    	String status = null, choice = null;
    	Scanner input = new Scanner(System.in);
    	Exceptions filter = new Exceptions();
    	int priority = -1;
    	while (!correct_option && nursery.existPatient())
    	{
    		Patient p = nursery.getPatient();
    		System.out.println(p.toString());
    		System.out.print("Digite como o paciente se sente >> ");
    		status = input.nextLine();
    		p.setStatus(status);
    		while (priority < 0)
    		{
    			System.out.println("Digite a prioridade do paciente (0 / 10)");
    			priority = filter.verify_menu(10);
    		}
    		p.setPriority(priority);
    		priority = -1;
    		System.out.println("O paciente será adicionado a lista de espera da emergência!");
    		nursery.triageEvaluation(p, reception);
    		if (nursery.existPatient())
    		{
    			System.out.print("Deseja atender outro paciente? S(sim)/N(não) >> ");
    			choice = input.nextLine();
    			if (choice.charAt(0) != 'S' && choice.charAt(0) != 's') correct_option = true;
    		}
    	}
    	if (!nursery.existPatient()) System.out.println("\nNão há pacientes para a triagem no momento!");
    }
    
    public void doctorsMenu()
    {
    	boolean correct_option = false;
    	String ssn = null, crm = null;
    	Scanner input = new Scanner(System.in);
    	Exceptions filter = new Exceptions();
    	DoctorScreen screen = new DoctorScreen();
    	Doctor doctor = null;
    	int option = -1;
    	
    	while (!correct_option)
    	{
    		System.out.print("Digite o CPF >> ");
    		ssn = input.nextLine();
    		System.out.print("Digite o CRM >> ");
    		crm = input.nextLine();
    		
    		for (Doctor d : doctors)
    		{
    			if (d.Login(ssn, crm))
    			{
    				doctor = d;
    				correct_option = true;
    				break;
    			}
    		}
    		if (!correct_option) System.out.println("CPF ou CRM inválidos!");
    	}
    	correct_option = false;
    	while (!correct_option)
    	{
    		screen.drawDoctorMenu(doctor.getDoctor().getName());
    		option = filter.verify_menu(3);
    		switch(option)
    		{
    			case 1:
    				doctorConsultation();
    				break;
    			case 2:
    				doctor.showPatients();
    			case 3:
    				break;
    			case 0:
    				correct_option = true;
    				break;
    		}
    	}
    }
    public void doctorConsultation()
    {
    	
    }
}
