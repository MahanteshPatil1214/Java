package LLD.parkingLot;

import java.util.concurrent.locks.ReentrantLock;

public class ParkingSpot {
    private final String spotId;
    private final SpotType spotType;
    private Vehicle currentVehicle;
    private boolean isOccupied;
    private final ReentrantLock lock = new ReentrantLock(true);

    public String getSpotId() {
        return spotId;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public ParkingSpot(String spotId, SpotType spotType){
        this.spotId=spotId;
        this.spotType=spotType;
        this.isOccupied=false;
    }

    public boolean parkVehicle(Vehicle vehicle){
        lock.lock();
        try {
            if(isOccupied) return false;
            this.currentVehicle=vehicle;
            this.isOccupied=true;
            return true;
        }
        finally {
            lock.unlock();
        }
    }

    public void vacateVehicle(){
        lock.lock();;
        try{
            this.currentVehicle=null;
            this.isOccupied=false;
        }
        finally {
            lock.unlock();;
        }
    }

    public boolean canFitVehicle(Vehicle vehicle){
        return switch (vehicle.getVehicleType()) {
            case MOTORCYCLE -> true;
            case CAR -> spotType == SpotType.MEDIUM || spotType == SpotType.LARGE;
            case TRUCK -> spotType == SpotType.LARGE;
            default -> false;
        };
    }



}
