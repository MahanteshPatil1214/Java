package LLD.parkingLot;

import java.util.List;
import java.util.Optional;

public class FirstAvailableStrategy implements ParkingStrategy{
    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            for (ParkingSpot spot : floor.getSpots()) {
                if (!spot.isOccupied() && spot.canFitVehicle(vehicle)) {
                    return Optional.of(spot);
                }
            }
        }
        return Optional.empty();
    }

}

