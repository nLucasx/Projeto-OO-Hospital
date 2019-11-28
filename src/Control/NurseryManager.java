package Control;

import java.util.Scanner;

import Model.Patient;

public class NurseryManager {
	private Nursery nursery;
	private Reception reception;
	public NurseryManager(Nursery nursery, Reception reception) {
		this.nursery = nursery;
		this.reception = reception;
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
    			priority = filter.verifyMenu(10);
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
    
}
