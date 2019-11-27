package View;

public class ReceptionScreen {
	
	public ReceptionScreen() {
		// TODO Auto-generated constructor stub
	}
	public void drawReceptionMenu()
	{
		System.out.println("\nMenu da recepção");
		System.out.println("\n[1] - Agendamento de consulta");
	    System.out.println("[2] - Verificar listas de espera");
	    System.out.println("[3] - Chamar paciente para ser atendido");
	    System.out.println("[0] - Sair"); 
	}
	public void drawReceptionConsultationMenu()
	{
		System.out.println("\n[1] - Emergência");
	    System.out.println("[2] - Médico específico");
	    System.out.println("[0] - Sair");
	}
	
}
