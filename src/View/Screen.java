
package View;
public class Screen {

    public Screen() {
    }
    public void drawMainMenu(String name)
    {
    	System.out.println("\nClínica " + name);
    	System.out.println("\n[1] - Médicos");
        System.out.println("[2] - Recepção");
        System.out.println("[3] - Administrador");
        System.out.println("[4] - Enfermaria");
        System.out.println("[0] - Sair");
    }
}
