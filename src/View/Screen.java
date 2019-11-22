
package View;
public class Screen {

    public Screen() {
    }
    public void draw_main_menu()
    {
        System.out.println("\n[1] - Médicos");
        System.out.println("[2] - Recepção");
        System.out.println("[3] - Administrador");
        System.out.println("[0] - Sair");
    }
    public void draw_admin_menu()
    {
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
    public void draw_employee_option()
    {
        System.out.println("\n[1] - Médico");
        System.out.println("[2] - Enfermeiro");
        System.out.println("[3] - Recepcionista");
        System.out.println("[4] - Serviço geral");
        System.out.println("[0] - Sair"); 
    }
    public void drawReceptionMenu()
    {
        System.out.println("\n[1] - Emergência");
        System.out.println("[2] - Consulta com médico específico");
        System.out.println("[3] - Chamar paciente para ser atendido");
        System.out.println("[4] - Verificar fila de espera");
        System.out.println("[0] - Sair"); 
    }
    public void drawProductsMenu()
    {
    	System.out.println("\n[1] - Materiais hospitalares");
        System.out.println("[2] - Materiais de limpeza");
        System.out.println("[0] - Sair");
    }
}
