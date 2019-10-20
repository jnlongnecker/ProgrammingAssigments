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
    public void carAtGate(Car c)
    {
        Ticket ticket = new Ticket(c.tellPreference());
        c.receiveTicket(ticket);
        currCapacity++;
    }
}
