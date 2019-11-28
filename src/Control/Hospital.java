
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
        	screen.drawMainMenu(name);
        	option = filter.verifyMenu(4);
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
        AdminScreen screen = new AdminScreen();
        Exceptions filter = new Exceptions();
        AdminManager adminManager = new AdminManager(admin, doctors);
        boolean correct_option = false, logged = false;
        int option = 0;
        logged = admin.Login();
        if (logged)
        {
        	while (!correct_option)
        	{
        		screen.drawAdminMenu();
        		option = filter.verifyMenu(8);
        		switch (option)
        		{
        			case 1 :
        				adminManager.adminManageEmployees(1);
        				break;
        			case 2 :
        				adminManager.adminManageEmployees(2);
        				break;
        			case 3 :
        				adminManager.adminPayEmployees();
        				break;
        			case 4 :
        				adminManager.adminSearchEmployee();
        				break;
        			case 5 :
        				adminManager.adminAddProducts();
        				break;
        			case 6:
        				adminManager.adminRemoveProducts();
        				break;
        			case 7:
        				admin.showProducts();
        				break;
        			case 8:
        				adminManager.adminAddBalance();
        				break;
        			case 0 :
        				System.out.println("Saindo ...");
        				correct_option = true;
        				break;
        		}
        	}
        }
        
    }
    public void receptionMenu()
    {
        ReceptionScreen screen = new ReceptionScreen();
        boolean correct_option = false, logged = false;
        Exceptions filter = new Exceptions();
        ReceptionManager receptionManager = new ReceptionManager(reception, doctors, nursery);
        int option;
        logged = reception.Login();
        if (logged)
        {
        	while (!correct_option)
        	{
        		screen.drawReceptionMenu();
        		option = filter.verifyMenu(3);
        		switch (option)
        		{
        			case 1 :
        				receptionManager.receptionPatientMenu();
        				break;
        			case 2 :
        				receptionManager.receptionCheckLists();
        				break;
        			case 3 :
        				receptionManager.receptionCallPatient();
        				break;
        			case 0:
        				correct_option = true;
        				break;
        		}
        	}
        }
    }
    public void nurseryMenu()
    {
    	 NurseryScreen screen = new NurseryScreen();
         Exceptions filter = new Exceptions();
         NurseryManager nurseryManager = new NurseryManager(nursery, reception);
         boolean correct_option = false, logged = false;
         int option = -1;
         logged = nursery.Login();
         if (logged)
         {
        	 while (!correct_option)
        	 {
        		 screen.drawNurseryMenu();
        		 option = filter.verifyMenu(1);
        		 switch(option)
        		 {	
        	 		case 1:
        	 			nurseryManager.nurseryTriage();
        	 			break;
        	 		case 0:
        	 			correct_option = true;
        	 			break;
        		 }
        	 }
         }
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
    	if (doctors.size() > 0)
    	{
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
    			if (!correct_option) 
    			{
    				System.out.println("CPF ou CRM inválidos!");
    				correct_option = true;
    			}
    		}
    		if (doctor != null)
    		{
    			correct_option = false;
    			System.out.println("\nBem vindo Dr(a)." + doctor.getDoctor().getName());
    			while (!correct_option)
    			{
    				screen.drawDoctorMenu();
    				option = filter.verifyMenu(3);
    				switch(option)
    				{
    					case 1:
    						doctor.consultation();;
    						break;
    					case 2:
    						doctor.showPatients();
    						break;
    					case 3:
    						doctor.searchReport();
    						break;
    					case 0:
    						correct_option = true;
    						break;
    				}
    			}
    		}
    	}
    	else System.out.println("Não existem médicos cadastrados no momento!");
    }
}
