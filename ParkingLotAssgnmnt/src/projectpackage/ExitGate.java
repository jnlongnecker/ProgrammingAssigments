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
public class ExitGate extends Gate
{
    private double moneyCollected;
    public ExitGate()
    {
        super();
        moneyCollected = 0;
    }
    @Override
    public boolean carAtGate(Car c)
    {
        Ticket payStub = c.giveTicket();
        moneyCollected += payStub.getCostOfTicket();
        String location = payStub.getLocation();
        if(location.contains("VIP"))
        {
            currVIP--;
        }
        else if(location.contains("Garage"))
        {
            currGarage--;
        }
        else if(location.contains("Covered"))
        {
            currCovered--;
        }
        else if(location.contains("Close"))
        {
            currClose--;
        }
        else
            currStandard--;
        currCapacity--;
        return true;
    }
    public double sendMoney()
    {
        double ret = moneyCollected;
        moneyCollected = 0;
        return ret;
    }
}
