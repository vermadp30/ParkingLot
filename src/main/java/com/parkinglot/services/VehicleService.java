package com.parkinglot.services;

import com.parkinglot.enums.VehicleType;
import com.parkinglot.models.Vehicle;
import com.parkinglot.repositories.VehicleRepository;

public class VehicleService {
  private VehicleRepository vehicleRepository;

  public VehicleService(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  public Vehicle createVehicle(String vehicleNumber, VehicleType vehicleType) {
    Vehicle vehicle = new Vehicle();
    vehicle.setVehicleNumber(vehicleNumber);
    vehicle.setVehicleType(vehicleType);
    vehicle = vehicleRepository.save(vehicle);
    return vehicle;
  }
}
