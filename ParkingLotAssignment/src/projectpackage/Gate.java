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
public abstract class Gate 
{
    private static int ID;
    protected static int lotCapacity = 0;
    protected static int currCapacity = 0;
    protected Gate()
    {
        ID++;
    }
    public static boolean addCapacity(int i)
    {
        if(i < 1)
            return false;
        lotCapacity += i;
        return true;
    }
    public static boolean removeCapacity(int i)
    {
        if(i < 1)
            return false;
        lotCapacity -= i;
        return true;
    }
    
    public abstract void carAtGate(Car c);
}
