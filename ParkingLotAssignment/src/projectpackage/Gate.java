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
    protected static int coveredCapacity = 0;
    protected static int garageCapacity = 0;
    protected static int VIPCapacity = 0;
    protected static int closeCapacity = 0;
    protected static int standardCapacity = 0;
    
    protected static int currCapacity = 0;
    protected static int currCovered = 0;
    protected static int currGarage = 0;
    protected static int currVIP = 0;
    protected static int currClose = 0;
    protected static int currStandard = 0;
    protected Gate()
    {
        ID++;
    }
    public static boolean addCapacity(int i, int key)
    {
        if(i < 1)
            return false;
        switch(key)
        {
            case 0:
                VIPCapacity += i;
                break;
            case 1:
                garageCapacity += i;
                break;
            case 2:
                coveredCapacity += i;
                break;
            case 3:
                closeCapacity += i;
                break;
            case 4:
                standardCapacity += i;
                break;
            default:
                break;
        }
        lotCapacity += i;
        return true;
    }
    public static boolean removeCapacity(int i, int key)
    {
        if(i < 1)
            return false;
        switch(key)
        {
            case 0:
                VIPCapacity -= i;
                if(VIPCapacity < 0)
                    VIPCapacity = 0;
                break;
            case 1:
                garageCapacity -= i;
                if(garageCapacity < 0)
                    garageCapacity = 0;
                break;
            case 2:
                coveredCapacity -= i;
                if(coveredCapacity < 0)
                    coveredCapacity = 0;
                break;
            case 3:
                closeCapacity -= i;
                if(closeCapacity < 0)
                    closeCapacity = 0;
                break;
            case 4:
                standardCapacity -= i;
                if(standardCapacity < 0)
                    standardCapacity = 0;
                break;
            default:
                break;
        }
        lotCapacity = standardCapacity + VIPCapacity + garageCapacity + coveredCapacity + closeCapacity;
        return true;
    }
    
    public abstract boolean carAtGate(Car c);
}
