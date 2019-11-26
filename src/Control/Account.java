package Control;
import java.util.Scanner;
public class Account {
	private String user;
	private String password;
	
	public Account()
	{
		this.user = null;
		this.password = null;
	}
	public Account(String user, String password) {
		this.user = user;
		this.password = password;
	}
	
	public boolean confirmLogin(String user, String password)
	{
		if (getPassword().equals(password) && getUser().equals(user)) return true;
		return false;		
	}
	public String getUser()
	{
		return this.user;
	}
	public String getPassword()
	{
		return this.password;
	}
	public void setUser(String user)
	{
		this.user = user;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public boolean Login()
	{
		 Scanner input = new Scanner(System.in);
		 String user;
		 String pass;
		 System.out.println("Digite o login:");
         System.out.print("Usuário >> ");
         user = input.nextLine();
         System.out.print("Senha >> ");
         pass = input.nextLine();
         
         if (this.confirmLogin(user, pass)) return true;
         System.out.println("Senha ou usuário inválidos!");
         return false;

	}
	public boolean Login(String user, String password)
	{
		if (this.confirmLogin(user, password)) return true;
		return false;
	}
}
