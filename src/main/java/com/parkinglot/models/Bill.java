package com.parkinglot.models;

import java.util.Date;

public class Bill extends BaseModel {
  private Date exitTime;
  private Ticket ticket;
  private Operator operator;
  private Gate exitGate;
  private int amount;

  public Date getExitTime() {
    return exitTime;
  }

  public void setExitTime(Date exitTime) {
    this.exitTime = exitTime;
  }

  public Ticket getTicket() {
    return ticket;
  }

  public void setTicket(Ticket ticket) {
    this.ticket = ticket;
  }

  public Operator getOperator() {
    return operator;
  }

  public void setOperator(Operator operator) {
    this.operator = operator;
  }

  public Gate getExitGate() {
    return exitGate;
  }

  public void setExitGate(Gate exitGate) {
    this.exitGate = exitGate;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }
}
