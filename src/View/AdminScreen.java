package View;

public class AdminScreen {
	public AdminScreen() {
		// TODO Auto-generated constructor stub
	}
	public void drawAdminMenu()
    {
		System.out.println("\n Menu do administrador");
		System.out.println("\n[1] - Cadastrar funcionários");
        System.out.println("[2] - Excluir funcionário do sistema");
        System.out.println("[3] - Pagar funcionários");
        System.out.println("[4] - Buscar informações de um funcionário");
        System.out.println("[5] - Registrar compra de materiais");
        System.out.println("[6] - Registrar uso de materiais");
        System.out.println("[7] - Listar materiais disponíveis");
        System.out.println("[8] - Adicionar saldo");
        System.out.println("[0] - Sair");
    }
	public void drawAdminEmployee()
    {
    	System.out.println("\n[1] - Médico");
        System.out.println("[2] - Enfermeiro");
        System.out.println("[3] - Recepcionista");
        System.out.println("[4] - Serviço geral");
        System.out.println("[0] - Sair"); 
    }
	public void drawAdminProductsMenu()
    {
    	System.out.println("\n[1] - Materiais hospitalares");
        System.out.println("[2] - Materiais de limpeza");
        System.out.println("[0] - Sair");

    }
}
