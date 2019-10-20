/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpackage;

import java.util.ArrayList;

/**
 *
 * @author Jared - PC
 */
public class ParkingLot 
{
    private Gate gates[];
    private ArrayList<Car> carsInLot;
    private static final int CAPACITY = 40;
    private double moneyMade;
    public ParkingLot()
    {
        Gate.addCapacity(CAPACITY);
        gates[0] = new EntryGate();
        gates[1] = new ExitGate();
        moneyMade = 0;
    }
    
    public void carArrived()
    {
        Car c = new Car();
        carsInLot.add(c);
        gates[0].carAtGate(c);
    }
    
    public void carLeft()
    {
        Car c = carsInLot.remove(0);
        gates[1].carAtGate(c);
    }
    
    public void close()
    {
        while(!carsInLot.isEmpty())
        {
            carLeft();
        }
        ExitGate temp = (ExitGate)gates[0];
        moneyMade = temp.sendMoney();
    }
    
    public double currentOutstandingIncome()
    {
        double ret = 0;
        for(Car c : carsInLot)
        {
            ret += c.giveTicket().getCostOfTicket();
        }
        return ret;
    }
    
    public void totalIncome()
    {
        System.out.println("Parking lot has made $" + moneyMade + ".");
    }
}
