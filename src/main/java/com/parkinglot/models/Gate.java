package com.parkinglot.models;

import com.parkinglot.enums.GateStatus;
import com.parkinglot.enums.GateType;

public class Gate extends BaseModel {
  private int gateNumber;
  private GateType gateType;
  private GateStatus gateStatus;
  private Operator operator;

  public int getGateNumber() {
    return gateNumber;
  }

  public void setGateNumber(int gateNumber) {
    this.gateNumber = gateNumber;
  }

  public GateType getGateType() {
    return gateType;
  }

  public void setGateType(GateType gateType) {
    this.gateType = gateType;
  }

  public GateStatus getGateStatus() {
    return gateStatus;
  }

  public void setGateStatus(GateStatus gateStatus) {
    this.gateStatus = gateStatus;
  }

  public Operator getOperator() {
    return operator;
  }

  public void setOperator(Operator operator) {
    this.operator = operator;
  }
}
