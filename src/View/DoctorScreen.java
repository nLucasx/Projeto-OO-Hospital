package View;
import Model.Patient;
import java.util.ArrayList;

import Control.Doctor;

public class DoctorScreen {
	public DoctorScreen() {
	}
	public void drawDoctorMenu()
    {
    	System.out.println("\n[1] - Atender próximo paciente");
        System.out.println("[2] - Listar pacientes já atendidos");
        System.out.println("[3] - Buscar relatório médico");
        System.out.println("[0] - Sair");
    }
	public void printPatients(ArrayList<Patient> patients)
	{
		if (patients.isEmpty())
		{
			System.out.println("Nenhum paciente foi atendido!");
		}
		else
		{
			System.out.println("Lista de pacientes");
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
}
