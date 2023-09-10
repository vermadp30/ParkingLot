package com.parkinglot.services;

import com.parkinglot.enums.VehicleType;
import com.parkinglot.exception.InvalidGateException;
import com.parkinglot.exception.NoAvailableSpotException;
import com.parkinglot.exception.ParkingLotNotFoundException;
import com.parkinglot.models.*;
import com.parkinglot.repositories.GateRepository;
import com.parkinglot.repositories.ParkingLotRepository;
import com.parkinglot.repositories.TicketRepository;
import com.parkinglot.repositories.VehicleRepository;
import com.parkinglot.strategies.spotassignmentstrategy.SpotAssignmentStrategy;
import java.util.Date;
import java.util.Optional;

public class TicketService {

  private GateRepository gateRepository;
  private VehicleRepository vehicleRepository;
  private TicketRepository ticketRepository;
  private ParkingLotRepository parkingLotRepository;
  private SpotAssignmentStrategy spotAssignmentStrategy;
  private VehicleService vehicleService;

  public TicketService(
      GateRepository gateRepository,
      VehicleRepository vehicleRepository,
      TicketRepository ticketRepository,
      ParkingLotRepository parkingLotRepository,
      SpotAssignmentStrategy spotAssignmentStrategy,
      VehicleService vehicleService) {
    this.gateRepository = gateRepository;
    this.vehicleRepository = vehicleRepository;
    this.ticketRepository = ticketRepository;
    this.parkingLotRepository = parkingLotRepository;
    this.spotAssignmentStrategy = spotAssignmentStrategy;
    this.vehicleService = vehicleService;
  }

  public Ticket generateTicket(Long gateId, VehicleType vehicleType, String vehicleNumber)
      throws InvalidGateException, NoAvailableSpotException, ParkingLotNotFoundException {

    Optional<Gate> gateOptional = gateRepository.findGateById(gateId);

    if (gateOptional.isEmpty()) {
      throw new InvalidGateException();
    }

    Gate gate = gateOptional.get();

    Operator operator = gate.getOperator();

    Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByNumber(vehicleNumber);
    Vehicle vehicle;

    vehicle =
        vehicleOptional.orElseGet(() -> vehicleService.createVehicle(vehicleNumber, vehicleType));

    Optional<ParkingLot> parkingLotOptional = parkingLotRepository.getParkingLotOfGate(gate);

    if (parkingLotOptional.isEmpty()) {
      throw new ParkingLotNotFoundException();
    }

    ParkingLot parkingLot = parkingLotOptional.get();

    Optional<ParkingSpot> parkingSpotOptional =
        spotAssignmentStrategy.findSpot(parkingLot, vehicleType, gate);

    if (parkingSpotOptional.isEmpty()) {
      throw new NoAvailableSpotException();
    }

    ParkingSpot parkingSpot = parkingSpotOptional.get();

    Ticket ticket = new Ticket();
    ticket.setEntryTime(new Date());
    ticket.setGate(gate);
    ticket.setOperator(operator);
    ticket.setParkingSpot(parkingSpot);
    ticket.setVehicle(vehicle);

    ticket = ticketRepository.save(ticket);

    return ticket;
  }
}
