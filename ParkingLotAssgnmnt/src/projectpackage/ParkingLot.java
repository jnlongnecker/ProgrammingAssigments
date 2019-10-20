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
    private final ArrayList<Gate> gates;
    private final ArrayList<Car> carsInLot;
    private static final int VIP_CAPACITY = 100;
    private static final int GARAGE_CAPACITY = 400;
    private static final int COVERED_CAPACITY = 800;
    private static final int CLOSE_CAPACITY = 200;
    private static final int STANDARD_CAPACITY = 5000;
    private static final int CAPACITY = VIP_CAPACITY + GARAGE_CAPACITY + COVERED_CAPACITY + CLOSE_CAPACITY + STANDARD_CAPACITY;
    private double moneyMade;
    public ParkingLot()
    {
        gates = new ArrayList<>();
        carsInLot = new ArrayList<>();
        Gate.addCapacity(VIP_CAPACITY, 0);
        Gate.addCapacity(GARAGE_CAPACITY, 1);
        Gate.addCapacity(COVERED_CAPACITY, 2);
        Gate.addCapacity(CLOSE_CAPACITY, 3);
        Gate.addCapacity(STANDARD_CAPACITY, 4);
        gates.add(new EntryGate());
        gates.add(new ExitGate());
        moneyMade = 0;
    }
    
    public boolean carArrived()
    {
        Car c = new Car();
        if(gates.get(0).carAtGate(c))
        {
            carsInLot.add(c);
            return true;
        }
        return false;
    }
    
    public boolean carLeft()
    {
        if(carsInLot.isEmpty())
            return false;
        Car c = carsInLot.remove(0);
        gates.get(1).carAtGate(c);
        return true;
    }
    
    public void close()
    {
        while(!carsInLot.isEmpty())
        {
            carLeft();
        }
        ExitGate temp = (ExitGate)gates.get(1);
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
        String s = String.format("%.2f", moneyMade);
        System.out.println("Parking lot has made $" + s + ".");
    }
}
