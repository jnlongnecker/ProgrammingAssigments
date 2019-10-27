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
public class Capacities
{
        static final int VIP_CAPACITY = 100;
        static final int GARAGE_CAPACITY = 400;
        static final int COVERED_CAPACITY = 800;
        static final int CLOSE_CAPACITY = 200;
        static final int STANDARD_CAPACITY = 5000;
        static final int CAPACITY = VIP_CAPACITY + COVERED_CAPACITY + GARAGE_CAPACITY + CLOSE_CAPACITY + STANDARD_CAPACITY; 
        int currCapacity = 0;
        int currCovered = 0;
        int currGarage = 0;
        int currVIP = 0;
        int currClose = 0;
        int currStandard = 0;
}
