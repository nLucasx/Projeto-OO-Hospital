package Control;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Patient;
import View.DoctorScreen;
import View.ReceptionScreen;

public class ReceptionManager {
	private Reception reception;
	private ArrayList<Doctor> doctors;
	private Nursery nursery;
	public ReceptionManager(Reception reception, ArrayList<Doctor> doctors, Nursery nursery) {
		this.reception = reception;
		this.doctors = doctors;
		this.nursery = nursery;
	}
    public void receptionPatientMenu()
    {
    	ReceptionScreen screen = new ReceptionScreen();
    	Scanner input = new Scanner(System.in);
    	Exceptions filter = new Exceptions();
    	int option = -1;
    	
    	boolean correct_option = false;
    	while (!correct_option)
    	{
    		screen.drawReceptionConsultationMenu();
    		option = filter.verifyMenu(2);
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
        String name = null, ssn = null, gender = null;
        Exceptions filter = new Exceptions();
        int age = 0, option = -1;
        System.out.println("Entre com as informações do paciente.");
        
        while (!correct_option)
        {
        	System.out.print("Digite o nome >> ");
            name = input.nextLine();
            correct_option = filter.verifyString(name);
        }
        correct_option = false;
        
        while (!correct_option)
        {
        	System.out.print("Digite o sexo >> ");
        	gender = input.nextLine();
        	correct_option = filter.verifyString(gender);
        }
        correct_option = false;
        while (!correct_option)
        {  
            System.out.print("Digite a idade >> ");
            age = filter.verifyInteger();
            if (age != -1) correct_option = true;
        }
        
        correct_option = false;
               
        if (op == 1)
        {
        	while (!correct_option)
            {
                System.out.print("Digite o CPF (apenas números) >> ");
                ssn = input.nextLine();
                correct_option = filter.verifySsn(ssn);
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
        	boolean correct_option2 = false;
        	while (!correct_option)
        	{
        		while (!correct_option2)
                {
                    System.out.print("Digite o CPF (apenas números) >> ");
                    ssn = input.nextLine();
                    correct_option2 = filter.verifySsn(ssn);    
                }
        		correct_option2 = false;
        		
        		screen.showDoctors(doctors);
        		option = filter.verifyMenu(doctors.size());
        			
        		if (!doctors.get(option-1).existSsn(ssn))
        		{
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
        		else System.out.println("Erro! Este CPF já está na lista de espera do médico");
        	}
        }
    }
    public void receptionCheckLists()
    {
    	ReceptionScreen screen = new ReceptionScreen();
    	DoctorScreen docScreen = new DoctorScreen();
    	boolean correct_option = false, correct_option2 = false;
    	int option = -1;
    	Exceptions filter = new Exceptions();
    	while (!correct_option)
    	{
    		screen.drawReceptionConsultationMenu();
    		option = filter.verifyMenu(2);
    		if (option == 1) reception.checkList();
    		else if (option == 2)
    		{
    			if (doctors.size() > 0)
    			{
    				docScreen.showDoctors(doctors);
    				while (!correct_option2)
    				{
    					option = filter.verifyMenu(doctors.size());
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
    	ReceptionScreen screen = new ReceptionScreen();
    	DoctorScreen docScreen = new DoctorScreen();
    	while (!correct_option)
    	{
    		screen.drawReceptionConsultationMenu();
    		option = filter.verifyMenu(2);
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
    					option2 = filter.verifyMenu(doctors.size());
    					if (option > 0)
    					{
    						if (doctors.get(option2-1).getListSize() > 0)
    						{
    							reception.callPatient(doctors.get(option2-1));
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
    
}
