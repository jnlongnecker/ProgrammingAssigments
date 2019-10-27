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
public class EntryGate extends Gate
{
    private Prices prices;
    public EntryGate(Prices p)
    {
        prices = p;
    }
    @Override
    public boolean carAtGate(Car c, Capacities cap)
    {
        //If the entire lot is at capacity, we cannot accept any new cars
        if(cap.currCapacity == Capacities.CAPACITY)
            return false;
        //We start by trying to give the car its preferred location
        String actualLocation = c.tellPreference();
        if(actualLocation.indexOf("VIP") == 0)
        {
            //If the car wants VIP, but there are no VIP vacancies, go to next tier
            if(cap.currVIP == Capacities.VIP_CAPACITY)
            {
                actualLocation = actualLocation.replace("VIP", "");
            }
            else
                cap.currVIP++;
        }
        if(actualLocation.indexOf("Garage") == 0)
        {
            //If the car wants Garage, but there are no Garage vacancies, go to next tier
            if(cap.currGarage == Capacities.GARAGE_CAPACITY)
            {
                actualLocation = actualLocation.replace("Garage", "");
            }
            else
                cap.currGarage++;
        }
        if(actualLocation.indexOf("Covered") == 0)
        {
            //If the car wants Covered, but there are no Covered vacancies, go to next tier
            if(cap.currCovered == Capacities.COVERED_CAPACITY)
            {
                actualLocation = actualLocation.replace("Covered", "");
            }
            else
                cap.currCovered++;
        }
        if(actualLocation.indexOf("Close") == 0)
        {
            //If the car wants Close, but there are no Close vacancies, go to Standard.
            if(cap.currClose == Capacities.CLOSE_CAPACITY)
            {
                actualLocation = "Standard";
            }
            else
                cap.currClose++;
        }
        if(actualLocation.indexOf("Standard") == 0)
        {
            //If the car wants Standard, but there are no Standard vacancies, 
            //increase the tier until a vacancy is found
            if(cap.currStandard == Capacities.STANDARD_CAPACITY)
            {
                if(cap.currClose != Capacities.CLOSE_CAPACITY)
                {
                    actualLocation = "Close";
                    cap.currClose++;
                }
                else if(cap.currCovered != Capacities.COVERED_CAPACITY)
                {
                    actualLocation = "CoveredClose";
                    cap.currCovered++;
                } 
                else if(cap.currGarage != Capacities.GARAGE_CAPACITY)
                {
                    actualLocation = "GarageCoveredClose";
                    cap.currGarage++;
                }
                else if(cap.currVIP != Capacities.VIP_CAPACITY)
                {
                    actualLocation = "VIPGarageCoveredClose";
                    cap.currVIP++;
                }  
            }
        }
        //Now create the ticket with the actual location the car will be sent to
        Ticket ticket = new Ticket(actualLocation, prices);
        c.receiveTicket(ticket);
        cap.currCapacity++;
        return true;
    }
}
