/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpackage;

/**
 *
 * @author Jared - PC
 */
public class Prices 
{
    double baseCost = 1.5;
    double coveredCost = .5;
    double closeCost = .15;
    double garageCost = .25;
    double VIPCost = 5;
    
    double discount = 1;
    
    @Override
    public String toString()
    {
        
        return "Base Cost: $" + String.format("%.2f",baseCost * discount) +
                "\nClose Cost: $" + String.format("%.2f",(baseCost + closeCost)* discount) +
                "\nCovered Cost: $" + String.format("%.2f",(baseCost + closeCost + coveredCost)* discount) +
                "\nGarage Cost: $" + String.format("%.2f",(baseCost + closeCost + coveredCost + garageCost)* discount) +
                "\nVIP Cost: $" + String.format("%.2f",(baseCost + closeCost + coveredCost + garageCost + VIPCost)* discount) + 
                "\nDiscount of %" + (int)((1 - discount) * 100);
    }
}
