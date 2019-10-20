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
public class Runner 
{
    public static void main(String[] args)
    {
        ParkingLot lot = new ParkingLot();
        lot.carArrived();
        lot.carArrived();
        lot.carArrived();
        System.out.println(lot.currentOutstandingIncome());
        lot.carLeft();
        System.out.println(lot.currentOutstandingIncome());
        lot.close();
        lot.totalIncome();
    }
}
