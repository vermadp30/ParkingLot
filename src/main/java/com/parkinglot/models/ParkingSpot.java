package com.parkinglot.models;

import com.parkinglot.enums.SpotStatus;
import com.parkinglot.enums.VehicleType;
import java.util.List;
import java.util.Set;

public class ParkingSpot extends BaseModel {
  private int number;
  private Set<VehicleType> supportedVehicleType;
  private SpotStatus spotStatus;
  private Vehicle vehicle;

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public Set<VehicleType> getSupportedVehicleType() {
    return supportedVehicleType;
  }

  public void setSupportedVehicleType(Set<VehicleType> supportedVehicleType) {
    this.supportedVehicleType = supportedVehicleType;
  }

  public SpotStatus getSpotStatus() {
    return spotStatus;
  }

  public void setSpotStatus(SpotStatus spotStatus) {
    this.spotStatus = spotStatus;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }
}
