package View;
import Model.Patient;
import java.util.ArrayList;

import Control.Doctor;

public class DoctorScreen {
	public DoctorScreen() {
		// TODO Auto-generated constructor stub
	}
	public void drawDoctorMenu(String name)
    {
    	clear();
    	System.out.println("Bem vindo Dr(a)." + name);
    	System.out.println("\n[1] - Atender próximo paciente");
        System.out.println("[2] - Listar pacientes já atendidos");
        System.out.println("[3] - Buscar relatório médico");
        System.out.println("[0] - Sair");
        clear();
    }
	public void printPatients(ArrayList<Patient> patients)
	{
		if (patients.isEmpty())
		{
			System.out.println("Nenhum paciente foi atendido!");
		}
		else
		{
			for (Patient p : patients)
			{
				System.out.println(p.toString());
			}
		
		}
	}
	public void showDoctors(ArrayList<Doctor> doctors)
	{
		if (doctors.isEmpty())
		{
			System.out.println("Nenhum paciente na lista no momento!");
		}
		else
		{
			for (int i = 0; i < doctors.size(); i++)
			{
				System.out.print("["+(i+1)+"] - " + doctors.get(i).getDoctor().toString());
			}
			System.out.println("[0] - Sair");
		}
	}
	public void clear()
    {
    	for(int clear = 0; clear < 4; clear++)
    	{
    	     System.out.println("\n") ;
    	}
    }
}
