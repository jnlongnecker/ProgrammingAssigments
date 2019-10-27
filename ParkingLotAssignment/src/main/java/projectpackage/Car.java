/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpackage;
import java.util.Random;
/**
 *
 * @author Jared - PC
 */
public class Car 
{
    private static final String[] LOCATIONS = {"VIP", "Garage", "Covered", "Close", "Standard"};
    private String locationPref;
    private Ticket payTicket;
    public Car()
    {
        Random randomSelector = new Random(1);
        int selection = randomSelector.nextInt() % 5;
        locationPref = "";
        switch(selection)
        {
            case 0:
                locationPref += LOCATIONS[0];
            case 1:
                locationPref += LOCATIONS[1];
            case 2:
                locationPref += LOCATIONS[2];
            case 3:
                locationPref += LOCATIONS[3];
                break;
            case 4:
                locationPref += LOCATIONS[4];
                break;
            default:
                break;
        }
    }
    public String tellPreference()
    {
        return locationPref;
    }
    public Ticket giveTicket()
    {
        return payTicket;
    }
    public void receiveTicket(Ticket t)
    {
        payTicket = t;
    }
    
    public void requestPrices(Group group)
    {
        Prices p = group.getPrices();
        System.out.println(p.toString());
    }
}
