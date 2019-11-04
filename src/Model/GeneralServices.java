/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author bacon
 */
public class GeneralServices extends Person{
    private int teste;
    public GeneralServices(String name, String ssn, String gender, int age, int teste) {
        super(name, ssn, gender, age);
        this.teste = teste;
    }
    
    public String getOccupation_area()
    {
        return "Serviço geral";
    }
}
