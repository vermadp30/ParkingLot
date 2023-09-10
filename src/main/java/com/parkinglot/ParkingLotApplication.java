package com.parkinglot;

import com.parkinglot.repositories.GateRepository;
import com.parkinglot.repositories.ParkingLotRepository;
import com.parkinglot.repositories.TicketRepository;
import com.parkinglot.repositories.VehicleRepository;
import com.parkinglot.services.TicketService;
import com.parkinglot.services.VehicleService;
import com.parkinglot.strategies.spotassignmentstrategy.RandomSpotAssignmentStrategy;
import com.parkinglot.strategies.spotassignmentstrategy.SpotAssignmentStrategy;

public class ParkingLotApplication {

  public static void main(String[] args) {

    GateRepository gateRepository = new GateRepository();
    ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
    TicketRepository ticketRepository = new TicketRepository();
    VehicleRepository vehicleRepository = new VehicleRepository();
    SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy();

    VehicleService vehicleService = new VehicleService(vehicleRepository);

    TicketService ticketService =
        new TicketService(
            gateRepository,
            vehicleRepository,
            ticketRepository,
            parkingLotRepository,
            spotAssignmentStrategy,
            vehicleService);
  }
}
