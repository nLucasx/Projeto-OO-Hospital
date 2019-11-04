
package View;
public class Screen {

    public Screen() {
    }
    public void draw_main_menu()
    {
        System.out.println("[1] - Médicos");
        System.out.println("[2] - Recepção");
        System.out.println("[3] - Administrador");
        System.out.println("[0] - Sair");
    }
    public void draw_admin_menu()
    {
        System.out.println("[1] - Cadastrar funcionários");
        System.out.println("[2] - Pagar funcionários");
        System.out.println("[3] - Registrar compra de materiais");
        System.out.println("[4] - Registrar uso de materiais");
        System.out.println("[5] - Excluir funcionário do sistema");
        System.out.println("[0] - Sair");
    }
    public void draw_employee_option()
    {
        System.out.println("[1] - Médico");
        System.out.println("[2] - Enfermeiro");
        System.out.println("[3] - Recepcionista");
        System.out.println("[4] - Serviço geral");
        System.out.println("[0] - Sair"); 
    }
    
}
