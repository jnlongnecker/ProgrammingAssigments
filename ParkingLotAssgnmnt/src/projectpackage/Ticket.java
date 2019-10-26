/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpackage;
import java.time.Instant;
/**
 *
 * @author Jared - PC
 */
public class Ticket 
{
    private final Instant timestamp;
    private double costPerHour;
    private final String location;
    public Ticket(String loc, Prices p)
    {
        location = loc;
        timestamp = Instant.now();
        costPerHour = p.baseCost;
        if(location.contains("Covered"))
        {
            costPerHour += p.coveredCost;
        }
        if(location.contains("Close"))
        {
            costPerHour += p.closeCost;
        }
        if(location.contains("VIP"))
        {
            costPerHour += p.VIPCost;
        }
        if(location.contains("Garage"))
        {
            costPerHour += p.garageCost;
        }
    }
    public String getLocation()
    {
        return location;
    }
    //Gets the cost of the ticket. Partial hours are still charged for to maximize profit
    public double getCostOfTicket()
    {
        Instant now = Instant.now();
        long timeInSeconds = now.getEpochSecond() + (Runner.HOURS_IN_LOT * 3600) - timestamp.getEpochSecond();
        double timeInHours = timeInSeconds/3600;
        
        return timeInHours * costPerHour;
    }
}
