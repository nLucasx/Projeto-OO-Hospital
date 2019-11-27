
package Control;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Person;
public class Exceptions {
    public int verify_menu(int range)
    {
        int option;
        Scanner input = new Scanner(System.in);
        try
        {
            System.out.print("Digite uma opção >> ");
            option = Integer.parseInt(input.next());
        }
        catch (NumberFormatException e)
        {
        	System.out.println("Digite apenas números!");
        	return -2; // -2 para exception.
        }
        if (option >= 0 && option <= range) return option;
        System.out.println("Opção inválida");
        return -1; // -1 para opção inválida.
    }
    public boolean verify_ssn(String ssn)
    {
        if (ssn.length() < 11 || ssn.length() > 11)
        {
            System.out.println("O seu cpf não possui 11 dígitos!");
            return false;
        }
        for (int i = 0; i < ssn.length(); i++)
        {
            if (ssn.charAt(i) < 48 || ssn.charAt(i) > 57) 
            {
                System.out.println("Digite apenas números!");
                return false;
            }
        }
        return true;
    }
    public boolean exist_ssn(String ssn, ArrayList<Person> List)
    {
        for (Person person : List)
        {
            if (person.getSsn().equals(ssn)) return true;
        }
        return false;
    }
    public int verify_integer()
    {
        int option = -1;
        try
        {
            Scanner input = new Scanner(System.in);
            option = Integer.parseInt(input.next());
        }
        catch(NumberFormatException e)
        {
            System.out.println("Você digitou letras!");
            return -1;
        }
        if (option <= 0)
        {
        	System.out.println("Opção inválida!");
    		return -1;
        }
        return option;
    }
    public boolean verifyString(String str)
    {
    	for (int i = 0; i < str.length(); i++)
    	{
    		if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
    		{
    			System.out.println("Digite apenas letras!");
    			return false;
    		}
    	}
    	return true;
    }
    public double verifyDouble()
    {
    	double option = -1, max = 999999999.9;
    	try
    	{
    		Scanner input = new Scanner(System.in);
    		option = Double.parseDouble(input.next());
    	}
    	catch(NumberFormatException e)
    	{
    		System.out.println("Você digitou letras!");
    	}
    	if (option < 0 || option > max)
    	{
    		System.out.println("Opção inválida!");
    		return -1;
    	}
    	return option;
    }
    public boolean verifyBiggest(int x, int y)
    {
    	return x > y;
    }
}
