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
        moneyCollected = 0;
    }
    @Override
    public boolean carAtGate(Car c, Capacities cap)
    {
        Ticket payStub = c.giveTicket();
        moneyCollected += payStub.getCostOfTicket();
        String location = payStub.getLocation();
        if(location.contains("VIP"))
        {
            cap.currVIP--;
        }
        else if(location.contains("Garage"))
        {
            cap.currGarage--;
        }
        else if(location.contains("Covered"))
        {
            cap.currCovered--;
        }
        else if(location.contains("Close"))
        {
            cap.currClose--;
        }
        else
            cap.currStandard--;
        cap.currCapacity--;
        return true;
    }
    public double sendMoney()
    {
        double ret = moneyCollected;
        moneyCollected = 0;
        return ret;
    }
}
