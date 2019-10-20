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
    public Ticket(String loc)
    {
        location = loc;
        timestamp = Instant.now();
        costPerHour = 1.5;
        if(location.contains("Covered"))
        {
            costPerHour += .5;
        }
        if(location.contains("Close"))
        {
            costPerHour += .15;
        }
        if(location.contains("VIP"))
        {
            costPerHour += 5;
        }
        if(location.contains("Garage"))
        {
            costPerHour += .25;
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
        long timeInSeconds = now.getEpochSecond() + 3600 - timestamp.getEpochSecond();
        double timeInHours = timeInSeconds/3600;
        
        return timeInHours * costPerHour;
    }
}
