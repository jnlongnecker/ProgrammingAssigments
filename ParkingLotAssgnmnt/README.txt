This program works by simulating how long each car stays in the lot and simulating
a number of days. These are easily changed by two variables in the Runner class,
HOURS_IN_LOT and SIMULATION_DAYS. Change these around to change the simulation.

The parking lot is assumed to have only 1 entrance gate and 1 exit gate.

/***********************************CARS**************************************/
A car is randomly assigned a preference on where they want to park. If the
preferred location is full, they will be assigned a new location in depreciating
order. The locations and their order are as follows:

/*********************************LOCATIONS***********************************/
VIP - Garage - Covered - Close - Standard

All VIP locations are in a Garage, all Garage locations are Covered, and
all Covered locations are Close to the entrance. However, there exist Close
locations that are NOT Covered, Covered locations that are NOT in a Garage, and
so on. There also exist Standard locations that are none of the above.

/*******************************TICKET PRICING*******************************/
The pricing of the ticket is determined by the parking location. For each
type of location, an extra charge is added to the ticket: $0.50 for Covered, 
$0.15 for Close, $0.25 for Garage, and $5.00 for VIP. Since VIP is also Garage,
Covered, and Close, it functionally adds $5.90 for VIP locations and so on. 
The base price of the ticket is $1.50, and Standard locations incurr no extra 
charge.