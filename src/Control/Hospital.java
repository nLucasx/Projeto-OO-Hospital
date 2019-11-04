
package Control;
import Model.Person;
import java.util.*;
import View.Screen;

public class Hospital {
    public String name;
    public Hospital() 
    {
        this.name = "Mais Saúde";
    }
    
    public static void main(String[] args) 
    {
        Hospital hospital = new Hospital();
        hospital.main_menu();
    }
    public void main_menu()
    {
        Screen screen = new Screen();
        screen.draw_main_menu();
        Exceptions filter = new Exceptions();
        
        boolean correct_option = false;
        int option = -1;
        while (!correct_option)
        {
            option = filter.verify_menu(3);
            if (option == -2 || option == -1) screen.draw_main_menu();
            switch (option)
            {
                case -2:
                    System.out.println("Digite apenas números!");
                    break;
                case -1:
                    System.out.println("Opção inválida");
                    break;
                default:
                    correct_option = true;
                    break;
            }
        }
        switch (option)
        {
            case 1 :
                System.out.println("Opção indisponível");
                break;
            case 2 :
                System.out.println("Opção indisponível");
                break;
            case 3 :
                administrator_menu();
                break;
            case 0 :
                System.out.println("Saindo ...");
                break;
        }
    }
    public void administrator_menu()
    {
        Admin admin = new Admin("admin", "admin");
        Screen screen = new Screen();
        Exceptions filter = new Exceptions();
        boolean correct_option = false;
        String user, pass;
        Scanner input = new Scanner(System.in);
        int option = 0;
        while (!correct_option)
        {
            System.out.println("Digite o login:");
            System.out.print("Usuário >> ");
            user = input.nextLine();
            System.out.print("Senha >> ");
            pass = input.nextLine();
            
            if (user.equals(admin.getUser()) && pass.equals(admin.getPassword()))
            {    
                correct_option = true;
            }
            else System.out.println("Senha ou usuário inválidos!");
        }
        
        correct_option = false;
        while (!correct_option)
        {
            screen.draw_admin_menu();
            option = filter.verify_menu(5);
            if (option == -2 || option == -1) screen.draw_admin_menu();
            switch (option)
            {
                case -2:
                    System.out.println("Digite apenas números!");
                    break;
                case -1:
                    System.out.println("Opção inválida");
                    break;
                case 1 :
                    admin_manage_employees(1, admin);
                    break;
                case 2 :
                    System.out.println("Opção indisponível");
                    break;
                case 3 :
                    System.out.println("Opção indisponível");
                    break;
                case 4 :
                    System.out.println("Opção indisponível");
                    break;
                case 5 :
                    admin_manage_employees(2, admin);
                    break;
                case 0 :
                    System.out.println("Saindo ...");
                    correct_option = true;
                    break;
            }
        }
        
    }
    public void admin_manage_employees(int op, Admin admin)
    {
        if (op == 1)
        {
            boolean end = false;
            while (!end)
            {
                System.out.println("\nCadastro de funcionários");
                Screen screen = new Screen();
                Exceptions filter = new Exceptions();
                boolean correct_option = false;
                int option = 0;
                screen.draw_employee_option();
                while (!correct_option)
                {
                    option = filter.verify_menu(4);
                    if (option == -2 || option == -1) screen.draw_employee_option();
                    switch (option)
                    {
                        case -2:
                            System.out.println("Digite apenas números!");
                            break;
                        case -1:
                            System.out.println("Opção inválida");
                            break;
                        default:
                            correct_option = true;
                            break;
                    }
                }
                correct_option = false;
                if (option > 0)
                {
                    String name, ssn = null, gender;
                    int age = 0;
                    Scanner input = new Scanner(System.in);
                    System.out.println("Entre com as informações do funcionário.");
                    System.out.print("Digite o nome >> ");
                    name = input.nextLine();
                    System.out.print("Digite o sexo >> ");
                    gender = input.nextLine();

                    while (!correct_option)
                    {  
                        System.out.print("Digite a idade >> ");
                        age = filter.verify_integer();
                        if (age != -1) correct_option = true;
                    }
                    correct_option = false;
                    
                    while (!correct_option)
                    {
                        System.out.print("Digite o CPF (apenas números) >> ");
                        ssn = input.nextLine();
                        correct_option = filter.verify_ssn(ssn);
                    }

                    if (!admin.exist_ssn(ssn))
                    {
                        if (option == 1)
                        {
                            String crm, specialization;
                            System.out.print("Digite o CRM do médico >> ");
                            crm = input.nextLine();
                            System.out.print("Digite a especialização >> ");
                            specialization = input.nextLine();
                            admin.AddEmployee(age, name, gender, ssn, crm, specialization);
                            System.out.println("Usuário cadastrado com sucesso!");
                        }
                        else if (option == 2)
                        {
                            String specialization;
                            System.out.print("Digite a especialização >> ");
                            specialization = input.nextLine();
                            admin.AddEmployee(age, name, gender, ssn, specialization);
                            System.out.println("Usuário cadastrado com sucesso!");
                        }
                        else if (option == 3)
                        {
                            admin.AddEmployee(age, name, gender, ssn);
                            System.out.println("Usuário cadastrado com sucesso!");
                        }
                        else 
                        {
                            admin.AddEmployee(age, name, gender, ssn, 1);
                            System.out.println("Usuário cadastrado com sucesso!");
                        }
                    }
                    else System.out.println("Erro! Esse cpf já está cadastrado!");
                }
                else end = true;
            }
        }
        else if (op == 2)
        {
            if (!admin.isEmpty())
            {
                System.out.println("\nFuncionários cadastrados: ");
                admin.show_employees();
                Scanner input = new Scanner(System.in);
                boolean correct_option = false;
                String ssn, choice;
                Exceptions filter = new Exceptions();
                int index = -1;

                while (!correct_option)
                {
                    System.out.print("Digite o CPF (apenas números) >> ");
                    ssn = input.nextLine();
                    correct_option = filter.verify_ssn(ssn);
                    if (correct_option)
                    {
                        index = admin.return_index_of_person(ssn);
                        if (index == -1)
                        {
                            System.out.println("Funcionário não encontrado!");
                            correct_option = false;
                        }
                    }
                }
                System.out.print("Você tem certeza que deseja excluir o funcionário? S(sim)/N(não) >> ");
                choice = input.nextLine();
                if (choice.equals("S") || choice.equals("s"))
                {
                    admin.delete_employee(index);
                    System.out.println("O funcionário foi excluído!");
                }
                else System.out.println("Saindo...");
            }
            else System.out.println("Não existe nenhum usuário cadastrado no momento!");
        }
    }
}
