package com.parkinglot.repositories;

import com.parkinglot.models.Vehicle;

import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepository {

  private Map<Long, Vehicle> vehicles = new TreeMap<>();
  private Long lastSavedId = 1L;

  public Optional<Vehicle> findVehicleByNumber(String vehicleNumber) {
    for (Vehicle vehicle : vehicles.values()) {
      if (vehicle.getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
        return Optional.of(vehicle);
      }
    }
    return Optional.empty();
  }

  public Vehicle save(Vehicle vehicle) {
    vehicle.setId(lastSavedId + 1);
    lastSavedId += 1;
    vehicle.setUpdatedAt(new Date());
    vehicles.put(lastSavedId, vehicle);
    return vehicle;
  }
}
