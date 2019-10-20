/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpackage;
import java.util.Random;
/**
 *
 * @author Jared - PC
 */

public class Runner 
{
    //****Change the value of this variable to simulate how long each car stays in the lot****//
    public static final int HOURS_IN_LOT = 1;
    
    //****Change the value of this variable to decide how many days to simulate****//
    private static final int SIMULATION_DAYS = 4;
    public static void main(String[] args)
    {
        Random rm = new Random();
        ParkingLot lot = new ParkingLot();
        
        for(int day = 1; day <= SIMULATION_DAYS; day++)
        {
            for(int x = 0; x < 50000; x++)
            {
                switch(rm.nextInt() % 3)
                {
                    case 0:
                        if(!lot.carArrived())
                            System.out.println("Lot has reached capacity.");
                        break;
                    case 1:
                    case 2:
                        lot.carLeft();
                        break;
                    default:
                        break;
                }
            }
            System.out.println("Current charges to cars in lot at the end of day " + day + 
                    ": $" + String.format("%.2f",lot.currentOutstandingIncome()) + ".");
            lot.close();
        }
        
        //Displays the total amount of money the lot has made
        lot.totalIncome();
    }
}
