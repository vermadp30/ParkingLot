package com.parkinglot.strategies.spotassignmentstrategy;

import com.parkinglot.enums.VehicleType;
import com.parkinglot.models.Gate;
import com.parkinglot.models.ParkingLot;
import com.parkinglot.models.ParkingSpot;
import java.util.Optional;

public interface SpotAssignmentStrategy {
    Optional<ParkingSpot> findSpot(ParkingLot parkingLot, VehicleType vehicleType, Gate entryGate);
}
