package com.parkinglot.repositories;

import com.parkinglot.models.Ticket;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class TicketRepository {
  private Map<Long, Ticket> tickets = new TreeMap<>();
  private long lastSavedId = 0L;
  public Ticket save(Ticket ticket) {
    ticket.setId(lastSavedId + 1);
    ticket.setUpdatedAt(new Date());
    lastSavedId+=1;
    tickets.put(lastSavedId,ticket);
    return ticket;
  }
}
