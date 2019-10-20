/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpackage;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Jared - PC
 */

public class Runner 
{
    
    //****Change the value of this variable to simulate how long each car stays in the lot****//
    public static int HOURS_IN_LOT;
    
    //****Change the value of this variable to decide how many days to simulate****//
    private static int SIMULATION_DAYS;

    public static void main(String[] args)
    {
        for(int i = 1; i <= 5; i++)
        {
            
        System.out.println("*****Running test file " + i + "*****");
        String file = "input" + i + ".txt";
        Scanner inFS = null;
        try
        {
           inFS = new Scanner(new File(file));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        HOURS_IN_LOT = inFS.nextInt();
        SIMULATION_DAYS = inFS.nextInt();
        int seed = inFS.nextInt();
        inFS.close();
        //If invalid values are input, adjust to minimum values
        if(HOURS_IN_LOT < 0) HOURS_IN_LOT = 0;
        if(SIMULATION_DAYS < 1) SIMULATION_DAYS = 1;
        if(seed < 0) seed = 0;
        
        Random rm = new Random(seed);
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
        System.out.println();
    }
    
    }
}
