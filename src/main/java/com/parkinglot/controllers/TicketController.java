package com.parkinglot.controllers;

import com.parkinglot.dto.GenerateTicketRequestDto;
import com.parkinglot.dto.GenerateTicketResponseDto;
import com.parkinglot.enums.ResponseStatus;
import com.parkinglot.enums.VehicleType;
import com.parkinglot.exception.InvalidGateException;
import com.parkinglot.exception.NoAvailableSpotException;
import com.parkinglot.exception.ParkingLotNotFoundException;
import com.parkinglot.models.Ticket;
import com.parkinglot.services.TicketService;

public class TicketController {
  private TicketService ticketService;

  public TicketController(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto request) {
    String vehicleNumber = request.getVehicleNumber();
    VehicleType vehicleType = request.getVehicleType();
    Long gateId = request.getGateId();

    Ticket ticket;
    GenerateTicketResponseDto response = new GenerateTicketResponseDto();

    try {
      ticket = ticketService.generateTicket(gateId, vehicleType, vehicleNumber);
    } catch (InvalidGateException exception) {
      response.setResponseStatus(ResponseStatus.FAILURE);
      response.setMessage("Gate Id is invalid");
      return response;
    } catch (NoAvailableSpotException exception) {
      response.setResponseStatus(ResponseStatus.FAILURE);
      response.setMessage("Parking Lot is full. No empty spot.");
      return response;
    } catch (ParkingLotNotFoundException exception) {
      response.setResponseStatus(ResponseStatus.FAILURE);
      response.setMessage("Parking Lot not found");
      return response;
    }

    response.setResponseStatus(ResponseStatus.SUCCESS);
    response.setTicketId(ticket.getId());
    response.setOperatorName(ticket.getOperator().getName());
    response.setSpotNumber(ticket.getParkingSpot().getNumber());
    return response;
  }
}
