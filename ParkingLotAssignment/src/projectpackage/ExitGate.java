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
    public void carAtGate(Car c)
    {
        Ticket payStub = c.giveTicket();
        moneyCollected += payStub.getCostOfTicket();
        currCapacity--;
    }
    public double sendMoney()
    {
        double ret = moneyCollected;
        moneyCollected = 0;
        return ret;
    }
}
