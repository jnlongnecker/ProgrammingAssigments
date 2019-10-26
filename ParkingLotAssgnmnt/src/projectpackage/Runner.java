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
    public static int HOURS_IN_LOT = 0;
    
    //****Change the value of this variable to decide how many days to simulate****//
    private static int SIMULATION_DAYS = 1;

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
        
        //Read in test file inputs
        int seed = 0;
        if(inFS.hasNextInt())
            HOURS_IN_LOT = inFS.nextInt();
        else
        {
            System.out.println("Test File in Invalid Format");
            System.out.println("Required Format: HOURS_IN_LOT SIMULATION_DAYS SEED\n");
            continue;
        }
        if(inFS.hasNextInt())
            SIMULATION_DAYS = inFS.nextInt();
        else
        {
            System.out.println("Test File in Invalid Format");
            System.out.println("Required Format: HOURS_IN_LOT SIMULATION_DAYS SEED\n");
            continue;
        }
        if(inFS.hasNextInt())
            seed = inFS.nextInt();
        inFS.close();
        
        //If invalid values are input, adjust to minimum values
        if(HOURS_IN_LOT < 0 || SIMULATION_DAYS < 1 || seed < 0)
        {
            System.out.println("Test File has Invalid Inputs");
            System.out.println("Minimum Values: 0 1 0\n");
            continue;
        }
        Random rm;
        if(seed == 0)
            rm = new Random();
        else
            rm = new Random(seed);
        Group group = new Group();
        group.setNewPrices();
        
        for(int day = 1; day <= SIMULATION_DAYS; day++)
        {
            for(int x = 0; x < 50000; x++)
            {
                switch(rm.nextInt() % 3)
                {
                    case 0:
                        Car c = new Car();
                        if(!group.carArrived(c))
                            System.out.println("Lot has reached capacity.");
                        break;
                    case 1:
                    case 2:
                        group.carLeft();
                        break;
                    default:
                        break;
                }
            }
            group.endOfDay(day);
        }
        System.out.println();
    }
    
    }
}
