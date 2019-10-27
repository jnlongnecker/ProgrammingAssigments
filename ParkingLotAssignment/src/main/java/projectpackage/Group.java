/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpackage;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Jared - PC
 */
public class Group 
{
    private final ArrayList<ParkingLot> lots;
    private final Prices prices;
    private Random rm;
    
    public Group(int seed)
    {
        lots = new ArrayList();
        prices = new Prices();
        rm = new Random(seed);
        int numLots = rm.nextInt(3);
        for(int x = 0; x <= numLots; x++)
        {
            ParkingLot l = new ParkingLot(prices);
            lots.add(l);
        }
    }
    
    public Prices getPrices()
    {
        return prices;
    }
    
    public void setNewPrices()
    {
        int modifier = rm.nextInt(11);
        prices.baseCost = 1.45 + ((double)modifier/100);
        prices.VIPCost = 4.95 + ((double)modifier/100);
        prices.closeCost = .10 + ((double)modifier/100);
        prices.garageCost = .2 + ((double)modifier/100);
        prices.coveredCost = .45 + ((double)modifier/100);
    }
    
    public void setDiscount()
    {
        int modifier = rm.nextInt(26);
        prices.discount = 1 - ((double)modifier/100);
    }
    
    public boolean carArrived(Car c)
    {
        if(findCar(c))
            return false;
        ParkingLot lot = getLowestCapacityLot();
        return lot.carArrived(c);
    }
    
    public boolean carLeft()
    {
        int index = rm.nextInt(lots.size()) ;
        if(index < 0)
            index *= -1;
        return lots.get(index).carLeft();
    }
    
    public void endOfDay(int day)
    {
        int count = 1;
        for(ParkingLot lot : lots)
        {
            System.out.println("Statistics for Lot " + count + ":");
            System.out.println("Current charges to cars in lot at the end of day " + day + 
                    ": $" + String.format("%.2f",lot.currentOutstandingIncome()) + ".");
            lot.close();
            count++;
        }
    }
    
    private ParkingLot getLowestCapacityLot()
    {
        ParkingLot ret = lots.get(0);
        for(ParkingLot lot : lots)
        {
            if(lot.currentCapacity() < ret.currentCapacity())
                ret = lot;
        }
        return ret;
    }
    
    private boolean findCar(Car c)
    {
        for(ParkingLot lot : lots)
        {
            if(lot.findCar(c))
            {
                return true;
            }
        }
        return false;
    }
}
