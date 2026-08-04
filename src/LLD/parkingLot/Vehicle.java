package LLD.parkingLot;

public abstract class Vehicle {
    private final String licensePlate;
    private final VehicleType vehicleType;

    public Vehicle(String licensePlate,VehicleType type){
        this.licensePlate=licensePlate;
        this.vehicleType=type;
    }

    public String getLicensePlate(){
        return licensePlate;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }
}
