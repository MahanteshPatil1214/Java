package LLD.parkingLot;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingFloor {
    private final int floorNumber;
    public final List<ParkingSpot> spots;

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public ParkingFloor(int floorNumber, List<ParkingSpot> spots) {
        this.floorNumber = floorNumber;
        this.spots = spots;
    }

    public void displayAvailability(){
        System.out.println("------Floor " + floorNumber + " Availability ---");
        Map<SpotType,Integer> counts = new ConcurrentHashMap<>();
        for (ParkingSpot spot:spots){
            if(!spot.isOccupied()){
                counts.put(spot.getSpotType(),counts.getOrDefault(spot.getSpotType(),0)+1);
            }
        }
        counts.forEach((type,count) -> System.out.println(type + ": " + count + " free"));
    }
}
