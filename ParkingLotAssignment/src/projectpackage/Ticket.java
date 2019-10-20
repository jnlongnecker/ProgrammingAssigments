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
    public Ticket(String location)
    {
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
    public double getCostOfTicket()
    {
        Instant test = Instant.now();
        test.plusSeconds(3600);
        long timeInSeconds = test.getEpochSecond() + 3600 - timestamp.getEpochSecond();
        
        double timeInHours = timeInSeconds/3600;
        
        return timeInHours * costPerHour;
    }
}
