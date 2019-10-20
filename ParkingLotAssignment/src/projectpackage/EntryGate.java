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
    public EntryGate()
    {
        super();
    }
    @Override
    public boolean carAtGate(Car c)
    {
        //If the entire lot is at capacity, we cannot accept any new cars
        if(currCapacity == lotCapacity)
            return false;
        //We start by trying to give the car its preferred location
        String actualLocation = c.tellPreference();
        if(actualLocation.indexOf("VIP") == 0)
        {
            //If the car wants VIP, but there are no VIP vacancies, go to next tier
            if(currVIP == VIPCapacity)
            {
                actualLocation = actualLocation.replace("VIP", "");
            }
            else
                currVIP++;
        }
        if(actualLocation.indexOf("Garage") == 0)
        {
            //If the car wants Garage, but there are no Garage vacancies, go to next tier
            if(currGarage == garageCapacity)
            {
                actualLocation = actualLocation.replace("Garage", "");
            }
            else
                currGarage++;
        }
        if(actualLocation.indexOf("Covered") == 0)
        {
            //If the car wants Covered, but there are no Covered vacancies, go to next tier
            if(currCovered == coveredCapacity)
            {
                actualLocation = actualLocation.replace("Covered", "");
            }
            else
                currCovered++;
        }
        if(actualLocation.indexOf("Close") == 0)
        {
            //If the car wants Close, but there are no Close vacancies, go to Standard.
            if(currClose == closeCapacity)
            {
                actualLocation = "Standard";
            }
            else
                currClose++;
        }
        if(actualLocation.indexOf("Standard") == 0)
        {
            //If the car wants Standard, but there are no Standard vacancies, 
            //increase the tier until a vacancy is found
            if(currStandard == standardCapacity)
            {
                if(currClose != closeCapacity)
                {
                    actualLocation = "Close";
                    currClose++;
                }
                else if(currCovered != coveredCapacity)
                {
                    actualLocation = "CoveredClose";
                    currCovered++;
                } 
                else if(currGarage != garageCapacity)
                {
                    actualLocation = "GarageCoveredClose";
                    currGarage++;
                }
                else if(currVIP != VIPCapacity)
                {
                    actualLocation = "VIPGarageCoveredClose";
                    currVIP++;
                }  
            }
        }
        //Now create the ticket with the actual location the car will be sent to
        Ticket ticket = new Ticket(actualLocation);
        c.receiveTicket(ticket);
        currCapacity++;
        return true;
    }
}
