package com.parkinglot.strategies.spotassignmentstrategy;

import com.parkinglot.enums.SpotStatus;
import com.parkinglot.enums.VehicleType;
import com.parkinglot.models.Gate;
import com.parkinglot.models.ParkingFloor;
import com.parkinglot.models.ParkingLot;
import com.parkinglot.models.ParkingSpot;

import java.util.Optional;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {

  @Override
  public Optional<ParkingSpot> findSpot(
      ParkingLot parkingLot, VehicleType vehicleType, Gate entryGate) {
    for (ParkingFloor parkingFloor : parkingLot.getParkingFloors()) {
      for (ParkingSpot parkingSpot : parkingFloor.getParkingSpots()) {
        if (parkingSpot.getSpotStatus().equals(SpotStatus.VACANT)
            && parkingSpot.getSupportedVehicleType().contains(vehicleType)) {
          return Optional.of(parkingSpot);
        }
      }
    }
    return Optional.empty();
  }
}
